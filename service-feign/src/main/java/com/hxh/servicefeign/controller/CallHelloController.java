package com.hxh.servicefeign.controller;


import com.hxh.servicefeign.service.CallHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallHelloController {

    @Autowired
    private CallHelloService callHelloService;

    @RequestMapping("/callHello")
    public String callHello(String name){
        return callHelloService.callHello(name);
    }
}
