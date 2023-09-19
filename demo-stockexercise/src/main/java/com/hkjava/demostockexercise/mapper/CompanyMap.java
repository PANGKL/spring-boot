package com.hkjava.demostockexercise.mapper;

import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.CompanyDTO;

public class CompanyMap {


  public static CompanyDTO companyMap(Company company) {
    return CompanyDTO.builder()//
        .country(company.getCountry())//
        .companyName(company.getName())//
        .ipoDate(company.getIpo())//
        .logo(company.getLogo())//
        .marketCap(company.getMarketCapitalization())
        .currency(company.getCurrency()).build();

  }

}
