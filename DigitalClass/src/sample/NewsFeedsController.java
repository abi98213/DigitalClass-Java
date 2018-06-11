package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NewsFeedsController extends AnchorPane {

    @FXML
    private VBox newsfeeds_vbox;
    @FXML
    private AnchorPane newsfeeds_root2;

    public void setNewsfeeds_vbox(VBox newsfeeds_vbox) {
        this.newsfeeds_vbox = newsfeeds_vbox;
    }

    public void setNewsfeeds_root2(AnchorPane newsfeeds_root2) {
        this.newsfeeds_root2 = newsfeeds_root2;
    }

    public VBox getNewsfeeds_vbox() {

        return newsfeeds_vbox;
    }

    public AnchorPane getNewsfeeds_root2() {
        return newsfeeds_root2;
    }

    public NewsFeedsController() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewsFeeds.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
