package com.merive;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.mail.MessagingException;

public class EmailController {
    public TextField login, password, title, to;
    public TextArea message;
    public Alert alert;
    public Pane titlebar;

    double x, y;

    public void send() {
        try {
            if (!login.getText().equals("")) {
                password.getText();
                if (!to.getText().equals("")) {
                    Sender se = new Sender();
                    se.send(login.getText(), password.getText(), to.getText(),
                            title.getText(), message.getText());
                    getAlert("Result: OK");
                } else {
                    getAlert("Result: Write To.");
                }
            } else {
                getAlert("Result: Write you email.");
            }
        } catch (MessagingException me) {
            getAlert("Result: Email or Password not accepted.");
        }
    }

    public void getAlert(String res) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(res);
        alert.showAndWait();
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
