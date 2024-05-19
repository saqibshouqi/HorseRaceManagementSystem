package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class DeleteHorseDetails {

    @FXML
    private TextField horseId;

    public void onDeleteButtonClick() {
        try {
            int idToDelete = Integer.parseInt(horseId.getText());
            List<List<Horse>> horseData = HorseDataManager.getHorseData();

            for (List<Horse> horseList : horseData) {
                for (Horse horse : horseList) {
                    if (horse.getId() == idToDelete) {
                        horseList.remove(horse);
                        showAlert("Horse with ID " + idToDelete + " has been deleted successfully.");
                        closeWindow();
                        return;
                    }
                }
            }

            showAlert("Horse with ID " + idToDelete + " is not present.");
            closeWindow();
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid horse ID.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Horse");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void closeWindow() {
        Stage stage = (Stage) horseId.getScene().getWindow();
        stage.close();
    }
}
