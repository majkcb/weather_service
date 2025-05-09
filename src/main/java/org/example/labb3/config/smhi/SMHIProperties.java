package org.example.labb3.config.smhi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "weather.smhi")
public class SMHIProperties {
    private String baseUrl;
    private String endpoint;
}

