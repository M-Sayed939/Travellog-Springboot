package com.example.Travellog.Security;

import com.example.Travellog.Security.token.AccessTokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    // Request is intercepted by this method before reaching the Controller

    private AccessTokenService accessTokenService;
    public RequestInterceptor(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //* Business logic just when the request is received and intercepted by this interceptor before reaching the controller
            if (request.getRequestURI().equals("/api/login") || request.getRequestURI().equals("/api/signup")) {
                return true;
            }
            String token = request.getHeader("authorization");
            boolean isValid = accessTokenService.validateToken(token);
            if (!isValid) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return isValid;

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //* Do Nothing
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //* Do Nothing
    }
}
