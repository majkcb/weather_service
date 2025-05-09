package org.example.labb3.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OWMMain {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("humidity")
    private double humidity;
}
