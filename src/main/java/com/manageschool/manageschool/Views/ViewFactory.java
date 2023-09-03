package com.manageschool.manageschool.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    // Student View
    // Admin View


    // the constructor
    public ViewFactory(){
        this.loginAccountType = AccountType.STUDENT;
    }

    public AccountType getLoginAccountType() {return loginAccountType;}

    public void setLoginAccountType(AccountType loginAccountType){this.loginAccountType = loginAccountType;}


    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }
    public void showAdminWindow() {
    }
    public void showStudentWindow() {
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Manage School");
        stage.show();
    }

    public void closeStage(Stage stage) {stage.close();}
}

