package com.hkjava.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
public class Todo {
  private long userId;
  private long id;
  private String title;
  private boolean completed;

}
