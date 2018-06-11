package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class RegisterController extends AnchorPane {
    @FXML
    private AnchorPane registerpage_root;
    @FXML
    private TextField registerpage_nametextfield;
    @FXML
    private TextField registerpage_cmsidtextfield;
    @FXML
    private TextField registerpage_emailtextfield;
    @FXML
    private TextField registerpage_passwordtextfield;
    @FXML
    private TextField registerpage_confirmpasswordtextfield;
    @FXML
    private TextField registerpage_securityQtextfield;
    @FXML
    private Label registerpage_regstatus;



    public RegisterController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeregisterpage(MouseEvent event)throws Exception{
        System.exit(0);
    }

    public void goToLoginpage(MouseEvent event) throws Exception{
        AnchorPane pane = new LoginController();
        registerpage_root.getChildren().setAll(pane);
    }

    public void register(ActionEvent event)throws Exception {
        try {
            String name = registerpage_nametextfield.getText();
            String cms = registerpage_cmsidtextfield.getText();
            String email = registerpage_emailtextfield.getText();
            String password = registerpage_passwordtextfield.getText();
            String passConfirm = registerpage_confirmpasswordtextfield.getText();
            String answer = registerpage_securityQtextfield.getText();
            if (name.length() != 0 && cms.length() != 0 && email.length() != 0 && password.length() != 0 && passConfirm.length() != 0 && answer.length() != 0) {
                if (password.equals(passConfirm)) {
                    MongoDB user = new MongoDB();
                    user.Register_User(name, email, password, cms, answer);
                    LoginController loginController = new LoginController();
                    AnchorPane pane = loginController;
                    registerpage_root.getChildren().setAll(pane);
                    loginController.getLoginpage_regstatus().setText("Registered Successfully");
                    loginController.getLoginpage_regstatus().setTextFill(Color.web("#37DD2E"));
                } else {
                    registerpage_regstatus.setText("Password mismatch");
                    registerpage_regstatus.setTextFill(Color.web("#DD0006"));
                }
            } else {
                registerpage_regstatus.setText("Fields can not be Empty");
                registerpage_regstatus.setTextFill(Color.web("#DD0006"));

            }

        } catch (Exception e) {
            registerpage_regstatus.setText("Email Or CMS already Exist");
            registerpage_regstatus.setTextFill(Color.web("#DD0006"));
        }
    }
}
