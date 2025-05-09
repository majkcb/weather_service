package org.example.labb3.client.met;

import lombok.RequiredArgsConstructor;
import org.example.labb3.config.met.METProperties;
import org.example.labb3.model.met.METResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class METClient {

    private final RestClient metRestClient;
    private final METProperties properties;

    public METResponse getForecast() {
        return metRestClient.get()
                .uri(properties.getEndpoint())
                .retrieve()
                .body(METResponse.class);
    }
}
