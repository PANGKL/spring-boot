package com.hkjava.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {

  private long userId;
  private long id;
  private String title;


}
