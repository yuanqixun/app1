package com.superbpm.apps.app1.config;

import com.superbpm.platform.config.PlatformConfig;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 扫描注册@Service标注的服务
 */
@Configuration
@MapperScan(basePackages = "com.superbpm.apps.app1.dao")
@ComponentScan(basePackages = "com.superbpm.apps.app1",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
@AutoConfigureAfter(PlatformConfig.class)
public class App1Config {

  private static final Logger logger = Logger.getLogger(App1Config.class);

//  @Bean
//  public MessageSource app1MessageSource() {
//    logger.info("App1 MessageSource");
//    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//    messageSource.setBasename("locale.i18-app1");
//    return messageSource;
//  }
}
