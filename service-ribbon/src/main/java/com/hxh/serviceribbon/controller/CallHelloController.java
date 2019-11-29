package com.hxh.serviceribbon.controller;


import com.hxh.serviceribbon.service.CallHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallHelloController {
    @Autowired
    private CallHelloService callHelloService;

    @RequestMapping(value = "/callHello")
    public String callHello(String name){
        return callHelloService.callHelloService(name);
    }


}
