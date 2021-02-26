package com.david.learn.learnboot.Controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wudening
 * @Description: 接入nacos测试controller
 * @Date: 2020/12/5 下午5:49
 */
@Api(tags = "NacosDemoController")
@ApiSort(2)
@Component
@RestController
@RequestMapping("/api/nacos")
public class NacosDemoController {

    @NacosValue(value = "${app.switch.openTest:false}", autoRefreshed = true)
    Boolean openTest;

    @ApiOperationSupport(order = 1)
    @GetMapping("/test")
    public Boolean testNacos() {
        return openTest;
    }
}
