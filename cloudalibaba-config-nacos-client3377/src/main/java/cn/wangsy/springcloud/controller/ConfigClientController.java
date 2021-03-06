package cn.wangsy.springcloud.controller;

import cn.wangsy.springcloud.model.Promotion;
import cn.wangsy.springcloud.service.AdminConfigService;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangsy on 2021/5/31
 */

@RestController
public class ConfigClientController {


    @Autowired
    private Promotion promotion;

    @Autowired
    private AdminConfigService adminConfigService;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return JSON.toJSONString(promotion);
    }

    @GetMapping("/config/info/v2")
    public String getConfigInfoV2(){
        return JSON.toJSONString(adminConfigService.getAdmin());
    }


}
