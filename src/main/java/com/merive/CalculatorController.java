package com.merive;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CalculatorController {

    public Pane titlebar;
    public TextField textField;
    public String OPERATOR = "";
    double x, y;
    int num1;
    int num2;

    @FXML
    void clickClear() {
        textField.setText("");
        OPERATOR = "";
    }

    @FXML
    void click0() {
        checkError();
        textField.setText(textField.getText() + "0");
    }

    @FXML
    void click1() {
        checkError();
        textField.setText(textField.getText() + "1");
    }

    @FXML
    void click2() {
        checkError();
        textField.setText(textField.getText() + "2");
    }

    @FXML
    void click3() {
        checkError();
        textField.setText(textField.getText() + "3");
    }

    @FXML
    void click4() {
        checkError();
        textField.setText(textField.getText() + "4");
    }

    @FXML
    void click5() {
        checkError();
        textField.setText(textField.getText() + "5");
    }

    @FXML
    void click6() {
        checkError();
        textField.setText(textField.getText() + "6");
    }

    @FXML
    void click7() {
        checkError();
        textField.setText(textField.getText() + "7");
    }

    @FXML
    void click8() {
        checkError();
        textField.setText(textField.getText() + "8");
    }

    @FXML
    void click9() {
        checkError();
        textField.setText(textField.getText() + "9");
    }

    @FXML
    void clickPlus() {
        checkError();
        if (OPERATOR.equals("")) {
            textField.setText(textField.getText() + "+");
            OPERATOR = "+";
        } else {
            getResult();
        }
    }

    @FXML
    void clickMinus() {
        checkError();
        if (OPERATOR.equals("")) {
            textField.setText(textField.getText() + "-");
            OPERATOR = "-";
        } else {
            getResult();
        }
    }

    @FXML
    void clickMulti() {
        checkError();
        if (OPERATOR.equals("")) {
            textField.setText(textField.getText() + "*");
            OPERATOR = "*";
        } else {
            getResult();
        }
    }

    @FXML
    void clickDivision() {
        checkError();
        if (OPERATOR.equals("")) {
            textField.setText(textField.getText() + "/");
            OPERATOR = "/";
        } else {
            getResult();
        }
    }

    @FXML
    void clickEqually() {
        checkError();
        if (OPERATOR.equals("")) {
            textField.setText(textField.getText());
        } else {
            getResult();
        }
    }

    public void checkError() {
        if (textField.getText().equals("Error")) {
            textField.setText("");
            OPERATOR = "";
        }
    }

    public void getResult() {
        String[] numbers = textField.getText().split(String.format("\\%s", OPERATOR));
        try {
            num1 = Integer.parseInt(numbers[0]);
            num2 = Integer.parseInt(numbers[1]);
        } catch (Exception e) {
            textField.setText("Error");
            OPERATOR = "";
        }
        switch (OPERATOR) {
            case "+":
                textField.setText(String.valueOf(num1 + num2));
                OPERATOR = "";
                break;
            case "-":
                textField.setText(String.valueOf(num1 - num2));
                OPERATOR = "";
                break;
            case "*":
                textField.setText(String.valueOf(num1 * num2));
                OPERATOR = "";
                break;
            case "/":
                try {
                    textField.setText(String.valueOf(num1 / num2));
                    OPERATOR = "";
                    break;
                } catch (ArithmeticException exc) {
                    textField.setText("Error");
                    OPERATOR = "";
                    break;
                }
        }
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
