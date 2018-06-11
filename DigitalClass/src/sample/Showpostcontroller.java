package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class Showpostcontroller extends AnchorPane {

    @FXML
    private javafx.scene.control.TextArea showpost_textarea;

    public void setShowpost_textarea(TextArea showpost_textarea) {
        this.showpost_textarea = showpost_textarea;
    }

    public TextArea getShowpost_textarea() {

        return showpost_textarea;
    }

    public Showpostcontroller() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showpost.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}
