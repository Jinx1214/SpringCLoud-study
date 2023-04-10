package com.atguiug.springcloud.service;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface Paymentservice {
    //调用查询模块
    @GetMapping("/order/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id);
}
