package com.appointment.server.exception;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(403);
        response.setContentType("application/json");
        response.getWriter().write(String.format("{\"status\": \"%s\",\"error\":\"%s\"}", HttpStatus.FORBIDDEN.getReasonPhrase(),accessDeniedException.getMessage()));
    }
}
