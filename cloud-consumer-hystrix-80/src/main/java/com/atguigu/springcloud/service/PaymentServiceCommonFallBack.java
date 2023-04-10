package com.atguigu.springcloud.service;

public class PaymentServiceCommonFallBack implements PyamentService{
    @Override
    public String getPaymentUUID() {
        return "统一超时模板";
    }
}
