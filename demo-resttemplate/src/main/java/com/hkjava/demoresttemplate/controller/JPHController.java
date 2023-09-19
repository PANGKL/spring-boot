package com.hkjava.demoresttemplate.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.hkjava.demoresttemplate.infra.ApiResponse;
import com.hkjava.demoresttemplate.model.Comment;
import com.hkjava.demoresttemplate.model.Post;
import com.hkjava.demoresttemplate.model.Todo;
import com.hkjava.demoresttemplate.model.User;
import com.hkjava.demoresttemplate.model.UserDTO;
import jakarta.websocket.server.PathParam;

public interface JPHController {

  @GetMapping(value = "/users") // getmapping通常鎖定係contract
  ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception;

  @GetMapping(value = "/todos")
  List<Todo> findTodos();

  @GetMapping(value = "/users/{id}")
  User getUserById(@PathVariable(name = "id") int id) throws Exception;

  @GetMapping(value = "/posts")
  List<Post> findPosts();

  @GetMapping(value = "/comments")
  List<Comment> findComments();

  @GetMapping(value = "/posts/{id}")
  List<Post> findPostByid(@PathVariable(value = "id") int id);

  @GetMapping(value = "/comments/{id}")
  List<Comment> findCommentByid(@PathVariable(value = "id") int postid);



}
