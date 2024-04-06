package ru.itis.inf304.lab30_json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transport {
    private String id;
    private String threadId;
    private String lineId;
    private String name;
    @JsonProperty("Types")
    private String[] types; // types
    private String type;
    private String uri;
    private String seoname;
}
