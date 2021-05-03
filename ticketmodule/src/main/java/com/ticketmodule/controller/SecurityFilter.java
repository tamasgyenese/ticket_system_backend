package com.ticketmodule.controller;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Add APi_KEY-API_VALUE to response header
 */
public class SecurityFilter extends OncePerRequestFilter {

    private static final String API_VALUE="b7efbc44-991b-4f70-b8e9-48230f29e954";
    private static final String API_KEY = "API_KEY";



    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest,
                                    HttpServletResponse httpResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        httpResponse.setHeader(API_KEY, API_VALUE);
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
