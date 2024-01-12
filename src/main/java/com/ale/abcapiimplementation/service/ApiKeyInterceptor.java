package com.ale.abcapiimplementation.service;

import com.ale.abcapiimplementation.dto.ErrorBodyMessage;
import com.ale.abcapiimplementation.repository.ApiKeyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor  implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "apiKey";

    @Autowired
    ApiKeyRepository apiKeyRepository;

    private volatile String apiKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (apiKey == null) {
            apiKey = apiKeyRepository.findAll().get(0).getCodeAccess();
        }

        String headerApiKey = request.getHeader(API_KEY_HEADER);
        if (this.apiKey.equals(headerApiKey)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(new ErrorBodyMessage("g103", "No Autorizado")));

            return false;
        }
    }

}
