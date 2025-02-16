package com.wecp.educationalresourcedistributionsystem.config;

import com.wecp.educationalresourcedistributionsystem.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtRequestFilter jwtRequestFilter,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/institution/event").hasAuthority("institution")
                .antMatchers(HttpMethod.GET, "/api/institution/events").permitAll()
                .antMatchers(HttpMethod.POST, "/api/institution/resource").hasAuthority("institution")
                .antMatchers(HttpMethod.GET, "/api/institution/resources").hasAuthority("institution")
                .antMatchers(HttpMethod.POST, "/api/institution/event/allocate-resources").hasAuthority("institution")
                .antMatchers(HttpMethod.DELETE, "/api/institution/event/{eventId}").hasAuthority("institution")
                .antMatchers(HttpMethod.GET, "/api/institution/event/allocated-resources/{eventId}").permitAll()
                .antMatchers(HttpMethod.GET, "/api/educator/agenda").hasAuthority("educator")
                .antMatchers(HttpMethod.PUT, "/api/educator/update-material/{eventId}").hasAuthority("educator")
                .antMatchers(HttpMethod.POST, "/api/student/register/{eventId}").hasAuthority("student")
                .antMatchers(HttpMethod.GET, "/api/student/registration-status/{studentId}").hasAuthority("student")

                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}