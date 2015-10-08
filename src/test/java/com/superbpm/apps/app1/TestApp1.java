package com.superbpm.apps.app1;

import com.superbpm.apps.App1;
import com.superbpm.apps.app1.config.App1Config;
import com.superbpm.platform.config.PlatformConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class TestApp1{

    public static void main(final String[] args) {
        SpringApplication.run(new Object[]{PlatformConfig.class,App1Config.class}, args);
    }
}
