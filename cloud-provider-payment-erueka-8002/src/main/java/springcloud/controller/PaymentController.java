package springcloud.controller;

import com.atguigu.springcloud.commons.entities.CommonResult;
import com.atguigu.springcloud.commons.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //添加訂單接口
    @PostMapping("/payment")
    public CommonResult createPayment(@RequestBody Payment payment){
        if(paymentService.create(payment)>0){
            return new CommonResult(200,"添加成功");
        }else {
            return new CommonResult(444,"添加失敗");
        }
    }

    //獲取訂單接口
    @GetMapping("/payment/{id}")
    public CommonResult getPaymentInfoById(@PathVariable("id") Long id){
        log.info("Eureka远程调用成功，id为:{}",id);
        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById ==null){
            return new CommonResult(444,"該訂單不存在");
        }else {
            return new CommonResult(200,"查詢成功",paymentById);
        }
    }
}
