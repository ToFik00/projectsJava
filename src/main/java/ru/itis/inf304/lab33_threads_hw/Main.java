package ru.itis.inf304.lab33_threads_hw;


import ru.itis.inf304.lab33_threads_hw.brigades.*;
import ru.itis.inf304.lab33_threads_hw.description_work.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Work[] plan = preparePlan();
        Construction construction = new Construction(prepareBrigades(plan), plan);
        try {
            construction.start();
            construction.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Выполнили за " + (construction.getTimeConstruction() / 1000) + " д.");
        construction.getBrigades().forEach((k, v) -> System.out.println("Бригада: " + k
                + " Дни в игре домино: " + v.getDominoDays()));
    }

    private static Work[] preparePlan() {
        Work[] workThreads = new Work[17];
        workThreads[0] = new BeginningWork();
        workThreads[1] = new Project();
        workThreads[2] = new ManufacturingWindows();
        workThreads[3] = new MakingDoors();
        workThreads[4] = new FoundationConstruction();
        workThreads[5] = new LayingCommunications();
        workThreads[6] = new ErectionWalls();
        workThreads[7] = new RoofConstruction();
        workThreads[8] = new InstallationWindows();
        workThreads[9] = new DoorInstallation();
        workThreads[10] = new InstallationHeatingDevices();
        workThreads[11] = new ElectricalWiring();
        workThreads[12] = new FinishingWallsAndCeilings();
        workThreads[13] = new FloorFinishing();
        workThreads[14] = new InstallationLightingFixtures();
        workThreads[15] = new InstallationPlumbing();
        workThreads[16] = new CompletionConstruction();

        workThreads[1].setDependencies(workThreads[0]);
        workThreads[2].setDependencies(workThreads[1]);
        workThreads[3].setDependencies(workThreads[1]);
        workThreads[4].setDependencies(workThreads[1]);
        workThreads[5].setDependencies(workThreads[4]);
        workThreads[6].setDependencies(workThreads[4]);
        workThreads[7].setDependencies(workThreads[6]);
        workThreads[8].setDependencies(workThreads[2], workThreads[7]);
        workThreads[9].setDependencies(workThreads[3], workThreads[7]);
        workThreads[10].setDependencies(workThreads[5], workThreads[8], workThreads[9]);
        workThreads[11].setDependencies(workThreads[5], workThreads[7]);
        workThreads[12].setDependencies(workThreads[8], workThreads[9], workThreads[11]);
        workThreads[13].setDependencies(workThreads[12]);
        workThreads[14].setDependencies(workThreads[12]);
        workThreads[15].setDependencies(workThreads[5], workThreads[11], workThreads[12]);
        workThreads[16].setDependencies(Arrays.copyOfRange(workThreads, 0, 16));
        return workThreads;
    }

    private static Map<String, Speciality> prepareBrigades(Work[] plan) {
        Map<String, Speciality> brigadesWithTasks = new HashMap<>();
        brigadesWithTasks.put("Каменщики", new Speciality("Каменщики",
                plan[1],
                plan[4],
                plan[6]
        ) {
        });
        brigadesWithTasks.put("Плотники", new Speciality("Плотники",
                plan[1],
                plan[2],
                plan[3],
                plan[7],
                plan[8],
                plan[9]
        ));
        brigadesWithTasks.put("Сантехники", new Speciality("Сантехники",
                plan[1],
                plan[5],
                plan[10],
                plan[15]
        ));
        brigadesWithTasks.put("Штукатуры", new Speciality("Штукатуры",
                plan[1],
                plan[12],
                plan[13]
        ));
        brigadesWithTasks.put("Электрики", new Speciality("Электрики",
                plan[1],
                plan[11],
                plan[14]
        ));
        return brigadesWithTasks;
    }
}
