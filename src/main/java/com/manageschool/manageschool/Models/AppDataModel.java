package com.manageschool.manageschool.Models;

public class AppDataModel {
    private String username;
    private String userID;
    // Other fields you need...

    private static AppDataModel instance; // Singleton instance

    public AppDataModel() {
        // Private constructor to enforce singleton pattern
    }

    public static AppDataModel getInstance() {
        if (instance == null) {
            instance = new AppDataModel();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
