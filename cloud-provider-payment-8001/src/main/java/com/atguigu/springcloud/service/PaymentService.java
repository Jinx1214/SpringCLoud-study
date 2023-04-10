package com.atguigu.springcloud.service;

import com.atguigu.springcloud.commons.entities.Payment;

import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //新增訂單接口
    int create(Payment payment);

    //查詢接口
    Payment getPaymentById(@Param("id") Long id);
}
