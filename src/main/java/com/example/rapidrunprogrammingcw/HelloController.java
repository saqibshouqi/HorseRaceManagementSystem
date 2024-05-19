package com.example.rapidrunprogrammingcw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private boolean raceStarted = false;

    @FXML
    private Button startTheRace;

    @FXML
    private void initialize() {
        startTheRace.setOnAction(event -> onStartTheRaceButtonClick(event));
    }





    public void onAddHorseDetailsButtonClick(ActionEvent actionEvent) throws Exception {
        if (raceStarted) {
            showAlert("Cannot add horse details as the race has started.");
        } else {
            addHorseDetails();
        }
    }

    public void onUpdateHorseDetailsButtonClick(ActionEvent actionEvent) throws Exception {
        if (raceStarted) {
            showAlert("Cannot update horse details as the race has started.");
        } else {
            updateHorseDetails();
        }
    }

    public void onDeleteHorseDetailsButtonClick(ActionEvent actionEvent) throws Exception {
        if (raceStarted) {
            showAlert("Cannot delete horse details as the race has started.");
        } else {
            deleteHorseDetails();
        }
    }

    public void onStartTheRaceButtonClick(ActionEvent actionEvent) {
        raceStarted = true;
        showAlert("Race has Started!");
    }

    public void onSaveHorseDetailsButtonClick(ActionEvent actionEvent) {
            HorseDataManager.saveHorseDetailsToFile();
        showAlert("Horse Details are saved successfully!");
    }

    public void onSelectFourHorsesButtonClick(ActionEvent actionEvent) throws IOException {
        if (!raceStarted) {
            showAlert("Please start the race first.");
        } else {
            selectFourHorses();
        }
    }

    public void onWinningHorseDetailsButtonClick(ActionEvent actionEvent) throws IOException {
        if (!raceStarted) {
            showAlert("Please start the race first.");
        } else {
            winningHorseDetails();
        }
    }

    public void onVisualizeWinningHorsesButtonClick(ActionEvent actionEvent) throws IOException {
        if (!raceStarted) {
            showAlert("Please start the race first.");
        } else {
            visualizeWinningHorses();
        }
    }

    public void onViewHorseDetailsButtonClick(ActionEvent actionEvent) throws IOException {
        viewHorseDetails();
    }

    public void onExitTheProgramButtonClick(ActionEvent actionEvent) {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void addHorseDetails() throws Exception {
        Stage stage = new Stage();
        stage.setScene(AppUtils.loadScene("AddHorseDetails.fxml", "Rapid Run - Add Horse Details"));
        stage.show();
    }

    private void updateHorseDetails() throws Exception {
        Stage stage = new Stage();
        stage.setScene(AppUtils.loadScene("UpdateHorseDetails.fxml", "Rapid Run - Update Horse Details"));
        stage.show();
    }

    private void deleteHorseDetails() throws Exception {
        Stage stage = new Stage();
        stage.setScene(AppUtils.loadScene("DeleteHorseDetails.fxml", "Rapid Run - Delete Horse Details"));
        stage.show();
    }

    private void selectFourHorses() throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SelectFourHorses.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane, 600, 400); // Set the desired width and height
        stage.setScene(scene);
        stage.setTitle("Rapid Run - Select Four Horses");
        stage.show();
    }

    private void winningHorseDetails() throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinningHorseDetails.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane, 600, 400); // Set the desired width and height
        stage.setScene(scene);
        stage.setTitle("Rapid Run - Winning Horse Details");
        stage.show();
    }

    private void viewHorseDetails() throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewHorseDetails.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane, 600, 400); // Set the desired width and height
        stage.setScene(scene);
        stage.setTitle("Rapid Run - View Horse Details");
        stage.show();
    }

    private void visualizeWinningHorses() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VisualizeWinningHorses.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane, 600, 400); // Set the desired width and height
        stage.setScene(scene);
        stage.setTitle("Rapid Run - Visualize Winning Horses");
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
