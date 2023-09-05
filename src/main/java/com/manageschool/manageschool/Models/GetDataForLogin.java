package com.manageschool.manageschool.Models;

import java.sql.*;

public class GetDataForLogin {
    public boolean getVerified(String usr, String psw, String table) throws SQLException {
        if (table.equals("admin")) {
            return selectData(usr, psw, "administer", "AdminUserName", "AdminPassword");
        }
        if (table.equals("student")) {
            return selectData(usr, psw, "student", "StudentName", "StudentUserName");
        }
        return false;
    }

    public boolean selectData(String user, String psw, String table, String userColumn, String pswColumn) throws SQLException {
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool_v2", "sqluser", "password");
            preparedStatement = conn.prepareStatement(
                    String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", table, userColumn, pswColumn)
            );
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, psw);
            result = preparedStatement.executeQuery();

            return result.next();
        } catch (SQLException e) {
            throw new SQLException("Error while selecting data from the database", e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

