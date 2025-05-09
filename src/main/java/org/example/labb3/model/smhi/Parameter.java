package org.example.labb3.model.smhi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("levelType")
    private String levelType;

    @JsonProperty("level")
    private int level;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("values")
    private List<Double> values;

}

