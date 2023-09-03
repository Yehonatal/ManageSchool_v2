package com.manageschool.manageschool.Views;

import com.manageschool.manageschool.Controllers.Student.StudentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class ViewFactory {
    private AccountType loginAccountType;

    // Student View
    private AnchorPane coursesView;
    // Admin View


    // the constructor
    public ViewFactory(){
        this.loginAccountType = AccountType.STUDENT;
    }


    public AnchorPane getCoursesView(){
        if(coursesView == null){
            try{
                coursesView = new FXMLLoader(getClass().getResource("/Fxml/Student/Courses.fxml")).load();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return coursesView;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Student/StudentSideView.fxml"));
        StudentController studentController = new StudentController();
        loader.setController(studentController);
        createStage(loader);
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
        Image icon = new Image(getClass().getResourceAsStream("/Images/school.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Manage School");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void closeStage(Stage stage) {stage.close();}
}

