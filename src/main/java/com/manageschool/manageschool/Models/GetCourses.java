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

        Connection conn = null;
        ResultSet result = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password");
            preparedStatement = conn.prepareStatement("SELECT * FROM course");
            result = preparedStatement.executeQuery();
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
        } finally {
            // Close resources (result set, statement, and connection) here
            if (result != null) {
                result.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return observableList;
    }
}
