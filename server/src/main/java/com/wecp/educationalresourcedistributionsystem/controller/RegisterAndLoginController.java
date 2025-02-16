package com.wecp.educationalresourcedistributionsystem.controller;


import com.wecp.educationalresourcedistributionsystem.dto.LoginRequest;
import com.wecp.educationalresourcedistributionsystem.dto.LoginResponse;
import com.wecp.educationalresourcedistributionsystem.entity.User;
import com.wecp.educationalresourcedistributionsystem.jwt.JwtUtil;
import com.wecp.educationalresourcedistributionsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


public class RegisterAndLoginController {


    @PostMapping("/api/user/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // register the user and return the registered user with status code 201 CREATED.
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        // login user and return the login response with status code 200 ok
        // if authentication fails, return status code 401 unauthorized
    }
}
