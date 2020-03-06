package ru.dias.spring1boot.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:private.properties")
public class AppConfig extends WebMvcAutoConfiguration {
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!registry.hasMappingForPattern("/webjars/**")) {
//            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        }
//    }
}
