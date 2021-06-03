package cn.wangsy.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wangsy on 2021/5/24
 */
@SpringBootApplication
@MapperScan(basePackages="cn.wangsy.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8002 {


    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }

}
