package ru.itis.inf304.lab30_json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeaturesProperty {
    private String type;
    @JsonProperty("TrajectorySegmentMetaData")
    private TrajectorySegmentMetaData trajectorySegmentMetaData; // trajectorySegmentMetaData
}
