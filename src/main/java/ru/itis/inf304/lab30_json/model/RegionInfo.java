package ru.itis.inf304.lab30_json.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionInfo {
    private Integer id;
    private Integer type;
    private Integer capitalId;
    private Integer[] hierarchy;
    private String seoname;
    private Double[][] bounds;
    private Double longitude;
    private Double latitude;
    private Integer zoom;
    private Names names;
    private RegionInfo parentRegion; // not in parent region
    private String title; // not in parent region
    private String subtitle; // not in parent region

}
