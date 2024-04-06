package ru.itis.inf304.lab30_json.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Features {
    private Geometry geometry;
    private FeaturesProperty properties;
}
