package com.manageschool.manageschool.Controllers.Admin;

import com.manageschool.manageschool.Models.Courses;
import com.manageschool.manageschool.Models.GetStudents;
import com.manageschool.manageschool.Models.Students;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {
    public TextField first_name_filed;
    public TextField last_name_field;
    public TextField id_filed;
    public CheckBox show_username;
    public Label user_name_view;
    public CheckBox student_status;
    public Button add_student_btn;
    public Label error_lbl;
    public Label login_date;
    public TableView<Students> student_table;
    public TableColumn<Students, Integer> student_counter_col;
    public TableColumn<Students, String> student_name_col;
    public TableColumn<Students, String> student_id_col;
    public TableColumn<Students, String> student_username_col;
    public TableColumn<Students, String> student_status_col;
    public TableColumn<Students, String> student_gender_col;

    public AddStudentController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        student_counter_col.setCellValueFactory(new PropertyValueFactory<>("StudentCounter"));
        student_name_col.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        student_id_col.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        student_username_col.setCellValueFactory(new PropertyValueFactory<>("StudentUsername"));
        student_status_col.setCellValueFactory(new PropertyValueFactory<>("StudentStatus"));
        student_gender_col.setCellValueFactory(new PropertyValueFactory<>("StudentGender"));
        student_table.setItems(observableList);
    }

    GetStudents getStudents = new GetStudents();
    ObservableList<Students> observableList = getStudents.populateStudents();


}
