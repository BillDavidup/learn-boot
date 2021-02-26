package com.david.learn.learnboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  <!-- knife4j 接入STEP ②：创建配置类 -->
 * @Author: wudening
 * @Description: swagger-bootstrap-ui 的增强版 官方文档 https://doc.xiaominfo.com/knife4j/
 * @Date: 2021/2/25 5:11 下午
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.david.learn.learnboot.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("SpringBoot项目【learn-boot】服务API接口文档")
                // 文档简介
                .description("使用 knife4j 搭建的后台服务API接口文档")
                // 修改成活的配置
                .termsOfServiceUrl("http://localhost:8080/")
                .contact(new Contact("美术宝", "美术宝官网链接", "美术宝官方邮箱"))
                .version("1.0.0")
                .build();
    }
}
