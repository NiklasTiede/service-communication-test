package com.client.client.restexample.config;

import com.client.client.restexample.restclient.RestServerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    RestServerService jsonPlaceHolderService() {
        WebClient webClient =
                WebClient.builder()
                        .baseUrl("http://localhost:8081")
                        .build();

        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return httpServiceProxyFactory.createClient(RestServerService.class);
    }
}
