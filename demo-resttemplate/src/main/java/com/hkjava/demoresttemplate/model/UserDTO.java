package com.hkjava.demoresttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private long id;
  private String name;
  @JsonProperty("user")
  private String username;
}
