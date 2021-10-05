package com.example._041021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField Texto1;
    @FXML
    private TextField Texto2;
    @FXML
    private TextField Texto3;


    public void sumar(ActionEvent actionEvent){
        try {
            int n1 = Integer.parseInt(Texto1.getText());
            int n2 = Integer.parseInt(Texto2.getText());

            Texto3.setText(Integer.toString(n1 + n2));

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setTitle("Error");
            alert.setContentText("formato incorrecto");
            alert.showAndWait();
        }
    }
}