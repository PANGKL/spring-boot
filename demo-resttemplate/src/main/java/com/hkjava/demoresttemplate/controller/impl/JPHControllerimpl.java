package com.hkjava.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demoresttemplate.controller.JPHController;
import com.hkjava.demoresttemplate.infra.ApiResponse;
import com.hkjava.demoresttemplate.infra.Code;
import com.hkjava.demoresttemplate.mapper.UserMapper;
import com.hkjava.demoresttemplate.model.Comment;
import com.hkjava.demoresttemplate.model.Post;
import com.hkjava.demoresttemplate.model.Todo;
import com.hkjava.demoresttemplate.model.User;
import com.hkjava.demoresttemplate.model.UserDTO;
import com.hkjava.demoresttemplate.service.UserService;

@RestController
@RequestMapping(value = "/api/v1") // 認class vesion
public class JPHControllerimpl implements JPHController {

  @Autowired
  private UserService userService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers()
      throws Exception {
    List<User> users = userService.findUsers();
    // findUser layer if hit exception -> GlobalException

    // Convertion (users -> DTO )
    List<UserDTO> userDTOs = users.stream()//
        .map(user -> UserMapper.map(user))//
        .collect(Collectors.toList());

    // have data
    ApiResponse<List<UserDTO>> apiResponse =
        ApiResponse.<List<UserDTO>>builder()//
            // .status(Code.OK)// .ok() //
            .ok()//
            .data(userDTOs)//
            .build();
    return ResponseEntity.ok().body(apiResponse);
  }

  @Override
  public List<Todo> findTodos() {
    return userService.findTodos();
  }

  @Override
  public User getUserById(int id) throws Exception {
    return userService.getUserById(id);
  }

  @Override
  public List<Post> findPosts() {
    return userService.findPosts();
  }

  @Override
  public List<Comment> findComments() {
    return userService.findComments();
  }


  @Override
  public List<Post> findPostByid(int id) {
    return userService.findPostByid(id);
  }

  @Override
  public List<Comment> findCommentByid(int postid) {
    return userService.findCommentByid(postid);
  }



}
