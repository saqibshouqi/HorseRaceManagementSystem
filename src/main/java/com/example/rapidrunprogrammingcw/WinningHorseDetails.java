package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Comparator;
import java.util.List;

public class WinningHorseDetails {

    @FXML
    private TableView<Horse> horseTableView;

    @FXML
    private TableColumn<Horse, Integer> positionColumn;

    @FXML
    private TableColumn<Horse, Integer> timeColumn;

    @FXML
    private TableColumn<Horse, Integer> idColumn;

    @FXML
    private TableColumn<Horse, String> nameColumn;

    @FXML
    private TableColumn<Horse, String> jockeyColumn;

    @FXML
    private TableColumn<Horse, Integer> ageColumn;

    @FXML
    private TableColumn<Horse, String> breedColumn;

    @FXML
    private TableColumn<Horse, String> raceRecordColumn;

    @FXML
    private TableColumn<Horse, String> groupColumn;

    public void initialize() {
        if (horseTableView != null && positionColumn != null && timeColumn != null && idColumn != null &&
                nameColumn != null && jockeyColumn != null && ageColumn != null && breedColumn != null &&
                raceRecordColumn != null && groupColumn != null) {

            horseTableView.getItems().clear(); // Clear the table first

            // Get the randomly selected horses from SelectFourHorses
            List<Horse> randomHorses = SelectFourHorses.getRandomlySelectedHorses();

            // Assign random time and calculate positions
            assignRandomTime(randomHorses);
            calculatePositions(randomHorses);

            // Set cell value factories for each column
            positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            jockeyColumn.setCellValueFactory(new PropertyValueFactory<>("jockey"));
            ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
            breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));
            raceRecordColumn.setCellValueFactory(new PropertyValueFactory<>("raceRecord"));
            groupColumn.setCellValueFactory(new PropertyValueFactory<>("group")); // Bind group column

            // Add horses to the table
            horseTableView.getItems().addAll(randomHorses);

            // Sort horses by position
            horseTableView.getItems().sort(Comparator.comparingInt(Horse::getPosition));
        } else {
            System.out.println("FXML elements are null. Please check FXML file.");
        }
    }

    private void assignRandomTime(List<Horse> horses) {
        for (Horse horse : horses) {
            int randomTime = (int) (Math.random() * 91); // Generate random time between 0 and 90
            horse.setTime(randomTime);
        }
    }

    private void calculatePositions(List<Horse> horses) {
        horses.sort(Comparator.comparingInt(Horse::getTime)); // Sort horses by time
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).setPosition(i + 1); // Assign position based on sorted order
        }
    }
}
