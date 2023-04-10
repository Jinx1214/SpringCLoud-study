package com.atguigu.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPaymentId() {
        return IdUtil.randomUUID();
    }
}
