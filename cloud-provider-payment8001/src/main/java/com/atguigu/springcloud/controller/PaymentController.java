package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：lqs
 * @date ：Created in 2020/5/22 17:05
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/creat")
    public CommonResult creat(Payment payment){
        int result=paymentService.create(payment);
        log.info("*******插入结果："+result);

        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444," 插入失败",result);
        }
    }

}
