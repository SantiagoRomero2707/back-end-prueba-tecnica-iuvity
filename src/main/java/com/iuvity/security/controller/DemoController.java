package com.iuvity.security.controller;

import com.iuvity.dto.utils.Mensaje;
import com.iuvity.security.dto.request.RegisterRequest;
import com.iuvity.security.entity.User;
import com.iuvity.security.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {


  private final AuthenticationServiceImpl service;

  @PostMapping("/getUser")
  public ResponseEntity<User> getUserByEmail(@RequestBody RegisterRequest request){
    String email = request.getEmail();
    System.out.println(email);
    if(service.findByEmail(email).isEmpty())
      return new ResponseEntity(new Mensaje("NO existe"), HttpStatus.NOT_FOUND);
    User user = service.findByEmail(email).get();
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
