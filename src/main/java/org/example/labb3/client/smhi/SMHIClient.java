package org.example.labb3.client.smhi;

import lombok.RequiredArgsConstructor;
import org.example.labb3.config.smhi.SMHIProperties;
import org.example.labb3.model.smhi.SMHIResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class SMHIClient {

    private final RestClient smhiRestClient;
    private final SMHIProperties properties;

    public SMHIResponse getForecast() {
        return smhiRestClient.get()
                .uri(properties.getEndpoint())
                .retrieve()
                .body(SMHIResponse.class);
    }
}