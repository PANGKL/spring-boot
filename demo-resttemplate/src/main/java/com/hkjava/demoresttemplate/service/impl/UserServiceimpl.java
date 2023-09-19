package com.hkjava.demoresttemplate.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demoresttemplate.exception.JPHException;
import com.hkjava.demoresttemplate.infra.BusinessException;
import com.hkjava.demoresttemplate.infra.Code;
import com.hkjava.demoresttemplate.infra.Protocal;
import com.hkjava.demoresttemplate.model.Comment;
import com.hkjava.demoresttemplate.model.Post;
import com.hkjava.demoresttemplate.model.Todo;
import com.hkjava.demoresttemplate.model.User;
import com.hkjava.demoresttemplate.service.UserService;
import lombok.val;

@Service
public class UserServiceimpl implements UserService {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String jphDomain; // jsonplaceholder.typicode.com

  @Value(value = "${api.jsonplaceholder.endpoints.user}") // yml path
  private String userEndpoint; // /user

  @Value(value = "${api.jsonplaceholder.endpoints.todo}") // yml path
  private String todoEndpoint; // /user

  @Value(value = "${api.jsonplaceholder.endpoints.post}")
  private String postEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.comment}")
  private String commentEndpoint;


  @Override
  public List<User> findUsers() throws BusinessException {
    String url = UriComponentsBuilder.newInstance()//
        .scheme(Protocal.HTTP.name())// use emun
        .host(jphDomain)//
        .path(userEndpoint)//
        .toUriString();
    System.out.println("url = " + url);
    // Invoke API + Jackson Deserialization (JSON -> Object)
    try {
      User[] users = restTemplate.getForObject(url, User[].class);
      return Arrays.asList(users);
    } catch (RestClientException e) {
      throw new JPHException(Code.JPH_NOTFOUND);
    }
  }


  
  @Override
  public List<Todo> findTodos() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme("https")//
        .host(jphDomain)//
        .path(todoEndpoint)//
        .toUriString();
    System.out.println("url = " + url);
    // invoke API + Deserialization (Json -> Object)
    Todo[] todos = restTemplate.getForObject(url, Todo[].class);
    return Arrays.asList(todos);
  }

  @Override
  public User getUserById(int id) throws BusinessException {
    return this.findUsers().stream()//
        .filter(e -> e.getId() == id)//
        .findFirst()//
        .orElse(null)//
    ;
  }

  @Override
  public List<Post> findPosts() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme("https")//
        .host(jphDomain)//
        .path(postEndpoint) //
        .toUriString();
    Post[] post = restTemplate.getForObject(url, Post[].class);
    return Arrays.asList(post);

  }


  @Override
  public List<Comment> findComments() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme("https")//
        .host(jphDomain)//
        .path(commentEndpoint)//
        .toUriString();
    Comment[] comments = restTemplate.getForObject(url, Comment[].class);
    return Arrays.asList(comments);
  }

  public List<Post> findPostByid(int id) {
    List<Post> posts = this.findPosts();
    return posts.stream()//
        .filter(e -> e.getId() == id)//
        .collect(Collectors.toList());
  }

  @Override
  public List<Comment> findCommentByid(int postid) {
    List<Comment> comments = this.findComments();
    return comments.stream()//
        .filter(e -> e.getPostID() == postid)//
        .collect(Collectors.toList());
  }



}
