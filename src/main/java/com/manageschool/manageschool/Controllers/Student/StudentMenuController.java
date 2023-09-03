package com.manageschool.manageschool.Controllers.Student;

import com.manageschool.manageschool.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {
    public Button courses_btn;
    public Button report_cards;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        courses_btn.setOnAction(event -> onCourses());
        report_cards.setOnAction(event -> onReports());
        profile_btn.setOnAction(event -> onProfile());
        logout_btn.setOnAction(event -> backToLogin());
        
    }

    private void backToLogin() {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    private void onProfile() {
    }

    private void onReports() {
    }

    private void onCourses() {
    }
}
