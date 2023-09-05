package com.manageschool.manageschool.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCourses {

    private ObservableList<Courses> getCourses(String query) throws SQLException {
        ObservableList<Courses> observableList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                int colCounter = result.getInt("CourseCounter");
                String colTitle = result.getString("CourseTitle");
                String colCode = result.getString("CourseCode");
                int colCredit = result.getInt("CourseCredit");
                int colEcts = colCredit + 2;
                Courses course = new Courses(colCounter, colTitle, colCode, colCredit, colEcts);
                observableList.add(course);
            }
        } catch (SQLException e) {
            throw new SQLException("Error while selecting data from the database", e);
        }
        return observableList;
    }

    public ObservableList<Courses> populate() throws SQLException {
        String query = "SELECT * FROM course";
        return getCourses(query);
    }

    public ObservableList<Courses> populateTopFiveCourse() throws SQLException {
        String query = """
                SELECT *
                FROM manageschool_v2.course
                ORDER BY CourseCounter DESC
                LIMIT 5;""";
        return getCourses(query);
    }

    public ObservableList<Courses> populateWithUsersCourses() throws SQLException {
        String query = """
                SELECT *
                FROM manageschool_v2.course
                ORDER BY CourseCounter DESC
                LIMIT 5;""";
        return getCourses(query);
    }
}
