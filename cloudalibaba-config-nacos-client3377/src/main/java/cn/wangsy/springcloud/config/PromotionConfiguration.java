package cn.wangsy.springcloud.config;

import cn.wangsy.springcloud.model.Promotion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangsy on 2021/6/4
 */
@Configuration
public class PromotionConfiguration {

    @Bean
    public Promotion promotion() {
        return new Promotion();
    }


}
