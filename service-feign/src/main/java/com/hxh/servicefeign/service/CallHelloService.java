package com.hxh.servicefeign.service;


import com.hxh.servicefeign.feigninterface.CallHelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallHelloService {
    @Autowired
    private CallHelloFeign callHelloFeign;

    public String callHello(String name){
        return callHelloFeign.callHelloFromProducer(name);
    }
}
