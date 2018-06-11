package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends AnchorPane {


    @FXML
    private TextField login_email_textfield;
    @FXML
    private AnchorPane loginpage_root;
    @FXML
    private TextField login_password_textfield;
    @FXML
    private Label loginpage_loginlabel;
    @FXML
    private Label loginpage_signuplabel;
    @FXML
    private Label loginpage_closelabel;
    @FXML
    private Label loginpage_loginstatus;
    @FXML
    private Label loginpage_regstatus;
    @FXML
    private javafx.scene.image.ImageView loginpage_gif;



    private String name;
    private String cmsid;
    private String availabilty;

    public void setAvailabilty(String availabilty) {
        this.availabilty = availabilty;
    }

    public String getAvailabilty() {

        return availabilty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCmsid(String cmsid) {
        this.cmsid = cmsid;
    }

    public String getName() {
        return name;
    }

    public String getCmsid() {
        return cmsid;
    }

    public Label getLoginpage_regstatus() {
        return loginpage_regstatus;
    }

    public TextField getLogin_email_textfield() {
        return login_email_textfield;
    }

    public LoginController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Loginpage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeloginpage(MouseEvent event)throws Exception{
        System.exit(0);
    }

    public void goToSignuppage(MouseEvent event) throws Exception{
        AnchorPane pane = new RegisterController();
        loginpage_root.getChildren().setAll(pane);
    }

    public void goToForgotPasswordpage(MouseEvent event) throws Exception{
        AnchorPane pane = new ForgotPasswordController();
        loginpage_root.getChildren().setAll(pane);

    }

    public void login(ActionEvent event)throws Exception{
        String email = login_email_textfield.getText();
        String password = login_password_textfield.getText();
        MyProfileController myProfileController = new MyProfileController();
        MongoDB user = new MongoDB();
        if (email.length() != 0 && password.length() != 0){
            if(user.Login_User(email,password)) {
                MainWindowController mainWindowController = new MainWindowController();
                AnchorPane pane = mainWindowController;
                loginpage_root.getChildren().setAll(pane);
                mainWindowController.setProfileName(user.getUser_profile_data()[0]);
                if(user.getUser_profile_data()[6].equals("true")){
                    mainWindowController.getNotification_image().setVisible(true);
                    mainWindowController.getNotification_counter().setVisible(true);
                    mainWindowController.getNotification_counter().setText(user.getUser_profile_data()[7]);
                }
            }else {
                loginpage_loginstatus.setText("Invalid Credentials");
                loginpage_loginstatus.setTextFill(Color.web("#DD0006"));
            }
        }else{
            loginpage_loginstatus.setText("Fields can not be Empty");
            loginpage_loginstatus.setTextFill(Color.web("#FA0700"));
        }
    }



}
