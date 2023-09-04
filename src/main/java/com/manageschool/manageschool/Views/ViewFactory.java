package com.manageschool.manageschool.Views;

import com.manageschool.manageschool.Controllers.Admin.AdminController;
import com.manageschool.manageschool.Controllers.Student.StudentController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class ViewFactory {
    private AccountType loginAccountType;

    // Student View
    private final ObjectProperty<StudentMenuOptions> studentSelectorMenuItem;
    private AnchorPane coursesView;
    private AnchorPane reportCardView;
    private AnchorPane profileView;

    // Admin View
    private final ObjectProperty<AdminMenuOptions> adminSelectorMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane addStudentView;
    private AnchorPane createCourseView;
    private AnchorPane createReportView;


    // the constructor
    public ViewFactory(){
        this.loginAccountType = AccountType.STUDENT;
        this.studentSelectorMenuItem = new SimpleObjectProperty<>();
        this.adminSelectorMenuItem = new SimpleObjectProperty<>();
    }

    // Student View getters
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
    public AnchorPane getReportCardView(){
        if(reportCardView == null){
            try{
                reportCardView = new FXMLLoader(getClass().getResource("/Fxml/Student/ReportCard.fxml")).load();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return reportCardView;
    }
    public AnchorPane getProfileView(){
        if(profileView == null){
            try{
                profileView = new FXMLLoader(getClass().getResource("/Fxml/Student/Profile.fxml")).load();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return profileView;
    }


    // Admin View getters
    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Dashboard.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

   public AnchorPane getAddStudentView(){
        if(addStudentView == null){
            try{
                addStudentView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AddStudent.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return addStudentView;
    }
   public AnchorPane getCreateCourseView(){
        if(createCourseView == null){
            try{
                createCourseView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateCourse.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return createCourseView;
    }
   public AnchorPane getCreateReportView(){
        if(createReportView == null){
            try{
                createReportView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateReport.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return createReportView;
    }

    public AccountType getLoginAccountType() {return loginAccountType;}

    public void setLoginAccountType(AccountType loginAccountType){this.loginAccountType = loginAccountType;}

    // Object getters
    public ObjectProperty<StudentMenuOptions> getStudentSelectorMenuItem() {
        return studentSelectorMenuItem;
    }
    public ObjectProperty<AdminMenuOptions> getAdminSelectorMenuItem() {
        return adminSelectorMenuItem;
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }
    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminSideView.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
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

