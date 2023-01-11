package com.iuvity.security.controller;

import com.iuvity.dto.utils.Mensaje;
import com.iuvity.entity.models.ProductoEntity;
import com.iuvity.entity.models.TipoMovimientoEntity;
import com.iuvity.security.dto.request.AuthenticationRequest;
import com.iuvity.security.dto.request.RegisterRequest;
import com.iuvity.security.dto.response.AuthenticationResponse;
import com.iuvity.security.entity.User;
import com.iuvity.security.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
