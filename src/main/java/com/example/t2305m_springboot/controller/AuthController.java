package com.example.t2305m_springboot.controller;

import com.example.t2305m_springboot.dto.req.LoginUser;
import com.example.t2305m_springboot.dto.req.RegisterUser;
import com.example.t2305m_springboot.dto.res.LoginResponse;
import com.example.t2305m_springboot.entity.User;
import com.example.t2305m_springboot.service.AuthenticationService;
import com.example.t2305m_springboot.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    public AuthController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUser req){
        User user = authenticationService.signup(req);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUser req){
        User  user = authenticationService.authenticate(req);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse rs = new LoginResponse();
        rs.setToken(jwtToken);
        return ResponseEntity.ok(rs);
    }
}