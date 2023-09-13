package com.hkjava.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/pkl/v11")
public class AppController {
  @GetMapping(value = "/pkll")

  public String test() {
    return "My name is PKL";

  }



}
