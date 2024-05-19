package com.example.rapidrunprogrammingcw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class UpdateHorseDetails {

    @FXML
    private TextField horseId;
    @FXML
    private TextField horseName;
    @FXML
    private TextField jockeyName;
    @FXML
    private TextField age;
    @FXML
    private TextField breed;
    @FXML
    private TextField raceRecord;
    @FXML
    private TextField group;


    public void onUpdateButtonClick(ActionEvent actionEvent) {
        try {
            int idToUpdate = Integer.parseInt(horseId.getText());
            List<List<Horse>> horseData = HorseDataManager.getHorseData();

            boolean found = false;
            for (List<Horse> horseList : horseData) {
                for (Horse horse : horseList) {
                    if (horse.getId() == idToUpdate) {
                        horse.setName(horseName.getText());
                        horse.setJockey(jockeyName.getText());
                        horse.setAge(Integer.parseInt(age.getText()));
                        horse.setBreed(breed.getText());
                        horse.setRaceRecord(raceRecord.getText());
                        horse.setGroup(group.getText());

                        showAlert("Horse details updated successfully!");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                showAlert("Horse with ID " + idToUpdate + " not found!");
            }
            closeWindow();
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid horse ID and age.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Horse");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void closeWindow() {
        Stage stage = (Stage) horseId.getScene().getWindow();
        stage.close();
    }


}
