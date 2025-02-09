package com.application.common.auth.jwt;


import com.application.common.Constant;
import com.application.common.auth.dto.oauth2Dto.CustomOAuth2User;
import com.application.common.auth.dto.oauth2Dto.UserDTO;
import com.application.common.auth.service.JWTAccessTokenBlackListService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final JWTAccessTokenBlackListService jwtAccessTokenBlackListService;

    private final static List<String> EXCLUDE_PATH =  List.of(
        "/api/auth/refresh", "/api/auth/social-login",
        "/login/oauth2/code/google", "/login/oauth2/code/naver",
        "/api/auth/naver/token", "/api/auth/google/token",
        "/api/auth/naver/login-url", "/api/auth/google/login-url",
        "/api/public/"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(isExcludedPath(request.getRequestURI())){
            log.info("Skipping JWTFilter : {}", request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getAccessToken(request);

        if(accessToken == null){
            log.info("accessToken null");
            sendErrorResponse(response, Constant.ERROR_CODE, HttpServletResponse.SC_BAD_REQUEST, "Access Token 값이 헤더에 존재하지 않음");
            return;
        }

        if(jwtUtil.isAccessExpired(accessToken)){
            log.info("Access Token expire");
            sendErrorResponse(response, Constant.NEED_REFRESH_TOKEN_CODE, HttpServletResponse.SC_UNAUTHORIZED,"Access Token Expired");
            return;
        }

        log.info("jwt filter [accessToken UUID] : {}", jwtUtil.getUUID(accessToken));
        String blackListToken = jwtAccessTokenBlackListService.getAccessTokenFromBlackList(jwtUtil.getUUID(accessToken));

        if(blackListToken != null){
            log.info("Access Token already logout");
            sendErrorResponse(response, Constant.ERROR_CODE, HttpServletResponse.SC_UNAUTHORIZED, "Already logout member");
            return;
        }

        log.info("Access Token is valid");
        setSecurityContext(jwtUtil, accessToken);
        filterChain.doFilter(request, response);

    }

    private Boolean isExcludedPath(String uri){
        return EXCLUDE_PATH.contains(uri);
    }

    private void sendErrorResponse(HttpServletResponse response,int code,  int status, String message) throws IOException{
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\": "+ code +", \"msg\": \""+ message +"\", \"data\" : \"null\"}");
        response.flushBuffer();
    }



    private String getAccessToken(HttpServletRequest request){
        String accessToken = request.getHeader("Authorization");
        if (accessToken == null){
            return accessToken;
        }else{
            accessToken = accessToken.substring(7);
            return accessToken;
        }

    }


    private void setSecurityContext(JWTUtil jwtUtil, String accessToken) {
        String credentialId = jwtUtil.getCredentialId(accessToken);
        String role = jwtUtil.getRole(accessToken);

        UserDTO userDTO = new UserDTO(credentialId, role);
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(userDTO);

        Authentication authToken = new UsernamePasswordAuthenticationToken(customOAuth2User, null, customOAuth2User.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

    }
}
