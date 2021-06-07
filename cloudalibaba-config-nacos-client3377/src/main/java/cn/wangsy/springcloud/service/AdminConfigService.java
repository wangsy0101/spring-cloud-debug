package cn.wangsy.springcloud.service;

import cn.wangsy.springcloud.model.Admin;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by wangsy on 2021/6/4
 */
@Service
@Slf4j
public class AdminConfigService implements InitializingBean {


    @Value("${nacos.config.server-addr}")
    private String NACOS_SERVICE_ADDR;

    @Value("${nacos.config.namespace}")
    private String NACOS_NAMESPACE;



    private static final String DATA_ID = "admin";
    private static final String GROUP_ID = "DEFAULT_GROUP";
    private static final long TIMEOUT = 5000L;

    private volatile Admin admin;


    /**
     * <p>
     * Nacos 控制台添加配置：
     * <p>
     * Data ID：admin
     * <p>
     * Group：DEFAULT_GROUP
     * <p>
     * 配置内容：
     * {"a":"1","b":"2","c":[{"dev":"111","api":"222"},{"dev":"333","api":"444"}]}
     */
    @NacosConfigListener(dataId = DATA_ID, groupId = GROUP_ID, timeout = TIMEOUT)
    public void onReceived(String config) {
        log.info("onReceived(config) : {}", config);
        this.admin = convertContent2Admin(config);
    }


    public Admin getAdmin() {
        return admin;
    }


    public Admin convertContent2Admin(String config){
        return JSON.parseObject(config, Admin.class);
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, NACOS_SERVICE_ADDR);
        properties.put(PropertyKeyConst.NAMESPACE, NACOS_NAMESPACE);
        ConfigService configService = NacosFactory.createConfigService(properties);
        try {
            String config = configService.getConfig(DATA_ID, GROUP_ID, TIMEOUT);
            admin = convertContent2Admin(config);
        }catch (NacosException e){
            log.error("adminConfigService, errCode:{}, errMSg:{}, e", e.getErrCode(), e.getErrMsg(), e);
        }
    }
}
