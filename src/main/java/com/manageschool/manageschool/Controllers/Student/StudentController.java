package com.manageschool.manageschool.Controllers.Student;

import com.manageschool.manageschool.Models.Model;
import eu.hansolo.tilesfx.addons.Switch;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public BorderPane student_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getStudentSelectorMenuItem().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case REPORT_CARD -> student_parent.setCenter(Model.getInstance().getViewFactory().getReportCardView());
                case PROFILE -> student_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                default -> student_parent.setCenter(Model.getInstance().getViewFactory().getCoursesView());
            }
        }));

    }
}
