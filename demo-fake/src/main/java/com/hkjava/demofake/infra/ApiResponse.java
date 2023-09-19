package com.hkjava.demofake.infra;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
  private int code;
  private String message;
  private T data;

  public ApiResponse(ApiResponseBuilder<T> builder) {
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

    public ApiResponseBuilder<T> status(EnumCode code) {
      this.code = code.code;
      this.message = code.desc;
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }


    public ApiResponse<T> build() {
      if(this.code == 0 | this.message == null){
        throw new RuntimeException();
      }
      return new ApiResponse<>(this);
    }



  }



}


