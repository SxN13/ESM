package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label status_label;

    @FXML
    private TextField pass_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button log_button;

    @FXML
    void initialize() {
       log_button.setOnAction(event -> {
           String l = login_field.getText();
           String p = pass_field.getText();
           String tl = "login";
           String tp = "pass";
           if(l.equals(tl) && p.equals(tp)) {
               System.out.println(login_field.getText() + " " + pass_field.getText());
               log_button.getScene().getWindow().hide();
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/sample/sample.fxml"));
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
           } else {
               status_label.setText("Wrong login or password");
           }
       });
    }
}
