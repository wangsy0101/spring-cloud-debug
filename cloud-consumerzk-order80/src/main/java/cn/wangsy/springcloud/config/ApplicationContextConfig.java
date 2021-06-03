package cn.wangsy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangsy on 2021/5/24
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  /// 使用自定义负载均衡规则 @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
