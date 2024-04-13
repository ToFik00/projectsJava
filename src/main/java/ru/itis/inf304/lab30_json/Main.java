package ru.itis.inf304.lab30_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.inf304.lab30_json.model.Data;
import ru.itis.inf304.lab30_json.model.DataBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DataBase dataBase = mapper.readValue(new File("transport.json"), DataBase.class);
        Data data = dataBase.getData();
        fourthPrint(data);
        fifthPrint(data);
        sixthPrint(data);
    }

    public static Set<String> types(Data data) {
        return Arrays.stream(data.getVehicles())
                .map(e -> e.getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getType()).collect(Collectors.toSet());
    }

    public static int amoutOfType(Data data, String name, String type) {
        return (int) Arrays.stream(data.getVehicles())
                .filter(vehicle -> vehicle
                        .getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName()
                        .equals(name)
                        && vehicle
                        .getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getType()
                        .equals(type))
                .count();
    }

    public static Map<String, Integer> getMapOfVehicles(Data data) {
        return Arrays.stream(data.getVehicles())
                .collect(Collectors.toMap(e -> e.getProperties()
                        .getVehicleMetaData().getId(), e -> Arrays.stream(e.getFeatures())
                        .mapToInt(f -> f.getGeometry().getCoordinates().length).sum()));
    }

    public static void fourthPrint(Data data) {
        Arrays.stream(data.getVehicles())
                .sorted(Comparator.comparing(v -> v.getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName()))
                .forEach(v -> System.out.println("number: " + v.getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName() +
                        ", type: " + v.getProperties()
                        .getVehicleMetaData()
                        .getTransport().getType() +
                        ", id: " + v.getProperties()
                        .getVehicleMetaData()
                        .getTransport().getType()));

    }

    public static void fifthPrint(Data data) {
        Map<String, String[]> map = Arrays.stream(data.getVehicles())
                .collect(Collectors.toMap(e -> e.getProperties()
                        .getVehicleMetaData().getId(), e -> Arrays.stream(e.getFeatures())
                        .map(f -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                                .format(Date.from(Instant.ofEpochSecond(f.getProperties()
                                        .getTrajectorySegmentMetaData()
                                        .getTime())))).toArray(String[]::new)));
        map.keySet().forEach(e -> System.out.println(e + " " + Arrays.toString(map.get(e))));
    }

    public static void sixthPrint(Data data) {
        Arrays.stream(data.getVehicles())
                .filter(v -> {
            String type = v.getProperties().getVehicleMetaData().getTransport().getType();
            return type.equals("tramway") || type.equals("bus") || type.equals("trolleybus");})
                .forEach(v -> System.out.println(v.getProperties().getVehicleMetaData().getId()));
    }
}

