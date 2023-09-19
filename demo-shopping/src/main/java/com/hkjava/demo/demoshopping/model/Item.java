package com.hkjava.demo.demoshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Item extends Good {
  private int quantity;

  public Item(double price, String description, int quantity) {
    super(price, description);
    this.quantity = quantity;
  }

  public static void main(String[] args) {
    Item i1 = new Item(123, "ABC", 2);
    System.out.println(i1);
    Item i2 = new Item(123, "DEF", 2);
    System.out.println(i2);
  }

}
