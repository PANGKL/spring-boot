package com.hkjava.demostockexercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Stock {

  private CompanyDTO companyProfile;
  private double currentPrice;
  private double dayHigh;
  private double dayLow;
  private double dayOpen;
  private double prevDayClose;

  public Object thenReturn(Stock findStockState) {
    return null;
  }

}
