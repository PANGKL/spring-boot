package com.hkjava.demofake.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.hkjava.demofake.infra.ApiResponse;
import com.hkjava.demofake.model.User;
import com.hkjava.demofake.model.UserDTO;


public interface FakeOperation {

  @GetMapping(value = "/users")
  ResponseEntity<ApiResponse<List<UserDTO>>> findUsers();


}
