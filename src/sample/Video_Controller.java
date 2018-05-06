package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Video_Controller {

    @FXML
    private Label stl1;

    @FXML
    private AnchorPane anc;

    @FXML
    private Slider slider;

    @FXML
    private Button tb1;

    @FXML
    private Button tb2;

    @FXML
    private MediaView mv;

    @FXML
    private Label stl;

    @FXML
    private Button tb;

    String sourse, status;
    Media media;
    MediaPlayer mediaPlayer;
    Duration duration;
    double d,w,h;
    Temp temp = new Temp();

    @FXML
    void initialize() {
        System.out.println(temp.getStr());

        File file = new File(temp.str);

        status = file.toURI().toString();

        media = new Media(status);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.getCurrentTime();
        mediaPlayer.setAutoPlay(false);
        w = mediaPlayer.getMedia().getWidth();
        h = mediaPlayer.getMedia().getHeight();

        mv.setMediaPlayer(mediaPlayer);

        anc.heightProperty().addListener((observable, oldValue, newValue) -> {
            mv.setFitHeight(newValue.doubleValue());
        });

        anc.widthProperty().addListener((observable, oldValue, newValue) -> {
            mv.setFitWidth(newValue.doubleValue());
        });

        mediaPlayer.setOnReady(() -> {
            duration = mediaPlayer.getMedia().getDuration();
            System.out.println(duration.toMinutes());
            slider.setMin(0);
            slider.setMax(mediaPlayer.getTotalDuration().toMinutes());
            slider.setShowTickMarks(false);
            slider.setShowTickLabels(false);
            stl.setText(status);
            mv.setPreserveRatio(true);
            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                slider.setValue(newValue.toMinutes());
                d = mediaPlayer.getTotalDuration().toMinutes()-newValue.toMinutes();
                stl1.setText(String.format("%(.2f",d));
            });

            slider.setOnMouseClicked(event -> {
                mediaPlayer.seek(Duration.minutes(slider.getValue()));
            });

        });

        //Кнопка PLAY
        tb.setOnAction(event -> {
            mediaPlayer.play();
        });

        //Кнопка PAUSE
        tb2.setOnAction(event -> {
            mediaPlayer.pause();
        });

        //Кнопка STOP
        tb1.setOnAction(event -> {
            mediaPlayer.stop();
        });

        Stage stage = (Stage) anc.getScene().getWindow();
        stage.setOnCloseRequest(event -> {
            mediaPlayer.stop();
        });
    }
}
