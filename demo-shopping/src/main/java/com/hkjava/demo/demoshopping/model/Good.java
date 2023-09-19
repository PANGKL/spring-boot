package com.hkjava.demo.demoshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Good {
  private long id;
  private String description;
  private double price;
  private static int counter = 0;


  public Good(double price, String description){
    this.id = ++counter;
    this.price = price;
    this.description = description;

  }


}
