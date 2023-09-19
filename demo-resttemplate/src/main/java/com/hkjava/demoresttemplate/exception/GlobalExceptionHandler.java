package com.hkjava.demoresttemplate.exception;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hkjava.demoresttemplate.infra.ApiResponse;
import com.hkjava.demoresttemplate.infra.BusinessException;
import com.hkjava.demoresttemplate.infra.Code;
import com.hkjava.demoresttemplate.model.UserDTO;

@RestControllerAdvice // @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = JPHException.class)
  public ResponseEntity<ApiResponse<Void>> JPHExceptionHandler() {

    ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()//
        .status(Code.JPH_NOTFOUND)//
        .data(null)//
        .build();
    return ResponseEntity.ok().body(apiResponse);

  }

}
