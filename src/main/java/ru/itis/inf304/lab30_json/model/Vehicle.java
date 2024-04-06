package ru.itis.inf304.lab30_json.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String type;
    private Properties properties;
    private Features[] features;
}
