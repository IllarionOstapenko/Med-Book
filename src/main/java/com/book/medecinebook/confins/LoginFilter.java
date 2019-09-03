package com.book.medecinebook.confins;

import com.book.medecinebook.models.Patient;
import com.book.medecinebook.models.User;
import com.book.medecinebook.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    private UserService userDetailsService;

    public LoginFilter(String url, AuthenticationManager authManager, UserService userDetailsService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.userDetailsService = userDetailsService;
//        System.out.println(userDetailsService + " userDetailsService");
//        System.out.println(authManager + " authManager");
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        //this method react  on /login url  and retrive body from request
        //then map it to model AccountCredential
        User user = new ObjectMapper()
                .readValue(httpServletRequest.getInputStream(), User.class);
//        System.out.println(user + "LOGIN FILTER");
        // then  get default method getAuthenticationManager()
        // and set Authentication object based on data from creds object

        // if auth process if success we jump to line 65 successfulAuthentication()
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.emptyList()
                )
        );


    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        // if in prev method we was authenticate
        // we create token
        UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
        String jwt_user_token = userDetails.getUsername() + " ";
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            jwt_user_token += authority.getAuthority();
        }
        System.out.println(jwt_user_token);

        String jwtoken = Jwts.builder()
                .setSubject(jwt_user_token)
                .signWith(SignatureAlgorithm.HS512, "yes".getBytes())
                .setExpiration(new Date(System.currentTimeMillis() + 200000))
                .compact();
        //and add it to header
        System.out.println(jwtoken + " jwtoken");
        res.addHeader("Authorization", "Bearer " + jwtoken);

    }
}
