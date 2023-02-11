package com.bobocode.bring.demo.app.config;

import com.bringframework.annotation.Bean;
import com.bringframework.annotation.Configuration;
import com.bringframework.annotation.Qualifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;

@Configuration
public class AppConfig {

    @Bean
    public HttpClient httpClient(@Qualifier("redirectPolicy") Redirect redirectPolicy) {
        return HttpClient.newBuilder()
                .followRedirects(redirectPolicy)
                .build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Redirect redirectPolicy() {
        return Redirect.ALWAYS;
    }

    @Bean
    public Redirect neverRedirectPolicy() {
        return Redirect.NEVER;
    }


}
