package org.example.labb3.config.owm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OWMRestClientConfig {

    @Bean
    public RestClient owmRestClient(OWMProperties properties, RestClient.Builder builder) {
        return builder
                .baseUrl(properties.getBaseUrl())
                .build();
    }
}
