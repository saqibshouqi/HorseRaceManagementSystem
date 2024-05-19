package com.example.rapidrunprogrammingcw;

import static org.junit.jupiter.api.Assertions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ViewHorseDetailsTest {

    @Test
    public void testInitializeTableView() {
        // Create some sample horse data
        ObservableList<Horse> horseList = FXCollections.observableArrayList();
        horseList.add(new Horse(1, "Horse 1", "Jockey 1", 5, "Breed 1", "Record 1", "Group A", ""));
        horseList.add(new Horse(2, "Horse 2", "Jockey 2", 6, "Breed 2", "Record 2", "Group B", ""));

        // Create the TableView
        TableView<Horse> tableView = new TableView<>();
        TableColumn<Horse, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        TableColumn<Horse, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TableColumn<Horse, String> jockeyColumn = new TableColumn<>("Jockey");
        jockeyColumn.setCellValueFactory(cellData -> cellData.getValue().jockeyProperty());
        TableColumn<Horse, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        TableColumn<Horse, String> breedColumn = new TableColumn<>("Breed");
        breedColumn.setCellValueFactory(cellData -> cellData.getValue().breedProperty());
        TableColumn<Horse, String> recordColumn = new TableColumn<>("Race Record");
        recordColumn.setCellValueFactory(cellData -> cellData.getValue().raceRecordProperty());
        TableColumn<Horse, String> groupColumn = new TableColumn<>("Group");
        groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupProperty());

        tableView.getColumns().addAll(idColumn, nameColumn, jockeyColumn, ageColumn, breedColumn, recordColumn, groupColumn);
        tableView.setItems(horseList);

        // Test TableView initialization
        assertNotNull(tableView);
        assertNotNull(tableView.getColumns());
        assertEquals(7, tableView.getColumns().size()); // Expecting 7 columns
        assertNotNull(tableView.getItems());
        assertEquals(2, tableView.getItems().size()); // Expecting 2 items (2 horses)
    }
}
