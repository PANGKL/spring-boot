package com.hkjava.demoresttemplate.exception;

import com.hkjava.demoresttemplate.infra.BusinessException;
import com.hkjava.demoresttemplate.infra.Code;

public class JPHException extends BusinessException {

  public JPHException(Code code) {
    super(code);
  }
}
