package sample;

import com.mongodb.BasicDBObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewPostController extends AnchorPane {

    private String n;

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @FXML
    private TextArea newpost_posttextarea;
    @FXML
    private TextArea newpost_titletextfield;
    @FXML
    private AnchorPane newpost_root;

    @FXML
    public void newpost(ActionEvent event)throws Exception{

        String title = newpost_titletextfield.getText();
        String post = newpost_posttextarea.getText();
        MongoDB user = new MongoDB();
        user.post(user.getUser_profile_data()[0],title,post);
        user.PostShow();
        NewsFeedsController newsFeedsController = new NewsFeedsController();
        MainWindowController mainWindowController = new MainWindowController();


        for(String[] i:user.getMongoarraypostlist()){
            Showsinglepostcontroller showsinglepostcontroller = new Showsinglepostcontroller();

            showsinglepostcontroller.getShowsinglepost_namelabel().setText(i[0].substring(0, 1).toUpperCase()+i[0].substring(1));
            showsinglepostcontroller.getShowsinglepost_datelabel().setText(i[1]);
            showsinglepostcontroller.getshowsinglepost_titlelabel().setText(i[2]);
            showsinglepostcontroller.getShowsinglepost_posttextarea().setText(i[3]);
            showsinglepostcontroller.getShowsinglepost_likebutton().addEventFilter(MouseEvent.MOUSE_CLICKED, event1 -> {
                showsinglepostcontroller.getShowsinglepost_likecounter().setText("1");
                Image image = new Image("/sample/Image/done.png");
                showsinglepostcontroller.getShowsinglepost_likebutton().setImage(image);
            });
            showsinglepostcontroller.getShowsinglepost_commentbutton().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Commentscontroller commentscontroller = new Commentscontroller();
                commentscontroller.getComments_mainposttextarea().setText(i[3]);
                AnchorPane pane = commentscontroller;
                newpost_root.getChildren().setAll(pane);
            });

            showsinglepostcontroller.getShowsinglepost_namelabel().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Classmatescontroller classmatescontroller = new Classmatescontroller();
                mainWindowController.getMainwindow_activitylabel().setText("My Classmates");
                AnchorPane pane = classmatescontroller;
                newpost_root.getChildren().setAll(pane);
                user.Class_Mates();
                for(String[] j:user.getMongoarraylist()) {
                    ClassmatesshowcaseController classmatesshowcaseController = new ClassmatesshowcaseController();
                    classmatesshowcaseController.getClassmateshow_namelabel().setText(j[0].substring(0,1)+j[0].substring(1));
                    classmatesshowcaseController.getClassmateshow_emaillabel().setText(j[1]);
                    classmatesshowcaseController.getClassmateshowcase_textarea().setText(j[2]);
                    classmatesshowcaseController.getClassmateshowcase_textarea().setEditable(false);
                    if (j[3].equals("true")) {
                        Image image = new Image("/sample/Image/bitmap2.png");
                        classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);
                    } else {
                        Image image = new Image("/sample/Image/bitmap3.png");
                        classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);
                    }
                    classmatescontroller.getClassmates_vbox().getChildren().add(classmatesshowcaseController);
                }

            });


            newsFeedsController.getNewsfeeds_vbox().getChildren().add(showsinglepostcontroller);
        }
        AnchorPane pane = newsFeedsController;
        newpost_root.getChildren().setAll(pane);
        user.users();

        for(String[] i: user.all_users){
            if(i[0] != user.getUser_profile_data()[3]){
                int a = Integer.parseInt(i[1]);
                a += 1;

                BasicDBObject newDocument = new BasicDBObject();
                BasicDBObject newDocument1 = new BasicDBObject();
                newDocument.append("$set", new BasicDBObject().append("Notification", "true"));
                newDocument1.append("$set", new BasicDBObject().append("No_of_Notifications",Integer.toString(a)));
                user.coll.update(new BasicDBObject().append("Cms",i[0]), newDocument);
                user.coll.update(new BasicDBObject().append("Cms",i[0]), newDocument1);
            }

        }
        user.users();




    }






    public NewPostController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewPost.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
