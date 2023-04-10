package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PyamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PyamentService pyamentService;

    @GetMapping("/consumer/getUUID")
    public String getUUID(){
        return pyamentService.getPaymentUUID();
    }
}
