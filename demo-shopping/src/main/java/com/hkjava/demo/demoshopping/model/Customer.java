package com.hkjava.demo.demoshopping.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Customer {
  private long id;
  private String name;
  private String email;
  private LocalDate dob;
  private List<Order> orders;

  private static int counter = 0;

  public Customer(String name, String email, LocalDate dob) {
    this.id = ++counter;
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.orders = new ArrayList<>();
  }

  public Customer(CustomerBuilder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.email = builder.email;
    this.dob = builder.dob;
    this.orders = new ArrayList<>();
  }

  public void add(Order order) {
    orders.add(order);
  }

  public static CustomerBuilder builder() {
    return new CustomerBuilder();
  }

  public static class CustomerBuilder {
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    public CustomerBuilder() {
      this.id = ++Customer.counter;
    }

    public CustomerBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CustomerBuilder email(String email) {
      this.email = email;
      return this;
    }

    public CustomerBuilder dob(LocalDate dob) {
      this.dob = dob;
      return this;
    }

    public Customer build() {
      return new Customer(this);
    }

  }
}

