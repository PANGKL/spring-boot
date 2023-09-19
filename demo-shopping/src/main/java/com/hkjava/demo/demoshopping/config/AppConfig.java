package com.hkjava.demo.demoshopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Annotation on method Only
public class AppConfig {

  @Bean // Annotation on method Only
  RestTemplate restTemplate() { // public, private,
    // nothing, nothing 只在同一個package下的class可以call
    return new RestTemplate();
  }

}
