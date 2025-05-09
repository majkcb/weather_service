package org.example.labb3.client.owm;

import lombok.RequiredArgsConstructor;
import org.example.labb3.config.owm.OWMProperties;
import org.example.labb3.model.owm.OWMResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class OWMClient {

    private final RestClient owmRestClient;
    private final OWMProperties properties;

    public OWMResponse getForecast() {
        return owmRestClient.get()
                .uri(properties.getEndpoint())
                .retrieve()
                .body(OWMResponse.class);
    }
}
