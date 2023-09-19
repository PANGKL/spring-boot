package com.hkjava.demo.demoshopping.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demoshopping.database.CustomerDatabase;
import com.hkjava.demo.demoshopping.model.Customer;
import com.hkjava.demo.demoshopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    Customer customer = Customer.builder() //
        .name(name)//
        .email(email)//
        .dob(dob) //
        .build();
    CustomerDatabase.add(customer);
    return customer;
  }

  @Override
  public Optional<Customer> find(long customerID) {
    return CustomerDatabase.find(customerID);
  }


  @Override
  public Customer remove(long customerID) {
    return CustomerDatabase.remove(customerID);
  }

  @Override
  public Customer update(long id, Customer newCustomer) {
    return CustomerDatabase.update(id, newCustomer);
  }

  public Customer patchEmail(long id, String email) {
    return CustomerDatabase.patchEmail(id, email);

  }

  public Customer patchName(long id, String name) {
    return CustomerDatabase.patchName(id, name);
  }

  @Override
  public List<Customer> findAll() {
    return CustomerDatabase.findAll();
  }

}
