package com.alibou.security.security.controller;

import com.alibou.security.security.dto.request.AuthenticationRequest;
import com.alibou.security.security.dto.request.RegisterRequest;
import com.alibou.security.security.dto.response.AuthenticationResponse;
import com.alibou.security.security.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationServiceImpl service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
