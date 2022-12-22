package com.kun.config;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Configuration
public class InfluxDBClientConfiguration {

    @Autowired
    private InfluxDBConfig influxDBConfig;

    @Bean
    public InfluxDBClient influxDBClient() {
        InfluxDBClient client = InfluxDBClientFactory.create(influxDBConfig.getUrl(), influxDBConfig.getToken().toCharArray(), influxDBConfig.getOrg(), influxDBConfig.getBucket());
        return client;
    }

}
