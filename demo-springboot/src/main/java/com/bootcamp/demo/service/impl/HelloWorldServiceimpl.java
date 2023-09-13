package com.bootcamp.demo.service.impl;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.service.HelloWorldService;


@Service
public class HelloWorldServiceimpl implements HelloWorldService {

  @Override
  public String generate(int x) {
    if (x > 100)
      return "Hello World";
    return "abc";
  }
}
