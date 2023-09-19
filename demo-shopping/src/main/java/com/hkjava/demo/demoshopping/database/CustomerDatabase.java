package com.hkjava.demo.demoshopping.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import javax.swing.text.html.Option;
import org.springframework.web.bind.annotation.PathVariable;
import com.hkjava.demo.demoshopping.model.Customer;

public class CustomerDatabase {

  private static List<Customer> customers = new ArrayList<>();

  public static void add(Customer customer) {
    customers.add(customer);
  }

  // Optional -> 不一定搵到
  public static Optional<Customer> find(long id) {
    return customers.stream()//
        .filter(e -> e.getId() == id)//
        .findFirst();
  }

  public static Customer remove(long id) {
    Optional<Customer> customer = find(id);
    if (!customer.isPresent())
      return null;
    CustomerDatabase.customers.remove(customer.get());
    return customer.get();

  }

  public static Customer update(long id, Customer newCustomer) {
    if (!find(id).isPresent())
      return null;
    customers.stream()//
        .filter(customer -> customer.getId() == id)//
        .forEach(e -> {
          e.setDob(newCustomer.getDob());
          e.setEmail(newCustomer.getEmail());
          e.setName(newCustomer.getName());
        });


    return customers.stream().filter(e -> e.getId() == id).findFirst().get();
  }

  public static Customer patchEmail(long id, String email) {
    Optional<Customer> customer = find(id);
    if (!customer.isPresent())
      return null;
    customer.stream()//
        .filter(e -> e.getId() == id).forEach(e -> {
          e.setEmail(email);
        });

    customer.get().setEmail(email);
    return customer.get();

  }

  public static Customer patchName(long id, String name) {
    Optional<Customer> customer = find(id); // 撈個object出來
    customers.stream()// 直接改入面條list
        .filter(e -> e.getId() == id)//
        .forEach(e -> {
          e.setName(name);
        });

    customer.get().setName(name);
    return customer.get();

  }

  public static List<Customer> findAll() {
    return customers;
  };



}
