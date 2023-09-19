package com.hkjava.demo.demoshopping.controller.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demoshopping.controller.CustomerOperation;
import com.hkjava.demo.demoshopping.model.Customer;
import com.hkjava.demo.demoshopping.service.CustomerService;


@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController implements CustomerOperation {

  @Autowired
  CustomerService customerService;

  @Override
  public List<Customer> findAll() {
    return customerService.findAll();
  }

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    return customerService.create(name, email, dob);
  }

  @Override
  public Customer find(String customerID) {
    if (!customerID.isBlank()) {
      try {
        long id = Long.valueOf(customerID);
        return customerService.find(id).orElse(null);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
    // return customerService.find(Long.valueOf(customerID)).orElse(null);
  }

  @Override
  public Customer remove(String customerId) {
    long id = Long.valueOf(customerId);
    return customerService.remove(id);

  }

  @Override
  public Customer update(String id, Customer customer) {
    if (!id.isBlank()) {
      try {
        long newid = Long.valueOf(id);
        return customerService.update(newid, customer);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  public Customer patchEmail(String id, String email) {
    if (!id.isBlank()) {
      try {
        long newid = Long.valueOf(id);
        return customerService.patchEmail(newid, email);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer patchName(String id, String name) {
    if (!id.isBlank()) {
      try {
        long newid = Long.valueOf(id);
        return customerService.patchName(newid, name);
      } catch (Exception e) {
        return null;
      }
    }
    return null;


  }



}
