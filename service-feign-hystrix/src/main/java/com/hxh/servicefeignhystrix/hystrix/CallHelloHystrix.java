package com.hxh.servicefeignhystrix.hystrix;

import com.hxh.servicefeignhystrix.feigninterface.CallHelloFeign;
import org.springframework.stereotype.Component;

@Component
public class CallHelloHystrix implements CallHelloFeign {

    @Override
    public String callHelloFromProducer(String name) {
        return "sorry," + name + ",error";
    }
}
