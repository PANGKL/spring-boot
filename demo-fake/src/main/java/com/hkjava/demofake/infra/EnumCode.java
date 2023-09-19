package com.hkjava.demofake.infra;

import lombok.Getter;

@Getter
public enum EnumCode {
  OK(2000, "gogogo"), //
  ERROR(4001, "nonono");

  int code;
  String desc;

  EnumCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}
