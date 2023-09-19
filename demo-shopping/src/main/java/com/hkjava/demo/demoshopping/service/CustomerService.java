package com.hkjava.demo.demoshopping.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerService {

  Customer create(String name, String email, LocalDate dob);

  public Optional<Customer> find(long customerID);

  public Customer remove(long customerID);

  public Customer update(long id, Customer newCustomer);

  public Customer patchEmail(long id, String email);

  public Customer patchName(long id, String name);

  public List<Customer> findAll();

}
