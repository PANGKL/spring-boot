package com.hkjava.democalculator.controller;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


public interface CalculatorOperation {

        // http://localhost:8081/api/v2/add?x=10&y=20
        @GetMapping(value = "/add")
        Integer add(@RequestParam(name = "x") int salary, //
                        @RequestParam(name = "y") int bonus, //
                        @RequestParam(name = "z", required = false,
                                        defaultValue = "100") String dividend);

        // http://localhost:8081/api/v2/substract/10/20/30
        @GetMapping(value = {"/substract/{y}/{x}/{z}", // not required must in order
                        "/substract/{x}/{y}"})
        Integer substract(@PathVariable(value = "x") int salary, //
                        @PathVariable int y, //
                        @PathVariable(required = false) String z);

        @GetMapping(value = "/strings")
        List<String> getStrings();

}
