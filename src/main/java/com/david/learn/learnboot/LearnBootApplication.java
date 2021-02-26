package com.david.learn.learnboot;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySources(
        {
                @NacosPropertySource(dataId = "boot-learn_hot-config", type = ConfigType.YAML, autoRefreshed = true)
        }
)
public class LearnBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnBootApplication.class, args);
    }

}
