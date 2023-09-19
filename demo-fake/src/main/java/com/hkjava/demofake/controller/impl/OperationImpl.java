package com.hkjava.demofake.controller.impl;

import java.security.Provider.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demofake.controller.FakeOperation;
import com.hkjava.demofake.infra.ApiResponse;
import com.hkjava.demofake.infra.EnumCode;
import com.hkjava.demofake.mapper.MapUser;
import com.hkjava.demofake.model.User;
import com.hkjava.demofake.model.UserDTO;
import com.hkjava.demofake.service.FakeService;


@RestController
@RequestMapping(value = "/api/v1")
public class OperationImpl implements FakeOperation {

  @Autowired
  private FakeService fakeService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() {
    List<User> users = fakeService.findUsers();

    // return ApiResponse.<List<User>>builder()//
    // .status(EnumCode.OK)//
    // .data(users)//
    // .build();

    List<UserDTO> userDTOs = users.stream()//
        .map(e -> MapUser.map(e))//
        .collect(Collectors.toList());


    ApiResponse<List<UserDTO>> apiResponse =
        ApiResponse.<List<UserDTO>>builder()//
            .status(EnumCode.OK)//
            .data(userDTOs)//
            .build();

    return ResponseEntity.ok().body(apiResponse);

  }

}
