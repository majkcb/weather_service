package org.example.labb3.model.met;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "meta",
    "timeseries"
})
@Generated("jsonschema2pojo")
public class MetProperties {

    @JsonProperty("meta")
    private MetMeta meta;
    @JsonProperty("timeseries")
    private List<MetTimeseries> timeseries;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("meta")
    public MetMeta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(MetMeta meta) {
        this.meta = meta;
    }

    @JsonProperty("timeseries")
    public List<MetTimeseries> getTimeseries() {
        return timeseries;
    }

    @JsonProperty("timeseries")
    public void setTimeseries(List<MetTimeseries> timeseries) {
        this.timeseries = timeseries;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetProperties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
        sb.append(',');
        sb.append("timeseries");
        sb.append('=');
        sb.append(((this.timeseries == null)?"<null>":this.timeseries));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
