package com.example.primitiva131021;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t7;

    public void Ramdom() {
        int [] numeros = new int[6];
        for (int i = 0; i < 6; i++) {
            numeros[i]=(int) Math.floor((Math.random()*(100)));
        }
        t1.setText(String.valueOf(numeros[1]));
        t2.setText(String.valueOf(numeros[2]));
        t3.setText(String.valueOf(numeros[3]));
        t4.setText(String.valueOf(numeros[4]));
        t5.setText(String.valueOf(numeros[5]));
        t6.setText(String.valueOf(numeros[6]));
        t7.setText(String.valueOf(numeros[7]));
    }
}