package com.manageschool.manageschool.Controllers.Student;

import com.manageschool.manageschool.Models.Courses;
import com.manageschool.manageschool.Models.GetCourses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {
    public Text user_name;
    public Button enroll_btn;
    public TextField to_enroll_filed;

    public TableView<Courses> courses_table;

    public TableColumn<Courses, Integer> course_counter_col;
    public TableColumn<Courses, String> course_title_col;
    public TableColumn<Courses, String> course_code_col;
    public TableColumn<Courses, Integer> course_cr_col;
    public TableColumn<Courses, Integer> course_ects_col;

    public CoursesController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        course_counter_col.setCellValueFactory(new PropertyValueFactory<>("CourseCounter"));
        course_title_col.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        course_code_col.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        course_cr_col.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
        course_ects_col.setCellValueFactory(new PropertyValueFactory<>("Ects"));
        courses_table.setItems(observableList);
    }

    GetCourses getCourses = new GetCourses();
    ObservableList<Courses> observableList = getCourses.populate();

}
