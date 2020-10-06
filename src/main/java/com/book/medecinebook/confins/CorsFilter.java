package com.book.medecinebook.confins;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {
    static final String ORIGIN = "*";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println(request.getHeader(ORIGIN));
        System.out.println(request.getMethod());
        if (request.getHeader(ORIGIN) == null) {
            response.addHeader("Access-Control-Allow-Origin", "*");// * or
            // origin as
            // u prefer
            response.addHeader("Access-Control-Allow-Credentials", "false");
            response.addHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE");

            response.addHeader("Access-Control-Allow-Headers",
                    request.getHeader("Access-Control-Request-Headers"));
        } else {
            response.addHeader("Access-Control-Allow-Origin", request.getHeader(ORIGIN));// * or
            // origin as
            // u prefer
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE");

            response.addHeader("Access-Control-Allow-Headers",
                    request.getHeader("Access-Control-Request-Headers"));
        }
        if (request.getMethod().equals("OPTIONS")) {
            try {
                response.getWriter().print("OK");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
