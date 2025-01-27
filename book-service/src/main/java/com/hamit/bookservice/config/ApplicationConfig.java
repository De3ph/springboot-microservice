package com.hamit.bookservice.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hamit.bookservice.*")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
public class ApplicationConfig {
}
