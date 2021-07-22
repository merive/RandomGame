package com.merive;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MToolsSplash extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/splash.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);

        stage.setTitle("MTools");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResource("icons/launcher_icon.png").toString()));
        stage.setResizable(false);
        stage.show();

        Platform.runLater(() -> {
            try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
            stage.hide();
            openLauncher();
        });
    }

    public void openLauncher() {
        try {
            new Launcher().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

