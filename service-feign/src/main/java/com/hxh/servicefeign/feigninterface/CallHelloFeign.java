package com.hxh.servicefeign.feigninterface;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-producer")
public interface CallHelloFeign {
    @RequestMapping("/hello")
    //需要使用注解@RequestParam，否则无法传递参数
    String callHelloFromProducer(@RequestParam("name") String name);
}
