package com.manageschool.manageschool.Controllers.Admin;

import com.manageschool.manageschool.Models.Model;
import com.manageschool.manageschool.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button dashboard_btn;
    public Button add_student_btn;
    public Button create_courses_btn;
    public Button create_report_cards;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(event -> onDashboard());
        add_student_btn.setOnAction(event -> onAddStudent());
        create_courses_btn.setOnAction(event -> onCreateCourse());
        create_report_cards.setOnAction(event -> onCreateReport());
        logout_btn.setOnAction(event -> backToLogin());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getAdminSelectorMenuItem().set(AdminMenuOptions.DASHBOARD);
    }

    private void onAddStudent() {
        Model.getInstance().getViewFactory().getAdminSelectorMenuItem().set(AdminMenuOptions.ADD_STUDENT);
    }
    private void onCreateCourse() {
        Model.getInstance().getViewFactory().getAdminSelectorMenuItem().set(AdminMenuOptions.CREATE_COURSE);
    }

    private void onCreateReport() {
        Model.getInstance().getViewFactory().getAdminSelectorMenuItem().set(AdminMenuOptions.CREATE_REPORT);
    }


    private void backToLogin() {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}
