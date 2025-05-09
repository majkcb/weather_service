package org.example.labb3.config.owm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "weather.owm")
public class OWMProperties {
    private String baseUrl;
    private String endpoint;
}
