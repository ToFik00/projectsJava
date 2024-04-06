package ru.itis.inf304.lab30_json.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    private Vehicle[] vehicles;
    private RegionInfo regionInfo;
}
