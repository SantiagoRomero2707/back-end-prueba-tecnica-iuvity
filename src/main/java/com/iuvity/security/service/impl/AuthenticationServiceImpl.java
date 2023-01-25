package com.iuvity.security.service.impl;


import com.iuvity.entity.models.ProductoEntity;
import com.iuvity.security.dto.request.AuthenticationRequest;
import com.iuvity.security.dto.request.RegisterRequest;
import com.iuvity.security.entity.Role;
import com.iuvity.security.entity.User;
import com.iuvity.security.entity.UserRepository;
import com.iuvity.security.jwt.JwtService;
import com.iuvity.security.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    if(request.getRole() == null){
      var user = User.builder()
              .firstname(request.getFirstname())
              .lastname(request.getLastname())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .role(Role.valueOf("USER"))
              .build();
      repository.save(user);
      var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }
      var user = User.builder()
              .firstname(request.getFirstname())
              .lastname(request.getLastname())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .role(Role.valueOf(request.getRole()))
              .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();

  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .authorities(user.getAuthorities())
        .build();
  }

  @Transactional
  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }

}
