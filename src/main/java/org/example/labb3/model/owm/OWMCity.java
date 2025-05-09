package org.example.labb3.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OWMCity {
    @JsonProperty("name")
    private String name;
}
