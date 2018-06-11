package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Commentscontroller extends AnchorPane {


    @FXML
    private TextArea comments_mainposttextarea;
    @FXML
    private TextArea comments_commenttextfield;
    @FXML
    private VBox comments_vbox;

    public TextArea getComments_commenttextfield() {
        return comments_commenttextfield;
    }

    public TextArea getComments_mainposttextarea() {
        return comments_mainposttextarea;
    }

    public Commentscontroller() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("comments.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void comment(ActionEvent event){
        String comment = comments_commenttextfield.getText();
        Singlecommentcontroller singlecommentcontroller = new Singlecommentcontroller();
        singlecommentcontroller.getSinglecomment_label().setText(comment);
        comments_vbox.getChildren().add(singlecommentcontroller);
    }








}
