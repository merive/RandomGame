package com.merive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Time extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/time.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Time");
        stage.getIcons().add(new Image(getClass().getResource("icons/time_icon.png").toString()));
        stage.setScene(new Scene(root, 600, 175));
        stage.setResizable(false);
        stage.show();
    }
}

