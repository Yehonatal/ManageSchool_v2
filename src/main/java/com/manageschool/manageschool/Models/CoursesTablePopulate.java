package com.manageschool.manageschool.Models;

public class CoursesTablePopulate {

    private String courseTitle;
    private String courseCode;
    private int creditHours;
    private int ects;

    public CoursesTablePopulate(String courseTitle, String courseCode, int creditHours, int ects) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.ects = ects;
    }
}
