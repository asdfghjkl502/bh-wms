package io.ukoko.bhwms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置类
 */
@Configuration //声明配置类
@EnableOpenApi //开启Swagger支持
public class SwaggerConfig {

    /*
        Docket配置
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30) //使用OAS_30标准构建在线文档
                .apiInfo(apiInfo()) //加载基本信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.ukoko.bhwms.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    /*
        Swagger基本配置信息函数
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("百惠WMS仓储管理系统API") //在线文档标题设置
                .description("百惠仓储管理系统核心API在线文档") //描述
                .version("1.0.0") //设置版本
                .contact(new Contact("夜泊","https://ukoko.gitee.io","hd1611756908@163.com")) //联系人信息
                .license("AGPL-3.0 开源协议") //开源协议
                .build();
    }
}
