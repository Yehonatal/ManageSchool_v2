package com.manageschool.manageschool.Controllers.Admin;

import com.manageschool.manageschool.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectorMenuItem().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case ADD_STUDENT -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAddStudentView());
                case CREATE_COURSE -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateCourseView());
                case CREATE_REPORT -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateReportView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        }));
    }
}
