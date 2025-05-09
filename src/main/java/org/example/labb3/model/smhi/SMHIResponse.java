package org.example.labb3.model.smhi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMHIResponse {

    @JsonProperty("approvedTime")
    private String approvedTime;

    @JsonProperty("referenceTime")
    private String referenceTime;

    @JsonProperty("timeSeries")
    private List<TimeSeries> timeSeries;

}
