package com.hkjava.demoresttemplate.mapper;

import com.hkjava.demoresttemplate.model.User;
import com.hkjava.demoresttemplate.model.UserDTO;

public class UserMapper {


  public static UserDTO map(User user) {
    return UserDTO.builder()//
        .id(user.getId())//
        .username(user.getUsername())//
        .name(user.getName())//
        .build();
  }

}
