package sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Test_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private MediaView mediaview;

    @FXML
    private Button b;


    @FXML
    void initialize() {

        b.setOnAction(event -> {
            File file = new File("src/sample/media/video.mp4"); //!!!!!!!!!!!!!!!!
            String sourse = "sample/media/video.mp4";
            Media media = new Media(file.toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
            mediaview.setMediaPlayer(mediaPlayer);

        });

    }
}
