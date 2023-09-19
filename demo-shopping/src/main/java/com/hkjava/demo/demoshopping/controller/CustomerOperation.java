package com.hkjava.demo.demoshopping.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerOperation {


        @GetMapping(value = "/customers")
        List<Customer> findAll();

        // "/customer" -> Endpoint
        @PostMapping(value = "/customer") // noun, No ver
        Customer create(@RequestParam String name, //
                        @RequestParam String email, //
                        @RequestParam LocalDate dob);

        @GetMapping(value = "/customer/{id}") // noun, No verb
        Customer find(@PathVariable(name = "id") String customerId);

        @DeleteMapping(value = "/customer/{id}") // noun, No verb
        Customer remove(@PathVariable(name = "id") String customerId);

        // @PostMapping(value = "/customer") // noun, No verb
        // Customer createCustomer(@RequestBody Customer customer);


        @PutMapping(value = "/customer/{id}") // Put -> table PK
        Customer update(@PathVariable(name = "id") String id,
                        @RequestBody Customer customer);

        @PatchMapping(value = "/customer/id/{id}/email/{email}") // noun, No verb
        Customer patchEmail(@PathVariable(name = "id") String customerId,
                        @PathVariable String email);

        @PatchMapping(value = "/customer/id/{id}/name/{name}")
        Customer patchName(@PathVariable(name = "id") String customerIdid,
                        @PathVariable String name);



}
