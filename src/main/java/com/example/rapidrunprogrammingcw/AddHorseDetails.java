package com.example.rapidrunprogrammingcw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.util.List;

public class AddHorseDetails {

    @FXML
    TextField horseId;
    @FXML
    TextField horseName;
    @FXML
    TextField jockeyName;
    @FXML
    TextField age;
    @FXML
    TextField breed;
    @FXML
    TextField raceRecord;
    @FXML
    ChoiceBox<String> group;

    private String[] hGroup = {"Group A", "Group B", "Group C", "Group D"};


    public void initialize() {
        group.getItems().addAll(hGroup);
    }

    public void onAddButtonClick(ActionEvent actionEvent) {
        try {
            int hId = Integer.parseInt(horseId.getText());
            String hName = horseName.getText();
            String jName = jockeyName.getText();
            int horseAge = Integer.parseInt(age.getText());
            String horseBreed = breed.getText();
            String record = raceRecord.getText();
            String horseGroup = group.getValue();

            List<List<Horse>> horseData = HorseDataManager.getHorseData();
            for (List<Horse> horseList : horseData) {
                for (Horse horse : horseList) {
                    if (horse.getId() == hId) {
                        showAlert("Horse with ID " + hId + " already exists.");
                        closeWindow(actionEvent);
                        return;
                    }
                }
            }

            if (hName.isEmpty() || jName.isEmpty() || horseBreed.isEmpty() || record.isEmpty() || horseGroup.isEmpty()) {
                showAlert("Please fill in all fields.");
            } else {
                Horse horse = new Horse(hId, hName, jName, horseAge, horseBreed, record, horseGroup, "");
                HorseDataManager.addHorse(horse);
                showAlert("Horse Details are Added Successfully!");
                closeWindow(actionEvent);
            }
        } catch (NumberFormatException e) {
            showAlert("ID and Age must be integers.\nPlease fill in all fields.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) horseId.getScene().getWindow();
        stage.close();
    }

}










