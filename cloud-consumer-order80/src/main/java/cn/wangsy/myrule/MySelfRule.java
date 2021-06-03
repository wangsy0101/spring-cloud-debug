package cn.wangsy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangsy on 2021/5/25
 *
 * 自定义负载均衡策略，不能被component-scan注解扫描到，所以重新建包
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();    // 随机
    }
}
