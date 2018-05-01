package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); /*test.fxml sample.fxml singUp.fxml */
        primaryStage.setTitle("Aunth");
        primaryStage.setScene(new Scene(root, 800, 600)); /*1107, 678 */
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            try {
                stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
