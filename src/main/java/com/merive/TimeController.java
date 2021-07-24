package com.merive;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeController implements Initializable {

    @FXML
    Label time;

    @FXML
    Pane titlebar;

    double x, y;

    public void start() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'Today' dd.MM.yyyy, HH:mm:ss");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(() -> {
            LocalDateTime now = LocalDateTime.now();
            String nowFormatted = dateTimeFormatter.format(now);
            Platform.runLater(() -> time.setText(nowFormatted));
        }, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }

    public void minimize() {
        ((Stage) titlebar.getScene().getWindow()).setIconified(true);
    }

    @FXML
    public void move(MouseEvent me) {
        Stage stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        stage.setX(me.getScreenX() - x);
        stage.setY(me.getScreenY() - y);
    }

    @FXML
    public void press(MouseEvent me) {
        x = me.getSceneX();
        y = me.getSceneY();
    }

    public void exit() {
        ((Stage) titlebar.getScene().getWindow()).close();
    }
}
