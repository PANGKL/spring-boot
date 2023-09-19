package com.hkjava.demostockexercise.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demostockexercise.exception.BussinessException;
import com.hkjava.demostockexercise.exception.NullStockException;
import com.hkjava.demostockexercise.infra.CodeStatus;
import com.hkjava.demostockexercise.infra.Protocal;
import com.hkjava.demostockexercise.mapper.CompanyMap;
import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.CompanyDTO;
import com.hkjava.demostockexercise.model.Quote;
import com.hkjava.demostockexercise.model.Stock;
import com.hkjava.demostockexercise.service.StockService;

@Service
public class StockServiceimpl implements StockService {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.finnhub.domain}")
  private String finnhubDomain;

  @Value(value = "${api.finnhub.type.stock}")
  private String stockType;

  @Value(value = "${api.finnhub.type.quote}")
  private String quoteType;

  @Value(value = "${api.finnhub.apikey.key}")
  private String apikey;

  @Override
  public Company findCompanyProfile(String stock) throws RestClientException {
    String url = UriComponentsBuilder.newInstance()//
        .scheme(Protocal.HTTPS.name())//
        .host(finnhubDomain)//
        .path(stockType)//
        .path(stock)//
        .path(apikey)//
        .build()//
        .toUriString();
    System.out.println("CompanyProfileUrl = " + url);

    try {
      // Company company = restTemplate.getForObject("https://api.example.com/users", Company.class);
      Company company = restTemplate.getForObject(url, Company.class);
      return company;
    } catch (RestClientException e) {
      throw new RestClientException(CodeStatus.NullStock.getMessage());
    }
  }


  @Override
  public Quote findCompanyQuote(String stock) throws RestClientException {
    String url = UriComponentsBuilder.newInstance()//
        .scheme(Protocal.HTTPS.name())//
        .host(finnhubDomain)//
        .path(quoteType)//
        .path(stock)//
        .path(apikey)//
        .build()//
        .toUriString();
    System.out.println("CompanyQuoteUrl = " + url);
    try {
      Quote quote = restTemplate.getForObject(url, Quote.class);
      return quote;
    } catch (RestClientException e) {
      throw new RestClientException(CodeStatus.NullStock.getMessage());
    }

  }

  @Override
  public Stock findStockState(String stock) throws BussinessException {
    try {
      Company company = this.findCompanyProfile(stock);
      Quote quote = this.findCompanyQuote(stock);
      return Stock.builder()//
          .companyProfile(CompanyMap.companyMap(company))//
          .currentPrice(quote.getC())//
          .dayHigh(quote.getH())//
          .dayLow(quote.getL())//
          .dayOpen(quote.getO())//
          .prevDayClose(quote.getPc())//
          .build();
    } catch (RestClientException e) {
      throw new NullStockException(CodeStatus.NullStock);
    }

    

  }


}
