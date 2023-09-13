package com.bootcamp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;


public interface HelloWordController {

  @GetMapping(value = "/helloworld")
  String hello();


}
