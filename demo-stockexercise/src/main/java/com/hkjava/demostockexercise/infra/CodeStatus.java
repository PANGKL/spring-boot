package com.hkjava.demostockexercise.infra;

import lombok.Getter;

@Getter
public enum CodeStatus {
  NullStock(4001, "Null Stock Number");

  int code;
  String message;

  CodeStatus(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
