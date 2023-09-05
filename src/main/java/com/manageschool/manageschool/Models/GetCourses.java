package com.manageschool.manageschool.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCourses {

    public ObservableList<Courses> populate() throws SQLException {
        ObservableList<Courses> observableList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password"); PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM course"); ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                int colCounter = result.getInt("CourseCounter");
                String colTitle = result.getString("CourseTitle");
                String colCode = result.getString("CourseCode");
                int colCredit = result.getInt("CourseCredit");
                int colEcts = result.getInt("CourseCredit") + 2;
                Courses course = new Courses(colCounter, colTitle, colCode, colCredit, colEcts);
                observableList.add(course);
            }
        } catch (SQLException e) {
            throw new SQLException("Error while selecting data from the database", e);
        }
        // Close resources (result set, statement, and connection) here
        return observableList;
    }

    public ObservableList<Courses> populateTopFiveCourse() throws SQLException {
        ObservableList<Courses> observableList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password"); PreparedStatement preparedStatement = conn.prepareStatement("""
                SELECT * FROM manageschool_v2.course
                ORDER BY CourseCounter DESC
                LIMIT 5;"""); ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                int colCounter = result.getInt("CourseCounter");
                String colTitle = result.getString("CourseTitle");
                String colCode = result.getString("CourseCode");
                int colCredit = result.getInt("CourseCredit");
                int colEcts = result.getInt("CourseCredit") + 2;
                Courses course = new Courses(colCounter, colTitle, colCode, colCredit, colEcts);
                observableList.add(course);
            }
        } catch (SQLException e) {
            throw new SQLException("Error while selecting data from the database", e);
        }
        // Close resources (result set, statement, and connection) here
        return observableList;
    }


}
