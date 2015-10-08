package com.superbpm.apps;

import com.superbpm.apps.app1.config.App1Config;
import com.superbpm.platform.config.PlatformConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class App1 extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PlatformConfig.class,App1.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(new Object[]{PlatformConfig.class,App1.class}, args);
    }
}
