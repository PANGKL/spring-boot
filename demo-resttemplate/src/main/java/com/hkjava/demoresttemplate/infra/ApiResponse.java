package com.hkjava.demoresttemplate.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

// @Builder // TBC..
// @Setter //if builder built, no need setter
// @Getter
// @ToString
public class ApiResponse<T> {
  // attribute name by default same as JSON field name
  // after serialization
  // @JsonProperty(value = "status")
  private int code;
  private String message;
  private T data;
  
  public int getCode() {
    return code;
  }

  public T getData() {
    return data;
  }

  public String getMessage() {
    return message;
  }


  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> ApiResponseBuilder<T> builder() {
    return new ApiResponseBuilder<>();
  }

  public static class ApiResponseBuilder<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> status(Code code) {
      this.code = code.getCode();
      this.message = code.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> ok() {
      this.code = Code.OK.getCode();
      this.message = Code.OK.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      if (this.code == 0 || this.message == null) {
        throw new RuntimeException();
      }
      return new ApiResponse<>(this);
    }



  }


}

// {
// "code" : 200,
// "message" : "OK",
// "data" : [

// ],
// "error" :[
// "","",""
// ]
// }


// standarlize all data I get
//
