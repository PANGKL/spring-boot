package com.hkjava.democalculator.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.democalculator.controller.CalculatorOperation;
import com.hkjava.democalculator.service.CalculatorService;

@Controller
@ResponseBody
@RestController // @Controller + @ResponeBody
@RequestMapping(value = "api/v2")
public class CalculatorControllerImpl implements CalculatorOperation {

  @Autowired
  CalculatorService calculatorService;

  @Autowired
  @Qualifier(value = "arrayList")
  List<String> string;

  @Override
  public List<String> getStrings() {
    return calculatorService.getStrings();
  }



  @Override
  public Integer add(int salary, int bonus, String divided) {
    int d = 0;
    try {
      d = Integer.valueOf(divided);
    } catch (NumberFormatException e) {
      d = 0;
    }
    return calculatorService.add(salary + bonus, d);
  }

  @Override
  public Integer substract(int salary, int y, String z) {
    return calculatorService.substract(salary + y, 0);
  }



}
