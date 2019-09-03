package com.book.medecinebook.confins;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RequestProcessingJWTFilter extends GenericFilterBean {

    // react on every url (but we can change it if implement another filter)
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = null;
//        System.out.println(authentication + " ++++authentication");


        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // and check presents of token in header Authorization
        String token = httpServletRequest.getHeader("Authorization");
        // if present
        if (token != null) {
            // parse it and retrive body subject from
            String user = Jwts.parser()
                    .setSigningKey("yes".getBytes())
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();
            System.out.println(user);
            String[] array = user.split(" ");
            System.out.println(array[0] + " username");
            System.out.println(array[1] + " role");
//            System.out.println(array[2] + " 2");

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(array[1]));

//            System.out.println(authorities);
            System.out.println(user + "!!!!!!!!!!!---!!!!!");

            //after parse of token we create Authentication object
            authentication = new UsernamePasswordAuthenticationToken(array[0], null, authorities/*Collections.emptyList()*/);
//            System.out.println(authentication + "authentication");
        }
        // and set it to global security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}

