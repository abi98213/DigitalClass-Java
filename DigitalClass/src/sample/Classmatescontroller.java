package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Classmatescontroller extends AnchorPane {

    @FXML
    private AnchorPane classmates_root;
    @FXML
    private VBox classmates_vbox;
    @FXML
    private ScrollPane classmates_scrollpane;

    public void setClassmates_root(AnchorPane classmates_root) {
        this.classmates_root = classmates_root;
    }

    public void setClassmates_vbox(VBox classmates_vbox) {
        this.classmates_vbox = classmates_vbox;
    }

    public void setClassmates_scrollpane(ScrollPane classmates_scrollpane) {
        this.classmates_scrollpane = classmates_scrollpane;
    }

    public AnchorPane getClassmates_root() {

        return classmates_root;
    }

    public VBox getClassmates_vbox() {
        return classmates_vbox;
    }

    public ScrollPane getClassmates_scrollpane() {
        return classmates_scrollpane;
    }

    public Classmatescontroller() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Classmates.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
