package com.hkjava.demostockexercise.exception;

import com.hkjava.demostockexercise.infra.CodeStatus;

public class NullStockException extends BussinessException {

  public NullStockException(CodeStatus code) {
    super(code);
  }

}
