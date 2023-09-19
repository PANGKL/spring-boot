package com.hkjava.demofake.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class UserDTO {
  private long id;
  private String username;
  private String password;
  private Name name;

  @Getter
  @Builder
  public static class Name {
    private String firstname;
    private String lastname;
  }

}
