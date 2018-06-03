package sample;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label status_label, helper;

    @FXML
    private URL location;

    @FXML
    private ListView<Lection> listViever;

    @FXML
    private Button b_next;

    @FXML
    private Button b_prev;

    @FXML
    private Button b_exit;

    @FXML
    private AnchorPane anc;

    @FXML
    private ImageView imageViever;

    // Глобальные переменные
    int count = 1, id_lec = 999, p_counter = 0;
    String str = null;
    String full_path = null;
    Image image;
    String half_path = null;
    String types = null;
    private Temp t1 = new Temp();

    @FXML
    void initialize() {
        status_label.setText(null);
/***************************************************************************************************************/
        listViever.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Lection lection2 = new Lection(1, 14,"1. Классификация современных ПК","sample/assets/kp/", ".PNG");
        Lection lection3 = new Lection(2,26,"2. Архитектура системы команд","sample/assets/ask/", ".PNG");
        Lection lection4 = new Lection(3,17,"3. Устройства управления","sample/assets/uu/", ".PNG");
        Lection lection5 = new Lection(4,34,"4. Конвейерная обработка команд","sample/assets/kok/", ".PNG");
        Lection lection6 = new Lection(5,26,"5. Формат команд","sample/assets/fc/", ".PNG");
        Lection lection7 = new Lection(6,13,"6. Функциональная и структурная организация ЭВМ","sample/assets/fso/", ".PNG");
        Lection lection8 = new Lection(7,27,"7. Типы и форматы операндов","sample/assets/tfo/", ".PNG");
        Lection lection10 = new Lection(8,17,"8. КЭШ-память","sample/assets/cac/", ".PNG");
        Lection lection11 = new Lection(9,12,"9. Мультизадачность","sample/assets/mul/", ".PNG");
        Lection lection12 = new Lection(10,12,"10. Система памяти","sample/assets/sp/", ".PNG");
        Lection lection9 = new Lection(11,0,"11. (ВИДЕО) Введения в Quartus","src/sample/media/introductionQuartus.mp4", ".mp4");

        ObservableList<Lection> lections = FXCollections.observableArrayList(lection2,lection3,lection4,
                lection5,lection6,lection7,lection8,lection10, lection11, lection12, lection9);

        listViever.setItems(lections);

        /***************/
        listViever.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lection>() {
            @Override
            public void changed(ObservableValue<? extends Lection> observable, Lection oldValue, Lection newValue) {
                helper.setText("");
                status_label.setText("Нажмите Next");
                count = 1;
                id_lec = newValue.getId();

                if (id_lec == 11){
                    t1.setStr(newValue.getP());
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/video.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.setTitle("Video");
                    stage.showAndWait();
                }
                else {
                    str = newValue.getLec_name();
                    types = newValue.getTypeFile();
                    half_path = newValue.getP();
                    p_counter = newValue.getPage_count();

                    full_path = half_path + "Slide" + count + types;

                    image = new Image(full_path);
                    imageViever.setFitWidth(anc.getWidth());
                    imageViever.setImage(image);
                }
            }
        });

        anc.heightProperty().addListener((observable, oldValue, newValue) -> {
            imageViever.setFitHeight(newValue.doubleValue());
        });
        anc.widthProperty().addListener((observable, oldValue, newValue) -> {
            imageViever.setFitWidth(newValue.doubleValue());
        });
    //Кнопка вперёд
        b_next.setOnAction(event -> {
            helper.setText("");
            System.out.println(id_lec+"\n"+p_counter+"\n"+str+"\n"+half_path+"\n"+types);
        if(id_lec == 999)
            status_label.setText("Choose lection");

            if(count == p_counter)
                count = 1;
            else
                count++;

        full_path = half_path + "Slide" + count + types;

        System.out.println(full_path);
        System.out.println(count);
        image = new Image(full_path);
        imageViever.setFitWidth(anc.getWidth());
        imageViever.setImage(image);

        System.out.println("b_next is pressed");
        String s = ""; /*anc.getWidth() + " " + anc.getHeight()*/
            s = String.valueOf(count);

            status_label.setText(s);
        });

    //Кнопка назад
    b_prev.setOnAction(event -> {
        helper.setText("");
        System.out.println(id_lec+"\n"+p_counter+"\n"+str+"\n"+half_path+"\n"+types);
        if(id_lec == 999)
            status_label.setText("Choose lection");
        System.out.println(full_path);
        System.out.println(count);

        if(count == 1)
            count = p_counter;
        else
            count--;

        full_path = half_path + "Slide" + count + types;

        image = new Image(full_path);
        imageViever.setFitWidth(anc.getWidth());
        imageViever.setImage(image);

        System.out.println("b_prev is pressed");
        String s = ""; /*anc.getWidth() + " " + anc.getHeight()*/
        s += count;

        status_label.setText(s);
    });

    b_exit.setOnAction(event -> {
        b_exit.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/singUp.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Lection");
        stage.show();
    });

    }
}