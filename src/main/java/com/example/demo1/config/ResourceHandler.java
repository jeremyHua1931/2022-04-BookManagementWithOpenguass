package com.example.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;


    @Configuration
    public class ResourceHandler extends WebMvcConfigurerAdapter {

        /**
         * 配置静态访问资源
         * @param registry
         */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
                    .addVersionStrategy(new ContentVersionStrategy(), "/**");
            registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                    .setCachePeriod(2592000).resourceChain(true).addResolver(versionResourceResolver);
            super.addResourceHandlers(registry);
        }

        @Bean
        public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
            return new ResourceUrlEncodingFilter();
        }
    }


