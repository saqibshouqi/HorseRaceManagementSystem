package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Comparator;
import java.util.List;

public class ViewHorseDetails {

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


    public void initialize() {
        if (horseTableView != null && idColumn != null && nameColumn != null && jockeyColumn != null &&
                ageColumn != null && breedColumn != null && raceRecordColumn != null && groupColumn != null ) {

            idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
            jockeyColumn.setCellValueFactory(cellData -> cellData.getValue().jockeyProperty());
            ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
            breedColumn.setCellValueFactory(cellData -> cellData.getValue().breedProperty());
            raceRecordColumn.setCellValueFactory(cellData -> cellData.getValue().raceRecordProperty());
            groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupProperty());



            List<List<Horse>> horseData = HorseDataManager.getHorseData();
            horseTableView.getItems().clear();
            for (List<Horse> horseList : horseData) {
                horseTableView.getItems().addAll(horseList);
            }

            horseTableView.getItems().sort(Comparator.comparingInt(Horse::getId));
        } else {
            System.out.println("FXML elements are null. Please check FXML file.");
        }
    }
}
