package com.hkjava.demoresttemplate.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum Code {
  OK(20000, "OK"), // 20000 internal num

  // 40000-49999
  NOTFOUND(40000, "Resource NOT FOUND"), //
  JPH_NOTFOUND(40001, "JsonPlaceHolder Resource NOT FOUND"), //
  // Server
  SERVER_TIMEOUT(50000, "Server timeout");

  int code;
  String desc;

  Code(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}
