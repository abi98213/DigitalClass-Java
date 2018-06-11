package sample;

import com.mongodb.BasicDBObject;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.*;
import javafx.scene.shape.Circle;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController extends AnchorPane {


    @FXML
    private AnchorPane mainwindow_root;
    @FXML
    private AnchorPane newsfeed_root;
    @FXML
    private Label mainwindow_activitylabel;
    @FXML
    private ImageView mainwindow_refreshbutton;
    @FXML
    private ImageView notification_image;
    @FXML
    private Label notification_counter;


    public Label getMainwindow_activitylabel() {
        return mainwindow_activitylabel;
    }

    public ImageView getNotification_image() {
        return notification_image;
    }

    public Label getNotification_counter() {
        return notification_counter;
    }

    private String profileEmail;
    private String profilePassword;
    private String profileCmsid;
    private String profileName;
    private String profileStatus;
    private ArrayList<String[]> classmates_arraylist;
    private Label classmate_name;
    private Label classmate_email;
    private Label classmate_status;
    private String classmateavailabilty_status;
    private ArrayList<String[]> allposts;
    private String[] my_arraylist;

    public void setAllposts(ArrayList<String[]> allposts) {
        this.allposts = allposts;
    }

    public ArrayList<String[]> getAllposts() {

        return allposts;
    }

    public AnchorPane getNewsfeed_root() {
        return newsfeed_root;
    }

    public void setClassmateavailabilty_status(String classmateavailabilty_status) {
        this.classmateavailabilty_status = classmateavailabilty_status;
    }

    public String getClassmateavailabilty_status() {

        return classmateavailabilty_status;
    }

    public void setClassmates_arraylist(ArrayList<String[]> classmates_arraylist) {
        this.classmates_arraylist = classmates_arraylist;
    }

    public ArrayList<String[]> getClassmates_arraylist() {

        return classmates_arraylist;
    }

    public String getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
    }

    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

    public void setProfileCmsid(String profileCmsid) {
        this.profileCmsid = profileCmsid;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileEmail() {

        return profileEmail;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public String getProfileCmsid() {
        return profileCmsid;
    }

    public String getProfileName() {
        return profileName;
    }

    public MainWindowController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closemainwindowpage(ActionEvent event)throws Exception{
        MongoDB user = new MongoDB();
        user.logout(user.getUser_profile_data()[0],"false");


        System.exit(0);
    }

    public void logout(ActionEvent event) throws Exception{
        MongoDB user = new MongoDB();
        user.logout(user.getUser_profile_data()[0],"false");
        AnchorPane pane = new LoginController();
        mainwindow_root.getChildren().setAll(pane);
    }

    public void goToProfilepage(ActionEvent event) throws Exception{
        MongoDB user = new MongoDB();
        MyProfileController myProfileController = new MyProfileController();
        mainwindow_activitylabel.setText("My Profile");
        AnchorPane pane = myProfileController;
        newsfeed_root.getChildren().setAll(pane);
        myProfileController.getName_label().setText(user.getUser_profile_data()[0].substring(0, 1).toUpperCase()+user.getUser_profile_data()[0].substring(1));
        myProfileController.getProfile_emailtextfield().setText(user.getUser_profile_data()[1]);
        myProfileController.getProfile_passfield().setText(user.getUser_profile_data()[2]);
        myProfileController.getProfile_nametextfield().setText(user.getUser_profile_data()[0].substring(0, 1).toUpperCase()+user.getUser_profile_data()[0].substring(1));
        myProfileController.getProfile_cmstextfield().setText(user.getUser_profile_data()[3]);
        myProfileController.getMyprofile_statustextarea().setText(user.getUser_profile_data()[4]);
        user.user_profile_data = user.my_profile(user.getUser_profile_data()[1]);
        if(user.getUser_profile_data()[6].equals("true")){
            notification_image.setVisible(true);
            notification_counter.setVisible(true);
            notification_counter.setText(user.getUser_profile_data()[7]);
        }

    }

    public void gotomyclassmatespage(ActionEvent event) throws Exception{
        Classmatescontroller classmatescontroller = new Classmatescontroller();
        mainwindow_activitylabel.setText("My Classmates");
        AnchorPane pane = classmatescontroller;
        newsfeed_root.getChildren().setAll(pane);
        MongoDB user = new MongoDB();
        user.Class_Mates();


        for(String[] i:user.getMongoarraylist()) {
            ClassmatesshowcaseController classmatesshowcaseController = new ClassmatesshowcaseController();
            classmatesshowcaseController.getClassmateshow_namelabel().setText(i[0].substring(0,1)+i[0].substring(1));
            classmatesshowcaseController.getClassmateshow_emaillabel().setText(i[1]);
            classmatesshowcaseController.getClassmateshowcase_textarea().setText(i[2]);
            classmatesshowcaseController.getClassmateshowcase_textarea().setEditable(false);
            if (i[3].equals("true")) {
                Image image = new Image("/sample/Image/bitmap2.png");
                classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);
            } else {
                Image image = new Image("/sample/Image/bitmap3.png");
                classmatesshowcaseController.getClassmateshow_onlineimage().setImage(image);

            }
            classmatescontroller.getClassmates_vbox().getChildren().add(classmatesshowcaseController);
            user.user_profile_data = user.my_profile(user.getUser_profile_data()[1]);
            if(user.getUser_profile_data()[6].equals("true")){
                notification_image.setVisible(true);
                notification_counter.setVisible(true);
                notification_counter.setText(user.getUser_profile_data()[7]);
            }


        }
        }
    public void gotonewpostpage(ActionEvent event)throws Exception{
        MongoDB user = new MongoDB();
        mainwindow_activitylabel.setText("Create Post");

        NewPostController newPostController = new NewPostController();
        AnchorPane pane = newPostController;
        newsfeed_root.getChildren().setAll(pane);
        user.user_profile_data = user.my_profile(user.getUser_profile_data()[1]);
        if(user.getUser_profile_data()[6].equals("true")){
            notification_image.setVisible(true);
            notification_counter.setVisible(true);
            notification_counter.setText(user.getUser_profile_data()[7]);
        }
    }

    public void gotonewsfeedpage(ActionEvent event) throws Exception{
        mainwindow_activitylabel.setText("News Feed");
        MongoDB user = new MongoDB();
        user.PostShow();
        NewsFeedsController newsFeedsController = new NewsFeedsController();
        for(String[] i:user.getMongoarraypostlist()){
            Showsinglepostcontroller showsinglepostcontroller = new Showsinglepostcontroller();
            showsinglepostcontroller.setAccessibleText(i[0]);
            showsinglepostcontroller.getShowsinglepost_namelabel().setText(i[0].substring(0, 1).toUpperCase()+i[0].substring(1));
            showsinglepostcontroller.getShowsinglepost_datelabel().setText(i[1]);
            showsinglepostcontroller.getshowsinglepost_titlelabel().setText(i[2]);
            showsinglepostcontroller.getShowsinglepost_posttextarea().setText(i[3]);
            showsinglepostcontroller.getShowsinglepost_likebutton().addEventFilter(MouseEvent.MOUSE_CLICKED,event1 -> {
                showsinglepostcontroller.getShowsinglepost_likecounter().setText("1");
                Image image = new Image("/sample/Image/done.png");
                showsinglepostcontroller.getShowsinglepost_likebutton().setImage(image);
            });
            showsinglepostcontroller.getShowsinglepost_commentbutton().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Commentscontroller commentscontroller = new Commentscontroller();
                commentscontroller.getComments_mainposttextarea().setText(i[3]);
                AnchorPane pane = commentscontroller;
                newsfeed_root.getChildren().setAll(pane);
            });
            showsinglepostcontroller.getShowsinglepost_namelabel().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Classmatescontroller classmatescontroller = new Classmatescontroller();
                mainwindow_activitylabel.setText("My Classmates");
                AnchorPane pane = classmatescontroller;
                newsfeed_root.getChildren().setAll(pane);
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
        newsfeed_root.getChildren().setAll(pane);
        BasicDBObject newDocument = new BasicDBObject();
        BasicDBObject newDocument1 = new BasicDBObject();

        newDocument.append("$set", new BasicDBObject().append("Notification", "false"));
        newDocument1.append("$set", new BasicDBObject().append("No_of_Notifications","0"));
        user.coll.update(new BasicDBObject().append("Cms",user.getUser_profile_data()[3]), newDocument);
        user.coll.update(new BasicDBObject().append("Cms",user.getUser_profile_data()[3]), newDocument1);
        notification_image.setVisible(false);
        notification_counter.setVisible(false);
    }

    public void gotonewsfeedpage1(MouseEvent event) throws Exception{
        mainwindow_activitylabel.setText("News Feed");
        MongoDB user = new MongoDB();
        user.PostShow();
        NewsFeedsController newsFeedsController = new NewsFeedsController();
        for(String[] i:user.getMongoarraypostlist()){
            Showsinglepostcontroller showsinglepostcontroller = new Showsinglepostcontroller();
            showsinglepostcontroller.setAccessibleText(i[0]);
            showsinglepostcontroller.getShowsinglepost_namelabel().setText(i[0].substring(0, 1).toUpperCase()+i[0].substring(1));
            showsinglepostcontroller.getShowsinglepost_datelabel().setText(i[1]);
            showsinglepostcontroller.getshowsinglepost_titlelabel().setText(i[2]);
            showsinglepostcontroller.getShowsinglepost_posttextarea().setText(i[3]);
            showsinglepostcontroller.getShowsinglepost_likebutton().addEventFilter(MouseEvent.MOUSE_CLICKED,event1 -> {
                showsinglepostcontroller.getShowsinglepost_likecounter().setText("1");
                Image image = new Image("/sample/Image/done.png");
                showsinglepostcontroller.getShowsinglepost_likebutton().setImage(image);
            });
            showsinglepostcontroller.getShowsinglepost_commentbutton().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Commentscontroller commentscontroller = new Commentscontroller();
                commentscontroller.getComments_mainposttextarea().setText(i[3]);
                AnchorPane pane = commentscontroller;
                newsfeed_root.getChildren().setAll(pane);
            });

            showsinglepostcontroller.getShowsinglepost_namelabel().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                Classmatescontroller classmatescontroller = new Classmatescontroller();
                mainwindow_activitylabel.setText("My Classmates");
                AnchorPane pane = classmatescontroller;
                newsfeed_root.getChildren().setAll(pane);
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
            showsinglepostcontroller.getShowsinglepost_commentbutton().addEventFilter(MouseEvent.MOUSE_CLICKED,event1 -> {
            });

            newsFeedsController.getNewsfeeds_vbox().getChildren().add(showsinglepostcontroller);
        }

        AnchorPane pane = newsFeedsController;
        newsfeed_root.getChildren().setAll(pane);
        BasicDBObject newDocument = new BasicDBObject();
        BasicDBObject newDocument1 = new BasicDBObject();

        newDocument.append("$set", new BasicDBObject().append("Notification", "false"));
        newDocument1.append("$set", new BasicDBObject().append("No_of_Notifications","0"));
        user.coll.update(new BasicDBObject().append("Cms",user.getUser_profile_data()[3]), newDocument);
        user.coll.update(new BasicDBObject().append("Cms",user.getUser_profile_data()[3]), newDocument1);
        notification_image.setVisible(false);
        notification_counter.setVisible(false);
    }
}
