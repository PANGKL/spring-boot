package com.hkjava.demostockexercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

  private String country;
  private String companyName;
  private String ipoDate;
  private String logo;
  private double marketCap;
  private String currency;

}
