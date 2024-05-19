package com.example.rapidrunprogrammingcw;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class HorseDataManager {
    private static List<List<Horse>> horseData = new ArrayList<>();

    public static List<List<Horse>> getHorseData() {
        return horseData;
    }

    public static void addHorse(Horse horse) {
        List<Horse> newList = new ArrayList<>();
        newList.add(horse);
        horseData.add(newList);
    }

    public static void removeHorse(int index) {
        horseData.remove(index);
    }

    public static void saveHorseDetailsToFile() {
        try (FileWriter writer = new FileWriter("horse_details.txt")) {
            for (List<Horse> horseList : horseData) {
                for (Horse horse : horseList) {
                    writer.write(horse.getId() + "," +
                            horse.getName() + "," +
                            horse.getJockey() + "," +
                            horse.getAge() + "," +
                            horse.getBreed() + "," +
                            horse.getRaceRecord() + "," +
                            horse.getGroup() + "," +
                            horse.getImage() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Horse> selectRandomHorses() {
        List<Horse> selectedHorses = new ArrayList<>();
        Map<String, List<Horse>> groupedHorses = new HashMap<>();

        // Group horses by their group attribute
        for (List<Horse> horseList : horseData) {
            for (Horse horse : horseList) {
                String group = horse.getGroup();
                groupedHorses.putIfAbsent(group, new ArrayList<>());
                groupedHorses.get(group).add(horse);
            }
        }

        // Select one horse randomly from each group
        for (List<Horse> horsesInGroup : groupedHorses.values()) {
            if (!horsesInGroup.isEmpty()) {
                Horse selectedHorse = horsesInGroup.get(new Random().nextInt(horsesInGroup.size()));
                selectedHorses.add(selectedHorse);
            }
        }

        return selectedHorses;
    }
}