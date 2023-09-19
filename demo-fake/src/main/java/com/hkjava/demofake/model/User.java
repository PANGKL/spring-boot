package com.hkjava.demofake.model;

import java.util.List;
import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class User {
  private Address address;
  private long id;
  private String email;
  private String username;
  private String password;
  private Name name;
  private String phone;
  private long __v;

  @Getter
  public static class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;

    @Getter
    public static class Geolocation {
      private double lat;
      private double lon;
    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Name {
    private String firstname;
    private String lastname;
  }



}
