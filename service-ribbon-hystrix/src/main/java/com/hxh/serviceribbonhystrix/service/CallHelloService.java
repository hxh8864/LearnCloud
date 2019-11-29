package com.hxh.serviceribbonhystrix.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallHelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String callHelloService(String name){
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hello?name="+name,String.class);
    }

    public String error(String name){
        return "sorry,"+name+", error";
    }
}
