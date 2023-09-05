package com.manageschool.manageschool.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetStudents {
    public ObservableList<Students> populateTopFiveStudents() throws SQLException {
        ObservableList<Students> observableList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password"); PreparedStatement preparedStatement = conn.prepareStatement("""
                SELECT e.GradeCounter, s.StudentName, s.StudentID, e.CourseCode, e.Grade
                FROM student s
                INNER JOIN enrolment e ON s.StudentID = e.StudentID
                ORDER BY e.StudentID Desc
                LIMIT 5;"""); ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                int colCounter = result.getInt("GradeCounter");
                String colName = result.getString("StudentName");
                String colID = result.getString("StudentId");
                String colCode = result.getString("CourseCode");
                String colGrade = result.getString("Grade");
                Students students = new Students(colCounter, colID, colName, colCode, colGrade);
                observableList.add(students);
            }
        } catch (SQLException e) {
            throw new SQLException("Error while selecting data from the database", e);
        }
        return observableList;
    }
}
