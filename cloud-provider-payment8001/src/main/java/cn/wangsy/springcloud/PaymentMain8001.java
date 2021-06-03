package cn.wangsy.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wangsy on 2021/5/24
 */
@SpringBootApplication
@MapperScan(basePackages="cn.wangsy.springcloud.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {


    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }

}
