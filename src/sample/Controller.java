package sample;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label status_label;

    @FXML
    private URL location;

    @FXML
    private ListView<Lection> listViever;

    @FXML
    private Button b_next;

    @FXML
    private Button b_prev;

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


    public String set_locale(String str){

        half_path = str;
        return half_path;
    }

    @FXML
    void initialize() {
        status_label.setText(null);
/***************************************************************************************************************/
        listViever.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Lection lection1 = new Lection(0, 5,"тестовые вариант изображений","sample/assets/test/",".jpg");
        Lection lection2 = new Lection(1, 14,"Классификация современных ПК","sample/assets/classification_PC/", ".PNG");
        Lection lection3 = new Lection(2,26,"Архитектура системы команд","sample/assets/asc/", ".PNG");
        Lection lection4 = new Lection(3,17,"Устройства управления","sample/assets/contr/", ".PNG");
        Lection lection5 = new Lection(4,34,"Конвейерная обработка команд","sample/assets/conv/", ".PNG");
        Lection lection6 = new Lection(5,26,"Формат команд","sample/assets/fc/", ".PNG");
        Lection lection7 = new Lection(6,13,"Функциональная и структурная организация ЭВМ","sample/assets/fico/", ".PNG");
        Lection lection8 = new Lection(7,27,"Типы и форматы операндов","sample/assets/form/", ".PNG");

        ObservableList<Lection> lections = FXCollections.observableArrayList(lection1,lection2,lection3,lection4,
                lection5,lection6,lection7,lection8);

        listViever.setItems(lections);

        /***************/
        listViever.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lection>() {
            @Override
            public void changed(ObservableValue<? extends Lection> observable, Lection oldValue, Lection newValue) {
                count = 1;
                id_lec = newValue.getId();
                str = newValue.getLec_name();
                types = newValue.getTypeFile();
                half_path = newValue.getP();
                p_counter = newValue.getPage_count();
                status_label.setText(str + " " + newValue);
            }
        });
    //Кнопка назад
        b_next.setOnAction(event -> {
            System.out.println(id_lec+"\n"+p_counter+"\n"+str+"\n"+half_path+"\n"+types);
        if(id_lec == 999)
            status_label.setText("Choose lection");



        switch (id_lec){
            case 0: full_path = half_path + count + types; break;
            case 1: full_path = half_path + "Slide" + count + types; break;
            case 2: full_path = half_path + "Slide" + count + types; break;
            case 3: full_path = half_path + "Slide" + count + types; break;
            case 4: full_path = half_path + "Slide" + count + types; break;
            case 5: full_path = half_path + "Slide" + count + types; break;
            case 6: full_path = half_path + "Slide" + count + types; break;
            case 7: full_path = half_path + "Slide" + count + types; break;
        }
            System.out.println(full_path);
        image = new Image(full_path);
        imageViever.setFitWidth(anc.getWidth());
        imageViever.setImage(image);
        System.out.println(full_path);
        System.out.println(count);

            if(count == p_counter)
                count = 1;
            else
                count++;

        System.out.println("b_next is pressed");
        String s = ""; /*anc.getWidth() + " " + anc.getHeight()*/
            s += count;
        status_label.setText(s);
        });

    //Кнопка назад
    b_prev.setOnAction(event -> {

        System.out.println(id_lec+"\n"+p_counter+"\n"+str+"\n"+half_path+"\n"+types);
        if(id_lec == 999)
            status_label.setText("Choose lection");
        switch (id_lec){
            case 0: full_path = half_path + count + types; break;
            case 1: full_path = half_path + "Slide" + count + types; break;
            case 2: full_path = half_path + "Slide" + count + types; break;
            case 3: full_path = half_path + "Slide" + count + types; break;
            case 4: full_path = half_path + "Slide" + count + types; break;
            case 5: full_path = half_path + "Slide" + count + types; break;
            case 6: full_path = half_path + "Slide" + count + types; break;
            case 7: full_path = half_path + "Slide" + count + types; break;
        }
        System.out.println(full_path);
        image = new Image(full_path);
        imageViever.setFitWidth(anc.getWidth());
        imageViever.setImage(image);
        System.out.println(full_path);
        System.out.println(count);
        if(count == 1)
            count = p_counter;
        else
            count--;

        System.out.println("b_prev is pressed");
        String s = ""; /*anc.getWidth() + " " + anc.getHeight()*/
        s += count;
        status_label.setText(s);
    });
    }
}