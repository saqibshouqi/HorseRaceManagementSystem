package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SelectFourHorses {

    private static List<Horse> randomlySelectedHorses;

    @FXML
    private TableView<Horse> horseTableView;

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



    public static List<Horse> getRandomlySelectedHorses() {
        return randomlySelectedHorses;
    }

    public void initialize() {
        if (horseTableView != null && idColumn != null && nameColumn != null && jockeyColumn != null &&
                ageColumn != null && breedColumn != null && raceRecordColumn != null && groupColumn != null) {

            horseTableView.getItems().clear(); // Clear the table first

            randomlySelectedHorses = HorseDataManager.selectRandomHorses();

            idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
            jockeyColumn.setCellValueFactory(cellData -> cellData.getValue().jockeyProperty());
            ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
            breedColumn.setCellValueFactory(cellData -> cellData.getValue().breedProperty());
            raceRecordColumn.setCellValueFactory(cellData -> cellData.getValue().raceRecordProperty());
            groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupProperty());


            horseTableView.getItems().addAll(randomlySelectedHorses);
        } else {
            System.out.println("FXML elements are null. Please check FXML file.");
        }
    }
}
