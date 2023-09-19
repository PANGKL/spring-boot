package com.hkjava.demostockexercise.exception;

import com.hkjava.demostockexercise.infra.CodeStatus;

public class BussinessException extends Exception {


  public BussinessException(CodeStatus code) {
    super(code.getMessage());

  }
}
