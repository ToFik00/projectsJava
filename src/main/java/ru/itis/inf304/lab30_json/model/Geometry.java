package ru.itis.inf304.lab30_json.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Geometry {
    private String type;
    private Double[][] coordinates;
}
