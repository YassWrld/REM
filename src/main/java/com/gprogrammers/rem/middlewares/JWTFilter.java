package com.gprogrammers.rem.middlewares;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.AgentService;
import com.gprogrammers.rem.types.ApiErrorResponse;
import com.gprogrammers.rem.utils.JWTUtil;
import com.mongodb.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    private final AgentService agentService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {


        String method=request.getMethod();
        if(method.equals("OPTIONS")) {
            response.setStatus(204);
            return;
        }

        String path = request.getRequestURI();


       String authPath = "/auth/login";

       String staticPath = "/media";
        if (path.startsWith(authPath) || path.startsWith(staticPath)) {
            filterChain.doFilter(request, response);
            return;
        }


        ApiErrorResponse errorResponse = new ApiErrorResponse();


        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse.setError("Authorization header not found");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(errorResponse.toString());
            return;


        }


        String token = authorizationHeader.replace("Bearer ", "").trim();

        boolean isValid = jwtUtil.validateToken(token);

        if (!isValid) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse.setError("Invalid token");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(errorResponse.toString());
            return;

        }

        String id = jwtUtil.extractId(token);

        if (id == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse.setError("Invalid token");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(errorResponse.toString());
            return;
        }

        AgentModel agentAuth = agentService.getAgentById(id);

        if (agentAuth == null) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse.setError("Agent not found");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(errorResponse.toString());
            return;

        }

        if (!agentAuth.isSupervisor() && path.startsWith("/agent")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse.setError("Agent not authorized");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(errorResponse.toString());
            return;

        }

        request.setAttribute("authid", id);


        filterChain.doFilter(request, response);
    }


}
