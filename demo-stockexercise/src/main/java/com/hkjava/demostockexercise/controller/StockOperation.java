package com.hkjava.demostockexercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.Quote;
import com.hkjava.demostockexercise.model.Stock;

public interface StockOperation {

  // @GetMapping(value = "/campany/{stock}")
  // Company getCompany(@PathVariable(value = "stock") String stock) throws Exception;

  // @GetMapping(value = "/quote/{stock}")
  // Quote getQuote(@PathVariable(value = "stock") String stock) throws Exception;

  @GetMapping(value = "/stock")
  Stock getStock(@RequestParam(value = "symbol") String stock)throws Exception ;


}
