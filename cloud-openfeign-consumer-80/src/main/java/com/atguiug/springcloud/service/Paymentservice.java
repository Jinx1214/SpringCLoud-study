package com.atguiug.springcloud.service;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;
import com.atguiug.springcloud.service.Impl.PaymentService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentService.class)
public interface Paymentservice {
    //调用查询模块
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id);

    @GetMapping("/defaultPayment")
    public String getPayment();
}
