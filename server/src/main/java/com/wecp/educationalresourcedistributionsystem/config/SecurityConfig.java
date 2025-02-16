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


public class SecurityConfig  {

        // TODO: implement the security configuration

        // configure CORS and CSRF
        // configure the routes that are accessible without authentication
        // configure the routes that are accessible with specific authority
        // set the permission w.r.t to authorities
        // - /api/user/register: accessible to everyone
        // - /api/user/login: accessible to everyone
        // - /api/institution/event: accessible to INSTITUTION authority
        // - /api/institution/events: accessible to INSTITUTION authority
        // - /api/institution/resource: accessible to INSTITUTION authority
        // - /api/institution/resources: accessible to INSTITUTION authority
        // - /api/institution/event/allocate-resources: accessible to INSTITUTION authority
        // - /api/educator/agenda: accessible to EDUCATOR authority
        // - /api/educator/update-material/{eventId}: accessible to EDUCATOR authority
        // - /api/student/register/{eventId}: accessible to STUDENT authority
        // - /api/student/registration-status/{studentId}: accessible to STUDENT authority
        // - any other route: accessible to authenticated users
        // configure the session management
        // add the jwtRequestFilter before the UsernamePasswordAuthenticationFilter
    
}