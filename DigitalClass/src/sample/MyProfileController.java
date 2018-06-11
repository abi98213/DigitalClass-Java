package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyProfileController extends AnchorPane implements Initializable {

    @FXML
    private TextField profile_nametextfield;
    @FXML
    private TextField profile_cmstextfield;
    @FXML
    private TextField profile_emailtextfield;
    @FXML
    private PasswordField profile_passfield;
    @FXML
    public Label profile_label;
    @FXML
    private TextArea myprofile_statustextarea;
    @FXML
    private TextArea myprofile_updatestatustextfield;
    @FXML
    private ImageView myprofile_imageview;
    @FXML
    private Label name_label;

    public Label getName_label() {
        return name_label;
    }

    public ImageView getMyprofile_imageview() {
        return myprofile_imageview;
    }

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initialize(){

    }

    public MyProfileController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyProfile.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextArea getMyprofile_statustextarea() {
        return myprofile_statustextarea;
    }

    public void setMyprofile_statustextarea(TextArea myprofile_statustextarea) {
        this.myprofile_statustextarea = myprofile_statustextarea;
    }

    public TextField getProfile_nametextfield() {
        return profile_nametextfield;
    }

    public TextField getProfile_cmstextfield() {
        return profile_cmstextfield;
    }

    public Label getProfile_label() {
        return profile_label;
    }

    public TextField getProfile_emailtextfield() {
        return profile_emailtextfield;
    }

    public PasswordField getProfile_passfield() {
        return profile_passfield;
    }


    public void updatestatus(ActionEvent event)throws Exception{
        myprofile_statustextarea.setEditable(true);
        String status = myprofile_updatestatustextfield.getText();
        myprofile_statustextarea.setText(status);
        MongoDB user = new MongoDB();
        user.update_status(status,user.getUser_profile_data()[1]);
        myprofile_statustextarea.setEditable(false);
        user.PostShow();

    }





}
