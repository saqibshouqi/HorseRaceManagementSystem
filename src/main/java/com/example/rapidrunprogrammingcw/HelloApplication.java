package com.example.rapidrunprogrammingcw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);
        stage.setTitle("Rapid Run");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void onSelectFourHorsesButtonClick(Object o) {
    }

    public void onAddHorseDetailsButtonClick(Object o) {
    }

    public void onUpdateHorseDetailsButtonClick(Object o) {
    }

    public void onDeleteHorseDetailsButtonClick(Object o) {
    }

    public void onWinningHorseDetailsButtonClick(Object o) {
    }

    public void onVisualizeWinningHorsesButtonClick(Object o) {
    }
}