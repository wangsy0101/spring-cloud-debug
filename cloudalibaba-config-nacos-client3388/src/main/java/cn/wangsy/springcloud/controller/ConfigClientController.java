package cn.wangsy.springcloud.controller;

import cn.wangsy.springcloud.service.AdminConfigService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangsy on 2021/5/31
 */

@RestController
public class ConfigClientController {


    @Autowired
    private AdminConfigService adminConfigService;


    @GetMapping("/config/info/v2")
    public String getConfigInfoV2(){
        return JSON.toJSONString(adminConfigService.getAdmin());
    }


}
