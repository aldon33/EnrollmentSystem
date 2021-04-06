package Menu;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    @FXML
    private void initialize() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/StartScreen.fxml"));
        primaryStage.setTitle("Enrollment System");
        primaryStage.setScene(new Scene(root, 717, 501));
        primaryStage.show();
    }
/*
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        primaryStage.setTitle("Enrollment System");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

 */
    public static void main(String[] args) {
    launch(args);
}
}
