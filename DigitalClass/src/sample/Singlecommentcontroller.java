package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Singlecommentcontroller extends AnchorPane{

    @FXML
    private Label singlecomment_label;

    public Label getSinglecomment_label() {
        return singlecomment_label;
    }

    public Singlecommentcontroller() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("singlecommentshowcase.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
