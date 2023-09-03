package com.manageschool.manageschool.Controllers;

import com.manageschool.manageschool.Models.GetDataForLogin;
import com.manageschool.manageschool.Models.Model;
import com.manageschool.manageschool.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label username_lbl;
    public TextField username_field;
    public Label user_password;
    public TextField user_password_field;
    public Button login_btn;
    public Label error_lbl;
    public Button close_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.ADMIN, AccountType.STUDENT));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        login_btn.setOnAction(event -> {
            try {
                if (username_field.getText().isBlank() || user_password_field.getText().isBlank()){
                    error_lbl.setText("Maybe try inserting username and password :)");
                }else{ onLogin(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void onLogin() throws SQLException {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);

        String user = username_field.getText();
        String psw = user_password_field.getText();

        GetDataForLogin getData = new GetDataForLogin();

        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADMIN && getData.getVerified(user,psw,"admin")){
            Model.getInstance().getViewFactory().showAdminWindow();
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.STUDENT && getData.getVerified(user,psw,"student")) {
            Model.getInstance().getViewFactory().showStudentWindow();
        } else {
            Model.getInstance().getViewFactory().showStudentWindow();
//            System.out.println("not working!");
        }
    }


    public void closeLoginStage() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}


