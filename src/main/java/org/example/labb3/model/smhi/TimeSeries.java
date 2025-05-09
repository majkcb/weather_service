package org.example.labb3.model.smhi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSeries {

    @JsonProperty("validTime")
    private String validTime;

    @JsonProperty("parameters")
    private List<Parameter> parameters;

}
