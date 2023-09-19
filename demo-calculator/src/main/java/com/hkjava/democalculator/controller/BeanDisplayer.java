package com.hkjava.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface BeanDisplayer {

  @GetMapping(value = "/beans")
      List<String> getAllBeans();
  
}
