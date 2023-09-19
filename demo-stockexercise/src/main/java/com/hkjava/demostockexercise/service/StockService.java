package com.hkjava.demostockexercise.service;

import org.springframework.http.ResponseEntity;
import com.hkjava.demostockexercise.exception.BussinessException;
import com.hkjava.demostockexercise.exception.NullStockException;
import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.Quote;
import com.hkjava.demostockexercise.model.Stock;

public interface StockService {

  Company findCompanyProfile(String stock) throws BussinessException;

  Quote findCompanyQuote(String stock)throws BussinessException;

  Stock findStockState(String stock) throws BussinessException;

}
