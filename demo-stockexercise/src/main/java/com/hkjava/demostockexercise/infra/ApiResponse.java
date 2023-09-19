package com.hkjava.demostockexercise.infra;

import com.hkjava.demostockexercise.model.Stock;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {

  private int code;
  private String message;
  private T data;


}
