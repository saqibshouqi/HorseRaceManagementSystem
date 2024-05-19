package com.example.rapidrunprogrammingcw;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Horse {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty jockey = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();
    private final StringProperty breed = new SimpleStringProperty();
    private final StringProperty raceRecord = new SimpleStringProperty();
    private final StringProperty group = new SimpleStringProperty();
    private final StringProperty image = new SimpleStringProperty();
    private final IntegerProperty position = new SimpleIntegerProperty();
    private final IntegerProperty time = new SimpleIntegerProperty();

    public Horse(int id, String name, String jockey, int age, String breed, String raceRecord, String group, String image) {
        setId(id);
        setName(name);
        setJockey(jockey);
        setAge(age);
        setBreed(breed);
        setRaceRecord(raceRecord);
        setGroup(group);
        setImage(image);
    }

    // Getter and setter methods for position
    public int getPosition() {
        return position.get();
    }

    public void setPosition(int position) {
        this.position.set(position);
    }

    public IntegerProperty positionProperty() {
        return position;
    }

    // Getter and setter methods for time
    public int getTime() {
        return time.get();
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public IntegerProperty timeProperty() {
        return time;
    }

    // Getter methods for properties
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty jockeyProperty() {
        return jockey;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public StringProperty breedProperty() {
        return breed;
    }

    public StringProperty raceRecordProperty() {
        return raceRecord;
    }

    public StringProperty groupProperty() {
        return group;
    }

    public StringProperty imageProperty() {
        return image;
    }

    // Getter and setter methods for non-property fields
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getJockey() {
        return jockey.get();
    }

    public void setJockey(String jockey) {
        this.jockey.set(jockey);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getBreed() {
        return breed.get();
    }

    public void setBreed(String breed) {
        this.breed.set(breed);
    }

    public String getRaceRecord() {
        return raceRecord.get();
    }

    public void setRaceRecord(String raceRecord) {
        this.raceRecord.set(raceRecord);
    }

    public String getGroup() {
        return group.get();
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public String getImage() {
        return image.get();
    }

    public void setImage(String image) {
        this.image.set(image);
    }


}
