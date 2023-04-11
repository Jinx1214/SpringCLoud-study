package com.atguiug.springcloud.service.Impl;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;
import com.atguiug.springcloud.service.Paymentservice;

public class PaymentService implements Paymentservice {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return null;
    }

    @Override
    public String getPayment() {
        return "OpenFeign中的统一服务熔断执行";
    }
}
