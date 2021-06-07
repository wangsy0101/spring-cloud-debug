package cn.wangsy.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by wangsy on 2021/6/4
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private String a;
    private String b;
    private List<DevEntity> c;


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DevEntity{
        private String dev;
        private String api;
    }


}
