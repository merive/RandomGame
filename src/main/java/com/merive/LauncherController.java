package com.merive;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LauncherController implements Initializable {

    @FXML
    Pane titlebar;

    @FXML
    Label label;

    @FXML
    Button startButton, noteButton, calculatorButton, emailButton, timeButton, RRCButton, exitButton, hideButton;

    @FXML
    ImageView launcherImage, noteImage, calculatorImage, emailImage, timeImage, RRCImage;

    String selectedApplication;
    double x, y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedApplication = "";
    }

    public void clickStartButton() {
        if (!selectedApplication.equals("")) {
            switch (selectedApplication) {
                case "Note":
                    Platform.runLater(() -> {
                        try {
                            new Note().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case "Calculator":
                    Platform.runLater(() -> {
                        try {
                            new Calculator().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case "Email":
                    Platform.runLater(() -> {
                        try {
                            new Email().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case "Time":
                    Platform.runLater(() -> {
                        try {
                            new Time().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case "RRC":
                    Platform.runLater(() -> {
                        try {
                            new RRC().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
            }
        }
    }

    public void clickNote() {
        selectedApplication = "Note";
        resetImage();
        noteImage.setVisible(true);
        label.setText("Selected: Note");
    }

    public void clickCalculator() {
        selectedApplication = "Calculator";
        resetImage();
        calculatorImage.setVisible(true);
        label.setText("Selected: Calculator");
    }

    public void clickEmail() {
        selectedApplication = "Email";
        resetImage();
        emailImage.setVisible(true);
        label.setText("Selected: Email");
    }

    public void clickTime() {
        selectedApplication = "Time";
        resetImage();
        timeImage.setVisible(true);
        label.setText("Selected: Time");
    }

    public void clickRRC() {
        selectedApplication = "RRC";
        resetImage();
        RRCImage.setVisible(true);
        label.setText("Selected: RRC");
    }

    public void exit() {
        Platform.exit();
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

    public void resetImage() {
        launcherImage.setVisible(false);
        noteImage.setVisible(false);
        calculatorImage.setVisible(false);
        emailImage.setVisible(false);
        timeImage.setVisible(false);
        RRCImage.setVisible(false);
    }
}
