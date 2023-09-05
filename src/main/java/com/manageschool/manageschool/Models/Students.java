package com.manageschool.manageschool.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Students {
    private final SimpleIntegerProperty studentCounter;
    private final SimpleStringProperty studentID;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty studentCourseCode;
    private final SimpleStringProperty studentGrade;

    public int getStudentCounter() {
        return studentCounter.get();
    }

    public SimpleIntegerProperty studentCounterProperty() {
        return studentCounter;
    }

    public void setStudentCounter(int studentCounter) {
        this.studentCounter.set(studentCounter);
    }

    public String getStudentID() {
        return studentID.get();
    }

    public SimpleStringProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID.set(studentID);
    }

    public String getStudentName() {
        return studentName.get();
    }

    public SimpleStringProperty studentNameProperty() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getStudentCourseCode() {
        return studentCourseCode.get();
    }

    public SimpleStringProperty studentCourseCodeProperty() {
        return studentCourseCode;
    }

    public void setStudentCourseCode(String studentCourseCode) {
        this.studentCourseCode.set(studentCourseCode);
    }

    public String getStudentGrade() {
        return studentGrade.get();
    }

    public SimpleStringProperty studentGradeProperty() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade.set(studentGrade);
    }

    public Students(int studentCounter, String studentID, String studentName, String studentCourseCode, String studentGrade) {
        this.studentCounter = new SimpleIntegerProperty(studentCounter);
        this.studentID = new SimpleStringProperty(studentID);
        this.studentName = new SimpleStringProperty(studentName);
        this.studentCourseCode = new SimpleStringProperty(studentCourseCode);
        this.studentGrade = new SimpleStringProperty(studentGrade);
    }
}
