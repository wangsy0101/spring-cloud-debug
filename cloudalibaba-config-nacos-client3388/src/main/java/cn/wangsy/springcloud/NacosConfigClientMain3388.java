package cn.wangsy.springcloud;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wangsy on 2021/5/31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableNacosConfig
public class NacosConfigClientMain3388 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3388.class, args);
    }


}
