package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentServiceCommonFallBack.class)
public interface PyamentService {
    @GetMapping("/provider/getUUID")
    public String getPaymentUUID();
}
