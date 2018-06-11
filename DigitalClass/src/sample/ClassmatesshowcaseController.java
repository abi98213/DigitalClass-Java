package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ClassmatesshowcaseController extends AnchorPane{

    @FXML
    private HBox classmatesshow_hbox;
    @FXML
    private AnchorPane classmatesshow_root;
    @FXML
    private TextArea classmateshowcase_textarea;
    @FXML
    private Label classmateshow_namelabel;
    @FXML
    public ImageView classmateshow_onlineimage;
    @FXML

    private Label classmateshow_emaillabel;



    public void setClassmateshow_onlineimage(ImageView classmateshow_onlineimage) {
        this.classmateshow_onlineimage = classmateshow_onlineimage;
    }

    private String avail;

    public ImageView getClassmateshow_onlineimage() {
        return classmateshow_onlineimage;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getAvail() {

        return avail;
    }



    public void setClassmateshow_namelabel(Label classmateshow_namelabel) {
        this.classmateshow_namelabel = classmateshow_namelabel;
    }

    public void setClassmateshow_emaillabel(Label classmateshow_emaillabel) {
        this.classmateshow_emaillabel = classmateshow_emaillabel;
    }

    public Label getClassmateshow_namelabel() {

        return classmateshow_namelabel;
    }

    public Label getClassmateshow_emaillabel() {
        return classmateshow_emaillabel;
    }

    public void setClassmateshowcase_textarea(TextArea classmateshowcase_textarea) {
        this.classmateshowcase_textarea = classmateshowcase_textarea;
    }

    public TextArea getClassmateshowcase_textarea() {

        return classmateshowcase_textarea;
    }

    public void setClassmatesshow_hbox(HBox classmatesshow_hbox) {
        this.classmatesshow_hbox = classmatesshow_hbox;
    }

    public void setClassmatesshow_root(AnchorPane classmatesshow_root) {
        this.classmatesshow_root = classmatesshow_root;
    }

    public HBox getClassmatesshow_hbox() {

        return classmatesshow_hbox;
    }

    public AnchorPane getClassmatesshow_root() {
        return classmatesshow_root;
    }

    public ClassmatesshowcaseController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Classmateshowcase.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
