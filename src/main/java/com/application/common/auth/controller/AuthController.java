package com.application.common.auth.controller;


import com.application.common.Constant;
import com.application.common.auth.dto.SocialLoginDto;
import com.application.common.auth.dto.oauth2Dto.ResponseTokenDto;
import com.application.common.auth.service.OAuth2Service;
import com.application.common.response.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2Service oAuth2Service;

    @PostMapping("/api/auth/refresh")
    public ResponseEntity<?> reissueRefreshToken(HttpServletRequest request){
        String refreshToken = request.getHeader("Refresh-Token");
        ResponseTokenDto responseTokenDto = oAuth2Service.reissueRefreshToken(refreshToken);
        return new ResponseEntity<>(new ResponseDto<>(Constant.SUCCESS_CODE, "access token and refersh token reissue.", responseTokenDto), HttpStatus.OK);
    }

    @PostMapping("/api/auth/social-login")
    public ResponseEntity<?> socialLogin(@Valid @RequestBody SocialLoginDto socialLoginDto, BindingResult bindingResult){
        ResponseTokenDto responseTokenDto = oAuth2Service.socialLogin(socialLoginDto);
        return new ResponseEntity<>(new ResponseDto<>(Constant.SUCCESS_CODE, "access token , refresh token create", responseTokenDto), HttpStatus.CREATED);
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        oAuth2Service.logout(request.getHeader("Authorization"));
        return new ResponseEntity<>(new ResponseDto<>(Constant.SUCCESS_CODE, "logout", null), HttpStatus.OK);
    }


}
