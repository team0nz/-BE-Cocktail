package com.application.common.auth.service;

import com.application.common.auth.dto.SocialLoginDto;
import com.application.common.auth.dto.oauth2Dto.ResponseTokenDto;
import com.application.common.auth.jwt.JWTUtil;
import com.application.common.exception.custom.CustomApiException;
import com.application.common.exception.custom.TokenInvalidException;
import com.application.domain.member.entity.Member;
import com.application.domain.member.enums.Role;
import com.application.domain.member.repository.MemberRepository;
import com.application.web.services.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class OAuth2Service {

    private final RestTemplate restTemplate;
    private final JWTUtil jwtUtil;
    private final MemberService memberService;
    private final JWTStoreService jwtStoreService;
    private final OAuth2TokenService oAuth2TokenService;
    private final JWTAccessTokenBlackListService jwtAccessTokenBlackListService;

    public ResponseTokenDto socialLogin(SocialLoginDto socialLoginDto){


        Map<String, Object> userInfo = getUserInfo(socialLoginDto.getProvider(), socialLoginDto.getCode(), socialLoginDto.getState());

        if(userInfo == null || userInfo.isEmpty()){
            throw new TokenInvalidException("Fail Social Login");
        }

        return getTokenAndSaveMember(socialLoginDto.getProvider(), userInfo);

    }

    public ResponseTokenDto reissueRefreshToken(String refreshToken){
        checkRefreshToken(refreshToken);
        return updateRefreshToken(refreshToken);
    }

    public void logout(String fullAccessToken){
        String accessToken = fullAccessToken.substring(7);
        if (jwtStoreService.containKey(jwtUtil.getUUID(accessToken))){
            jwtStoreService.deleteByKey(jwtUtil.getUUID(accessToken));
            jwtAccessTokenBlackListService.addBlackList(jwtUtil.getUUID(accessToken), accessToken);
        }else{
            jwtAccessTokenBlackListService.addBlackList(jwtUtil.getUUID(accessToken), accessToken);
        }
    }

    private Map<String, Object> getUserInfo(String provider, String code, String state){
        if("google".equalsIgnoreCase(provider)){
            String accessToken = oAuth2TokenService.getAccessTokenFromGoogle(code);
            return getUserInfoFromGoogle(accessToken);
        }else if("naver".equalsIgnoreCase(provider)){
            String accessToken = oAuth2TokenService.getAccessTokenFromNaver(code, state);
            return getUserInfoFromNaver(accessToken);
        }else{
            return null;
        }

    }

    private Map<String, Object> getUserInfoFromGoogle(String accessToken){
        String userInfoEndpoint = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken;
        return restTemplate.getForObject(userInfoEndpoint, Map.class);
    }

    private Map<String, Object> getUserInfoFromNaver(String accessToken){
        String userInfoEndpoint = "https://openapi.naver.com/v1/nid/me";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpoint, HttpMethod.GET, entity, Map.class);

        return (Map<String,Object>)response.getBody().get("response");
    }


    private ResponseTokenDto getTokenAndSaveMember(String provider, Map<String, Object> userInfo){

        saveOrUpdate(userInfo, provider);

        String uuid = UUID.randomUUID().toString();
        String accessToken = jwtUtil.createAccessJwt(uuid, getCredentialId(userInfo, provider),Role.USER.getEnglish());
        String refreshToken = jwtUtil.createRefreshJwt(uuid, getCredentialId(userInfo, provider), Role.USER.getEnglish());

        jwtStoreService.save(jwtUtil.getUUID(refreshToken), refreshToken);

        log.info("uuid: " + jwtUtil.getUUID(refreshToken));
        log.info("jwtToken : " + accessToken);
        log.info("refreshToken : " + jwtStoreService.findByKey(jwtUtil.getUUID(refreshToken)).getRefreshToken());

        return new ResponseTokenDto(accessToken, refreshToken);
    }

    private void saveOrUpdate(Map<String, Object> userInfo, String provider){
        String creadentialId = getCredentialId(userInfo, provider);
        Member existMember = memberService.getMemberByCredentialId(creadentialId);


        if (existMember == null){
            String name = (userInfo.get("name") != null) ? (String)userInfo.get("name") : "no name";
            Member newMember = new Member();

            newMember.setCreadentialId(creadentialId);
            newMember.setName(name);
            newMember.setNickname(name);
            newMember.setEmail((String)userInfo.get("email"));
            newMember.setRole(Role.USER);

            memberService.saveMember(newMember);
        }else{
            existMember.setEmail((String)userInfo.get("email"));
        }
    }

    private String getCredentialId(Map<String, Object>userInfo, String provider){
        if (provider.equalsIgnoreCase("naver")){
            return provider + userInfo.get("id").toString();
        }else if(provider.equalsIgnoreCase("google")){
            return provider + userInfo.get("id").toString();
        }else{
            return "";
        }
    }


    private void checkRefreshToken(String refreshToken){
        String uuid = jwtUtil.getUUID(refreshToken);
        if(jwtUtil.isRefreshExpired(refreshToken) || !jwtStoreService.containKey(uuid)){
            throw new TokenInvalidException("Refresh Token Expired");
        }else{
            jwtStoreService.deleteByKey(uuid);
        }
    }

    private ResponseTokenDto updateRefreshToken(String refreshToken){
        String uuid = UUID.randomUUID().toString();
        String newAccessToken = jwtUtil.createAccessJwt(uuid, jwtUtil.getCredentialId(refreshToken),jwtUtil.getRole(refreshToken) );
        String newRefreshToken = jwtUtil.createRefreshJwt(uuid, jwtUtil.getCredentialId(refreshToken),jwtUtil.getRole(refreshToken) );
        log.info("new Refresh Key : " + newRefreshToken);

        jwtStoreService.save(uuid, newRefreshToken);

        return new ResponseTokenDto(newAccessToken, newRefreshToken);
    }

}
