package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    //定义远程支付模块的接口地址
   // private final String PAYMENT_API = "http://localhost:8001/";
    private final String PAYMENT_API = "http://CLOUD-PAYMENT-SERVICE";
    //原始的方法是使用httpclient方式进行远程调用 restTemplate则是对httpclient进行了封装
    @Autowired
    private RestTemplate restTemplate;

    //调用注册模块
    @PostMapping("/order")
    //前端使用postman进行数据测试时,如果使用的是query param方式进行post请求是
    //这里使用的@RequestBody注解的话会报 Required request body is missing异常 不加注解即可
    //而使用body请求体携带数据则加RequestBody则一切正常
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        log.info("需要进行注册的流水单号为:{}",payment);
        //参数列表为 请求地址 参数 返回值的类字节
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_API + "/payment", payment, CommonResult.class);
        return commonResult;
    }

    //调用查询模块
    @GetMapping("/order/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("需要进行查询的流水单号Id为:{}",id);
        //参数列表为 请求地址 参数 返回值的类字节
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_API + "/payment/"+id, CommonResult.class);
        return commonResult;
    }
}
