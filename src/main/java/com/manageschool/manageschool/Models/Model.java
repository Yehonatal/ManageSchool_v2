package com.manageschool.manageschool.Models;

import com.manageschool.manageschool.Views.ViewFactory;

import java.sql.*;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private Model() {this.viewFactory = new ViewFactory();}
    public static synchronized Model getInstance(){
        if (model == null){ model = new Model();}
        return model;
    }

    public ViewFactory getViewFactory() {return viewFactory;}

    public boolean getVerified(String usr, String psw, String table) throws SQLException {
        if (table.equals("admin")) { return selectData(usr, psw, "adminLog","adminUserName","adminUserPsw");}
        if (table.equals("student")) { return selectData(usr,psw,"studentLog","studentName","studentId");}
        return false;
    }

    public boolean selectData(String user, String psw, String table, String userColumn, String pswColumn) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manageschool", "sqluser", "password");
        ResultSet result;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", table, userColumn, pswColumn)
            );
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, psw);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
