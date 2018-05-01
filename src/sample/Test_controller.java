package sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Test_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane anc,main_anc;

    @FXML
    private MediaView mediaview;

    @FXML
    private Label status_label;

    @FXML
    private Button b1,b;
    MediaPlayer mediaPlayer;
    Media media;

    @FXML
    void initialize() {
        File file = new File("src/sample/media/video.mp4"); //!!!!!!!!!!!!!!!!
        String sourse = "sample/media/video.mp4";
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(false);

        mediaview.setMediaPlayer(mediaPlayer);
        b1.setOnAction(event -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
                mediaPlayer.stop();
        });
        b.setOnAction(event -> {
            if ((mediaPlayer.getStatus() == MediaPlayer.Status.STOPPED) || (mediaPlayer.getStatus() == MediaPlayer.Status.READY))
                mediaPlayer.play();
        });

    }
}
