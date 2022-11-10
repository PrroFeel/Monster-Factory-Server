package com.profeel.monsterfac.monsterfactoryserver.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Class : MyBatisConfig
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Configuration
@MapperScan(basePackages = {"com.profeel.monsterfac.monsterfactoryserver"}, annotationClass = Mapper.class)
public class MyBatisConfig {
}
