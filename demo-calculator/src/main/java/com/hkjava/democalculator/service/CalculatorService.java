package com.hkjava.democalculator.service;

import java.util.List;
import org.springframework.stereotype.Service;


public interface CalculatorService {

  List<String> getStrings();

  /**
   * 
   * @param x
   * @param y
   * @return
   */
  int add(int x, int y);

  /**
   * A method to substract x by y
   * 
   * @param x
   * @param y
   * @return
   */
  int substract(int x, int y);



}
