package com.hkjava.demostockexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
// @AllArgsConstructor
// @NoArgsConstructor
// @ToString
public class Quote {
  //@JsonProperty(value = "currentPrice")
  private double c;
  private double d;
  private double dp;
  private double h;
  private double l;
  private double o;
  private double pc;
  private long t;

}
