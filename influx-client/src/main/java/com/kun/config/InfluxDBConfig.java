package com.kun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Data
@Configuration
@ConfigurationProperties("influx")
public class InfluxDBConfig {
    private String url;
    private String bucket;
    private String org;
    private String token;

}
