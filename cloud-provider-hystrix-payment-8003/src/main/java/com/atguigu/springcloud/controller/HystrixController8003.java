package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback="defaultMethod") //如果方法上面没有指定fallbackMethod,则统一使用DefaultProperties中的fallbackMethod
public class HystrixController8003 {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/provider/getUUID")
    @HystrixCommand(fallbackMethod = "timeout",commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
    })
    public String getPaymentUUID() throws InterruptedException {
        Thread.sleep(5000);
        return
                paymentService.getPaymentId();
    }
    public String defaultMethod(){
        return "服务超时,请稍后尝试";
    }

    @HystrixCommand()
    @GetMapping("/defaultPayment")
    public String getPayment() throws InterruptedException {
        int i = 1/0;
        return paymentService.getPaymentId();
    }


    public String timeout(){
        return "服务超时,请稍后尝试";
    }
}
