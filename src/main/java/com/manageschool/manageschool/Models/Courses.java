package com.manageschool.manageschool.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Courses {

    private SimpleIntegerProperty courseCounter;
    private SimpleStringProperty courseTitle;
    private SimpleStringProperty courseCode;
    private SimpleIntegerProperty creditHours;
    private SimpleIntegerProperty ects;

    public int getCourseCounter() {
        return courseCounter.get();
    }

    public SimpleIntegerProperty courseCounterProperty() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter.set(courseCounter);
    }

    public String getCourseTitle() {
        return courseTitle.get();
    }

    public SimpleStringProperty courseTitleProperty() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle.set(courseTitle);
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public SimpleStringProperty courseCodeProperty() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode.set(courseCode);
    }

    public int getCreditHours() {
        return creditHours.get();
    }

    public SimpleIntegerProperty creditHoursProperty() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours.set(creditHours);
    }

    public int getEcts() {
        return ects.get();
    }

    public SimpleIntegerProperty ectsProperty() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects.set(ects);
    }

    public Courses(int courseCounter, String courseTitle, String courseCode, int creditHours, int ects) {
        this.courseCounter = new SimpleIntegerProperty(courseCounter);
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.courseCode = new SimpleStringProperty(courseCode);
        this.creditHours = new SimpleIntegerProperty(creditHours);
        this.ects = new SimpleIntegerProperty(ects);
    }
}
