package com.hkjava.demofake.mapper;

import com.hkjava.demofake.model.User;
import com.hkjava.demofake.model.UserDTO;
import com.hkjava.demofake.model.User.Name;

public class MapUser {

  public static UserDTO map(User user) {
    Name name = user.getName();
    return UserDTO.builder()//
        .username(user.getUsername())//
        .password(user.getPassword())//
        .id(user.getId())//
        .name(UserDTO.Name.builder()//
            .firstname(name.getFirstname())//
            .lastname(name.getLastname())//
            .build())//
        .build();

    // return userDTO;
  }

}
