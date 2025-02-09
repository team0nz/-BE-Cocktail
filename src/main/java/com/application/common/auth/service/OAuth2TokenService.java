package com.application.common.auth.service;


import com.application.common.auth.config.OAuth2PropertiesValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2TokenService {
    private final RestTemplate restTemplate;
    private final OAuth2PropertiesValue oAuth2PropertiesValue;

    public String getAccessTokenFromGoogle(String code){
        return (String)getAccessToken(oAuth2PropertiesValue.getGoogleTokenUri(),
                oAuth2PropertiesValue.getGoogleClientId(),
                oAuth2PropertiesValue.getGoogleClientSecret(),
                oAuth2PropertiesValue.getGoogleRedirectUri(),
                code,
                null).get("access_token");
    }

    public String getAccessTokenFromNaver(String code, String state){
        return (String)getAccessToken(oAuth2PropertiesValue.getNaverTokenUri(),
                oAuth2PropertiesValue.getNaverClientId(),
                oAuth2PropertiesValue.getNaverClientSecret(),
                oAuth2PropertiesValue.getNaverRedirectUri(),
                code,
                state).get("access_token");
    }

    public Map<String, Object> getAccessToken(String tokenUri,
                                              String clientId,
                                              String clientSecret,
                                              String redirectUri,
                                              String code,
                                              String state){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("redirect_uri", redirectUri);
        body.add("code", code);
        if(state != null){
            body.add("state", state);
        }

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body,headers);

        ResponseEntity<Map> response = restTemplate.exchange(tokenUri, HttpMethod.POST, requestEntity, Map.class);

        return response.getBody();
    }
}
