package com.gprogrammers.rem.middlewares;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
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
        String message = String.format("%s request to path %s on %s", req.getMethod(), req.getRequestURI(), new Date());
        System.out.println(message);
        try {
            chain.doFilter(request, response); // Continue the filter chain
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
