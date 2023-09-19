package com.hkjava.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  private long Userid;
  private long id;
  private String title;
  private String body;

}
