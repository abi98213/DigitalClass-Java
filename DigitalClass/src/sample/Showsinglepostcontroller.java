package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class Showsinglepostcontroller extends AnchorPane {


    @FXML
    private Label showsinglepost_namelabel;
    @FXML
    private Label showsinglepost_datelabel;
    @FXML
    private Label showsinglepost_titlelabel;
    @FXML
    private TextArea showsinglepost_posttextarea;
    @FXML
    private AnchorPane showsinglepost_root;
    @FXML
    private ImageView showsinglepost_likebutton;
    @FXML
    private Label showsinglepost_likecounter;
    @FXML
    private ImageView showsinglepost_commentbutton;

    public ImageView getShowsinglepost_commentbutton() {
        return showsinglepost_commentbutton;
    }

    public Label getShowsinglepost_likecounter() {
        return showsinglepost_likecounter;
    }

    public ImageView getShowsinglepost_likebutton() {
        return showsinglepost_likebutton;
    }

    public void setShowsinglepost_posttextarea(TextArea showsinglepost_posttextarea) {
        this.showsinglepost_posttextarea = showsinglepost_posttextarea;
    }

    public TextArea getShowsinglepost_posttextarea() {

        return showsinglepost_posttextarea;
    }

    public void setShowsinglepost_namelabel(Label showsinglepost_namelabel) {
        this.showsinglepost_namelabel = showsinglepost_namelabel;
    }

    public void setShowsinglepost_datelabel(Label showsinglepost_datelabel) {
        this.showsinglepost_datelabel = showsinglepost_datelabel;
    }

    public void showsinglepost_titlelabel(Label showsinglepost_titlelabel) {
        this.showsinglepost_titlelabel = showsinglepost_titlelabel;
    }

    public Label getShowsinglepost_namelabel() {

        return showsinglepost_namelabel;
    }

    public Label getShowsinglepost_datelabel() {
        return showsinglepost_datelabel;
    }

    public Label getshowsinglepost_titlelabel() {
        return showsinglepost_titlelabel;
    }

    public Showsinglepostcontroller() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showsinglepost.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void gotoclassmatpage(MouseEvent event) throws Exception{
//        NewsFeedsController newsFeedsController = new NewsFeedsController();
//        MainWindowController mainWindowController = new MainWindowController();
//        showsinglepost_root = mainWindowController.getNewsfeed_root();
//        Classmatescontroller classmatescontroller = new Classmatescontroller();
////        mainwindow_activitylabel.setText("My Classmates");
//        AnchorPane pane = classmatescontroller;
//        showsinglepost_root.getChildren().setAll(pane);
//        MongoDB user = new MongoDB();
//        user.Class_Mates();
//
//
//        for(String[] i:user.getMongoarraylist()) {
//            ClassmatesshowcaseController classmatesshowcaseController = new ClassmatesshowcaseController();
//            classmatesshowcaseController.getClassmateshow_namelabel().setText(i[0]);
//            classmatesshowcaseController.getClassmateshow_emaillabel().setText(i[1]);
//            classmatesshowcaseController.getClassmateshowcase_textarea().setText(i[2]);
//            classmatesshowcaseController.getClassmateshowcase_textarea().setEditable(false);
//            if (i[3].equals("true")) {
//                Image image = new Image("/sample/Image/bitmap2.png");
//                classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);
//            } else {
//                Image image = new Image("/sample/Image/bitmap3.png");
//                classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);
//
//            }
//            classmatescontroller.getClassmates_vbox().getChildren().add(classmatesshowcaseController);
//
//
//        }

    }






