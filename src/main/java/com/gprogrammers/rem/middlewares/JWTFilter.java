package com.gprogrammers.rem.middlewares;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import com.gprogrammers.rem.utils.JWTUtil;


@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        if(path.startsWith("/auth")){
            filterChain.doFilter(request, response);
            return;
        }

        final String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader==null || !authorizationHeader.startsWith("Bearer ")){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        String token = authorizationHeader.replace("Bearer ", "").trim();

        boolean isValid=jwtUtil.validateToken(token);

        if(!isValid){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String id=jwtUtil.extractId(token);

        if(id==null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }




        filterChain.doFilter(request, response);
    }
}
