package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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

    @FXML
    void initialize() {
        sourse = "file:/C:/Users/SxN/IdeaProjects/untitled/src/sample/video.mp4";
        File file = new File("src/sample/video.mp4");
        status = file.toURI().toString();
        System.out.println(sourse + "\n" + status);

        media = new Media(sourse);
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

            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                slider.setValue(newValue.toMinutes());
                d = mediaPlayer.getTotalDuration().toMinutes()-newValue.toMinutes();
                stl1.setText(String.format("%(.2f",d));
            });

            slider.setOnMouseClicked(event -> {
                mediaPlayer.seek(Duration.minutes(slider.getValue()));
            });

        });

        if (status.equals(sourse))
            System.out.println("equals");
        else
            System.out.println("NO");

        tb.setOnAction(event -> {
            mediaPlayer.play();
        });

        tb2.setOnAction(event -> {
            mediaPlayer.pause();
        });
        tb1.setOnAction(event -> {
            mediaPlayer.stop();
        });
    }
}
