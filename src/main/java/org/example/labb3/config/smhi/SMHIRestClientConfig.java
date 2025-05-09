package org.example.labb3.config.smhi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SMHIRestClientConfig {

    @Bean
    public RestClient smhiRestClient(SMHIProperties properties, RestClient.Builder builder) {
        return builder
                .baseUrl(properties.getBaseUrl())
                .build();
    }
}
