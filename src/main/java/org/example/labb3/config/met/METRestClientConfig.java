package org.example.labb3.config.met;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class METRestClientConfig {

    @Bean
    public RestClient metRestClient(METProperties properties, RestClient.Builder builder) {
        return builder
                .baseUrl(properties.getBaseUrl())
                .defaultHeader("User-Agent", "labb3-java/1.0")
                .build();
    }
}
