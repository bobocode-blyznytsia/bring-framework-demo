package com.bobocode.bring.demo.app.config;

import com.bobocode.bring.demo.app.util.UriConverter;
import com.bringframework.annotation.Bean;
import com.bringframework.annotation.Configuration;

@Configuration
public class UtilConfig {

    @Bean
    public UriConverter uriConverter() {
        return new UriConverter();
    }

}
