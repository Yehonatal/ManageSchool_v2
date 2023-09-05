package com.manageschool.manageschool.Controllers.Admin;

import com.manageschool.manageschool.Models.GetStudents;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.manageschool.manageschool.Models.Students;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.manageschool.manageschool.Models.Courses;
import com.manageschool.manageschool.Models.GetCourses;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController implements Initializable {
    public Label login_date;
    public Label total_stu;
    public Label male_stu;
    public Label female_stu;
    public TableView<Courses> latest_courses_table;
    public TableColumn<Courses, Integer> course_counter_col;
    public TableColumn<Courses, String> course_title_col;
    public TableColumn<Courses, String> course_code_col;
    public TableColumn<Courses, Integer> course_cr_col;
    public TableColumn<Courses, Integer> course_ects_col;

    public TableView<Students> best_student_table;

    public TableColumn<Students, Integer> student_counter_col;
    public TableColumn<Students, String> student_id_col;
    public TableColumn<Students, String> student_name_col;
    public TableColumn<Students, String> student_course_col;

    public TableColumn<Students, String> student_grade_col;

    public DashboardController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        course_counter_col.setCellValueFactory(new PropertyValueFactory<>("CourseCounter"));
        course_title_col.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        course_code_col.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        course_cr_col.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
        course_ects_col.setCellValueFactory(new PropertyValueFactory<>("Ects"));
        latest_courses_table.setItems(observableTopFiveCourseList);

        student_counter_col.setCellValueFactory(new PropertyValueFactory<>("StudentCounter"));
        student_id_col.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        student_name_col.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        student_course_col.setCellValueFactory(new PropertyValueFactory<>("studentCourseCode"));
        student_grade_col.setCellValueFactory(new PropertyValueFactory<>("StudentGrade"));
        best_student_table.setItems(observableTopFiveStudentList);
    }

    GetCourses getCourses = new GetCourses();
    GetStudents getStudents = new GetStudents();
    ObservableList<Courses> observableTopFiveCourseList = getCourses.populateTopFiveCourse();
    ObservableList<Students> observableTopFiveStudentList = getStudents.populateTopFiveStudents();

}
