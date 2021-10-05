package com.example._incrementar_051021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField Result;

    @FXML
    private Button restar;
    @FXML
    private Button sumar;

    int resultado;

    public void Sumar(ActionEvent actionEvent){

        resultado = Integer.parseInt(Result.getText());

        Result.setText(Integer.toString(resultado+1));

    }

    public void Restar(ActionEvent actionEvent){

        resultado = Integer.parseInt(Result.getText());

        Result.setText(Integer.toString(resultado-1));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Result.setText("0");
    }
}