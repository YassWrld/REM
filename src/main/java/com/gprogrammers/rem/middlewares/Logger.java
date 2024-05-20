package com.gprogrammers.rem.middlewares;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Logger implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        String message = String.format("%s request to path %s on %s", req.getMethod(), req.getRequestURI(), new Date());
        res.setHeader("Access-Control-Allow-Origin", "*"); // Replace "*" with a specific origin if needed
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        res.setHeader("Access-Control-Max-Age", "86400"); // Cache preflight response for 1 day

        System.out.println(message);
        try {
            chain.doFilter(request, response); // Continue the filter chain
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
