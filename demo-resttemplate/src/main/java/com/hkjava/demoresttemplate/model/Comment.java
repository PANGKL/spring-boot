package com.hkjava.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
// @AllArgsConstructor
public class Comment {
  private long postID;
  private long id;
  private String name;
  private String email;
  private String body;

}
