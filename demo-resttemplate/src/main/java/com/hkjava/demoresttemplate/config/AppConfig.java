package com.hkjava.demoresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig { //Bean

  @Bean
  RestTemplate restTemplate() {
    // A tool/ class(library) to invoke third party APIs
    return new RestTemplate();
  }

}
