package com.zhoumin.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.zhoumin.wechat.mapper")
@SpringBootApplication
public class WechatproApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatproApplication.class, args);
    }
}
