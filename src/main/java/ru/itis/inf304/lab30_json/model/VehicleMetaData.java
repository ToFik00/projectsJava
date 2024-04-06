package ru.itis.inf304.lab30_json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleMetaData {
    private String id;
    @JsonProperty("Transport")
    private Transport transport; // transport
}
