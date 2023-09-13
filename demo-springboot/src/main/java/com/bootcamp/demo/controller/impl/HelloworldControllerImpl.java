package com.bootcamp.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.controller.HelloWordController;
import com.bootcamp.demo.service.HelloWorldService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldControllerImpl implements HelloWordController {

  @Autowired  // Check if any object implementing HelloworldService in SpringContext
  HelloWorldService helloWorldService;


  @Override
  public String hello() {
    // return "I Love Hong Kong";
    return helloWorldService.generate(102);

  }

}
