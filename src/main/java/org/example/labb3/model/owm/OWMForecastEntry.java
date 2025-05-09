package org.example.labb3.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OWMForecastEntry {

    @JsonProperty("dt_txt")
    private String dateTime;

    @JsonProperty("main")
    private OWMMain main;
}
