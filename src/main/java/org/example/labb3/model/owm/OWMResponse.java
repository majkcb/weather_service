package org.example.labb3.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class OWMResponse {

    @JsonProperty("list")
    private List<OWMForecastEntry> list;

    @JsonProperty("city")
    private OWMCity city;
}
