package org.example.labb3.config.met;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "weather.met")
public class METProperties {
    private String baseUrl;
    private String endpoint;
}