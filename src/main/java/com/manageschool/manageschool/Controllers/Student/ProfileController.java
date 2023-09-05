package com.manageschool.manageschool.Controllers.Student;

import com.manageschool.manageschool.Models.Courses;
import com.manageschool.manageschool.Models.GetCourses;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    public TableView<Courses> profile_courses_table;
    public TableColumn<Courses, Integer> profile_counter_col;
    public TableColumn<Courses, String> profile_course_title_col;
    public TableColumn<Courses, String> profile_course_code_col;
    public TableColumn<Courses, Integer> profile_credit_col;
    public TableColumn<Courses, Integer> profile_ects_col;
    public Text student_name;
    public Text student_id;
    public Text student_status;

    private static ProfileController instance;

    public ProfileController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;

        profile_counter_col.setCellValueFactory(new PropertyValueFactory<>("CourseCounter"));
        profile_course_title_col.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        profile_course_code_col.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        profile_credit_col.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
        profile_ects_col.setCellValueFactory(new PropertyValueFactory<>("Ects"));
        profile_courses_table.setItems(observableUserTakingCourseList);
    }

    public void setStudentInfo(String name, String id, String status) {
        student_name.setText(name);
        student_id.setText(id);
        student_status.setText(status);
    }

    public static ProfileController getInstance() {
        return instance;
    }

    GetCourses getCourses = new GetCourses();
    ObservableList<Courses> observableUserTakingCourseList = getCourses.populateWithUsersCourses();
}
