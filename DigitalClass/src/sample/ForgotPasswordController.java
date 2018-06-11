package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.Label;
import java.io.IOException;

public class ForgotPasswordController extends AnchorPane {

    @FXML
    private javafx.scene.control.Label forgotpass_loginlabel;
    @FXML
    private javafx.scene.control.Label forgotpass_signuplabel;
    @FXML
    private AnchorPane forgotpassword_root;
    @FXML
    private TextField forgotpassword_emailtextfield;
    @FXML
    private TextField forgotpassword_answertextfield;
    @FXML
    private javafx.scene.control.Label forgotpassword_errorstatus;
    @FXML
    private javafx.scene.control.Label forgotpassword_recovery;


    public ForgotPasswordController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ForgotPassword.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeforgotpasswordpage(MouseEvent event)throws Exception{
        System.exit(0);
    }

    public void goToLoginpage(MouseEvent event) throws Exception{
        AnchorPane pane = new LoginController();
        forgotpassword_root.getChildren().setAll(pane);
    }

    public void goToSignuppage(MouseEvent event) throws Exception{
        AnchorPane pane = new RegisterController();
        forgotpassword_root.getChildren().setAll(pane);
    }

    public void recover(ActionEvent event){

        String email = forgotpassword_emailtextfield.getText();
        String answer = forgotpassword_answertextfield.getText();

        MongoDB user = new MongoDB();
        if(email.length() != 0 && answer.length() != 0) {
            try {
                forgotpassword_recovery.setText(user.Change_Password(email, answer));
                } catch (Exception e) {
                forgotpassword_recovery.setText(user.Change_Password(email, answer));
                forgotpassword_recovery.setTextFill(Color.web("#DD0006"));

            }
        }else {
            forgotpassword_recovery.setText("Fields can not be Empty");
            forgotpassword_recovery.setTextFill(Color.web("#DD0006"));
        }


    }








}
