package cn.wangsy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wangsy on 2021/5/28
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {


    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class, args);
    }

}
