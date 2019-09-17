package com.book.medecinebook.confins;


import com.book.medecinebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {
    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"main/resources/**").permitAll()
                .antMatchers(HttpMethod.GET,"main/resources/static/**").permitAll()
                .antMatchers(HttpMethod.GET,"main/resources/static/*").permitAll()
                .antMatchers(HttpMethod.GET,"/**").permitAll()
                .antMatchers(HttpMethod.GET,"/*").permitAll()
                .antMatchers(HttpMethod.GET, "/authUser").permitAll()
                .antMatchers(HttpMethod.POST, "/test").permitAll()
                .antMatchers(HttpMethod.GET, "/home").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/create/patient").permitAll()
                .antMatchers(HttpMethod.POST, "/create/doctor").permitAll()
                .antMatchers(HttpMethod.POST, "/create/laboratory").permitAll()
                .antMatchers(HttpMethod.POST, "/create/user/photo").permitAll()
//                .antMatchers(HttpMethod.GET, "/create/user/photo").permitAll()
                .antMatchers(HttpMethod.GET, "/patients").hasRole("PATIENT")
                .antMatchers(HttpMethod.GET, "/doctors").hasRole("DOCTOR")
                .antMatchers(HttpMethod.GET, "/laboratories").hasRole("LABORATORY")
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new RequestProcessingJWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new LoginFilter("/login", authenticationManager(), userDetailsService), UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

