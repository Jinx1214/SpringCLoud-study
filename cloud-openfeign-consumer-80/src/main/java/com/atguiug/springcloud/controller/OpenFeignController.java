package com.atguiug.springcloud.controller;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;
import com.atguiug.springcloud.service.Paymentservice;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OpenFeignController {

    @Resource
    private Paymentservice paymentservice;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return paymentservice.getPayment(id);
    }
}
