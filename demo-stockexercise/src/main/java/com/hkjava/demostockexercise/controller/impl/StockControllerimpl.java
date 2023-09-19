package com.hkjava.demostockexercise.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demostockexercise.controller.StockOperation;
import com.hkjava.demostockexercise.exception.BussinessException;
import com.hkjava.demostockexercise.exception.NullStockException;
import com.hkjava.demostockexercise.infra.ApiResponse;
import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.Quote;
import com.hkjava.demostockexercise.model.Stock;
import com.hkjava.demostockexercise.service.StockService;

@RestController
@RequestMapping(value = "/api/v1")
public class StockControllerimpl implements StockOperation {


  @Autowired
  StockService stockService;

  // @Override
  // public Company getCompany(String stock) throws Exception {
  // return stockService.findCompanyProfile(stock);
  // }

  // @Override
  // public Quote getQuote(String stock) throws Exception {
  // return stockService.findCompanyQuote(stock);
  // }

  @Override
  public Stock getStock(String stock) throws Exception {
    if (stock.isBlank())
      throw new IllegalArgumentException("Parameter Symbol is blank");
      
    return stockService.findStockState(stock);
  }

}
