package com.profeel.monsterfac.monsterfactoryserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <pre>
 * Class : SwaggerConfig
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * 2022-11-14       최윤서           basePackage 설정
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo commonInfo() {

        return new ApiInfoBuilder()
                .title("MonFac API")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket allApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Monster Factory")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.profeel.monsterfac.monsterfactoryserver"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(commonInfo());
    }
}
