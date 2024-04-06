package ru.itis.inf304.lab30_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.inf304.lab30_json.model.Data;
import ru.itis.inf304.lab30_json.model.DataBase;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DataBase dataBase = mapper.readValue(new File("transport.json"), DataBase.class);
        Data data = dataBase.getData();
        System.out.println("tramways names: ");
        Arrays.stream(data.getVehicles())
                .filter(vehicle -> vehicle
                        .getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getType()
                        .equals("tramway"))
                .forEach(e -> System.out.println(e.getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName()));

        Set<String> setNumberOfBuses = Arrays.stream(data.getVehicles())
                .filter(vehicle -> vehicle
                        .getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getType()
                        .equals("bus"))
                .map(e -> e.getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName())
                .collect(Collectors.toSet());
        System.out.println("setNumberOfBuses: " + setNumberOfBuses);
        // Что ещё можно сделать из этого файла?

        String[] ids = Arrays.stream(data.getVehicles())
                .filter(vehicle -> vehicle
                        .getProperties()
                        .getVehicleMetaData()
                        .getTransport()
                        .getName()
                        .equals("5"))
                .map(e -> e.getProperties()
                        .getVehicleMetaData()
                        .getId())
                .toArray(String[]::new);
        System.out.println("ids: " + Arrays.toString(ids));
    }
}

