package com.hkjava.demoresttemplate.service;

import java.util.ArrayList;
import java.util.List;
import com.hkjava.demoresttemplate.infra.BusinessException;
import com.hkjava.demoresttemplate.model.Comment;
import com.hkjava.demoresttemplate.model.Post;
import com.hkjava.demoresttemplate.model.Todo;
import com.hkjava.demoresttemplate.model.User;

public interface UserService {

  ArrayList<User> findUsers = null;

  List<User> findUsers() throws BusinessException;

  List<Todo> findTodos();

  User getUserById(int id) throws BusinessException;

  List<Post> findPosts();

  List<Post> findPostByid(int id);

  List<Comment> findComments();

  List<Comment> findCommentByid(int postid);


}
