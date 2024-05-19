package com.example.rapidrunprogrammingcw;

import javafx.application.Application;
import javafx.stage.Stage;

public class VisualizeWinningHorsesTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the main application
        HelloApplication app = new HelloApplication();
        app.start(primaryStage);

        // Click on the "Visualize Winning Horses" button programmatically
        app.onVisualizeWinningHorsesButtonClick(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
