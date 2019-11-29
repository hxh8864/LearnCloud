package com.hxh.serviceribbon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallHelloService {

    @Autowired
    RestTemplate restTemplate;

    public String callHelloService(String name){
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hello?name="+name,String.class);
    }
}
