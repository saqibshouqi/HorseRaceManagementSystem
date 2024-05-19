package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AppUtils {
    public static Scene loadScene(String fxmlFile, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppUtils.class.getResource(fxmlFile));
        Pane pane = fxmlLoader.load();
        return new Scene(pane, 500, 400);
    }
}
