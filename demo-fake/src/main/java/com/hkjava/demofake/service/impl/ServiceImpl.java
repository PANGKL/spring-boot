package com.hkjava.demofake.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demofake.model.User;
import com.hkjava.demofake.service.FakeService;



@Service
public class ServiceImpl implements FakeService {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String fakeDomain;

  @Value(value = "${api.jsonplaceholder.endpoint.user}")
  private String userenpoint;

  @Override
  public List<User> findUsers() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme("https")//
        .host(fakeDomain)//
        .path(userenpoint).toUriString();
    System.out.println(url);
    User[] users = restTemplate.getForObject(url, User[].class);
    return Arrays.asList(users);
  }



}
