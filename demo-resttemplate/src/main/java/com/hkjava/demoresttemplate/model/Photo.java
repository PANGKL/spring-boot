package com.hkjava.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Photo {

  private long albumId;
  private long id;
  private String title;
  private String url;
  private String thumbnailUrl;

}
