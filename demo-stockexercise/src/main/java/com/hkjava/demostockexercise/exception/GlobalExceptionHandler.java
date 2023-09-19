package com.hkjava.demostockexercise.exception;

import org.apache.tomcat.jni.Sockaddr;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hkjava.demostockexercise.infra.ApiResponse;
import com.hkjava.demostockexercise.infra.CodeStatus;
import com.hkjava.demostockexercise.mapper.CompanyMap;
import com.hkjava.demostockexercise.model.Company;
import com.hkjava.demostockexercise.model.Stock;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = NullStockException.class)
  public ApiResponse<Void> NullStockHandler() {
    System.out.println("Error : NullStockException Handled");
    // Stock stock = Stock.builder()//
    //     .companyProfile(CompanyMap.companyMap(new Company()))//
    //     .currentPrice(0)//
    //     .dayHigh(0)//
    //     .dayLow(0)//
    //     .dayOpen(0)//
    //     .prevDayClose(5)//
    //     .build();


    return ApiResponse.<Void>builder()//
        .code(CodeStatus.NullStock.getCode())//
        .message(CodeStatus.NullStock.getMessage())//
        .data(null)//
        .build();



  }
}
