package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Constants;
import sample.model.Kunde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("layouts/Login.fxml"));
        // Fjerner all vindudekorasjon
        primaryStage.initStyle(StageStyle.UNDECORATED);
        // Endrer applikasjonsikonet til mitt eget
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream( "icon.png" )));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
