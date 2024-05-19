package com.example.rapidrunprogrammingcw;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class VisualizeWinningHorses {
    @FXML
    private BarChart<String, Number> barChart;

    public void initialize() {
        if (barChart != null) {
            // Get the randomly selected horses from WinningHorseDetails
            List<Horse> randomHorses = SelectFourHorses.getRandomlySelectedHorses();

            // Create axes
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Horse");
            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Time (seconds)");

            // Create a series for the bar chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();

            // Add data to the series
            for (Horse horse : randomHorses) {
                series.getData().add(new XYChart.Data<>(horse.getName(), horse.getTime()));
            }

            // Add the series to the bar chart
            barChart.getData().add(series);

        } else {
            System.out.println("FXML element 'barChart' is null. Please check FXML file.");
        }
    }
}
