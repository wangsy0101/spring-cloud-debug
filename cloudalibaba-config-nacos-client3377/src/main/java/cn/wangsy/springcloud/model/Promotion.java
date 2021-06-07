package cn.wangsy.springcloud.model;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by wangsy on 2021/6/4
 */
@NacosConfigurationProperties(dataId = "bbb", groupId = "DEFAULT_GROUP", autoRefreshed = true, type = ConfigType.YAML)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {

    private String a;

    private String b;


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
