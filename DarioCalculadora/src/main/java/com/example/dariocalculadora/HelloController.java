package com.example.dariocalculadora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // Calculadora
    @FXML
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,log,cos,tan,sin,sum,borrar,raiz,div,igual,res,mult;
    @FXML
    private ToggleButton cientificaToggle;
    @FXML
    private GridPane panelBotones;
    @FXML
    private HBox cientificaBox;
    @FXML
    private AnchorPane ventanaGeneral;
    @FXML
    private TextField calcField;
    @FXML
    private BorderPane borderPane;

    // Variables
    private float data;
    private int operation = -1;
    private float answer;

    // Metodos
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicio();
        calculadoraCientifica();
    }

    private void inicio() {
        borderPane.getChildren().remove(cientificaBox);
        cientificaToggle.setSelected(false);
        borderPane.getChildren().remove(calcField);
    }

    private void calculadoraCientifica() {
        cientificaToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    borderPane.setBottom(cientificaBox);
                } else {
                    borderPane.getChildren().remove(cientificaBox);
                }
            }
        });

    }

    @FXML
    private void funcionamientoBotones(ActionEvent event) {
        // Números
        if (event.getSource().equals(uno)) {
            calcField.setText(calcField.getText() + "1");
        } else if (event.getSource().equals(dos)) {
            calcField.setText(calcField.getText() + "2");
        } else if (event.getSource().equals(tres)) {
            calcField.setText(calcField.getText() + "3");
        } else if (event.getSource().equals(cuatro)) {
            calcField.setText(calcField.getText() + "4");
        } else if (event.getSource().equals(cinco)) {
            calcField.setText(calcField.getText() + "5");
        } else if (event.getSource().equals(seis)) {
            calcField.setText(calcField.getText() + "6");
        } else if (event.getSource().equals(siete)) {
            calcField.setText(calcField.getText() + "7");
        } else if (event.getSource().equals(ocho)) {
            calcField.setText(calcField.getText() + "8");
        } else if (event.getSource().equals(nueve)) {
            calcField.setText(calcField.getText() + "9");
        } else if (event.getSource().equals(cero)) {
            calcField.setText(calcField.getText() + "0");

            //Borrar
        } else if (event.getSource().equals(borrar)) {
            data = 0;
            calcField.setText("");

            // Operaciones
        } else if (event.getSource().equals(sum)) {
            data = Float.parseFloat(calcField.getText());
            operation = 1;
            calcField.setText("+");
        } else if (event.getSource().equals(res)) {
            data = Float.parseFloat(calcField.getText());
            operation = 2;
            calcField.setText("-");
        } else if (event.getSource().equals(mult)) {
            data = Float.parseFloat(calcField.getText());
            operation = 3;
            calcField.setText("*");
        } else if (event.getSource().equals(div)) {
            data = Float.parseFloat(calcField.getText());
            operation = 4;
            calcField.setText("/");
        } else if (event.getSource().equals(raiz)) {
            data = Float.parseFloat(calcField.getText());
            operation = 5;
            calcField.setText("");
        } else if (event.getSource().equals(log)) {
            data = Float.parseFloat(calcField.getText());
            operation = 6;
            calcField.setText("");
        } else if (event.getSource().equals(sin)) {
            data = Float.parseFloat(calcField.getText());
            operation = 7;
            calcField.setText("");
        } else if (event.getSource().equals(cos)) {
            data = Float.parseFloat(calcField.getText());
            operation = 8;
            calcField.setText("");
        } else if (event.getSource().equals(tan)) {
            data = Float.parseFloat(calcField.getText());
            operation = 9;
            calcField.setText("");

        } else if (event.getSource().equals(igual)) {
            int numeroDos = Integer.parseInt(calcField.getText());

            switch (operation) {
                case 1:
                    answer = data + numeroDos;
                    break;
                case 2:
                    answer = data - numeroDos;
                    break;
                case 3:
                    answer = data * numeroDos;
                    break;
                case 4:
                    answer = data / numeroDos;
                    break;
                case 5:
                    answer = (float) Math.sqrt(numeroDos);
                    break;
                case 6:
                    answer = (float) Math.log10(numeroDos);
                    break;
                case 7:
                    answer = (float) Math.sin(numeroDos);
                    break;
                case 8:
                    answer = (float) Math.cos(numeroDos);
                    break;
                case 9:
                    answer = (float) Math.tan(numeroDos);
                    break;
            }
            calcField.appendText(String.valueOf(answer + "\n"));
            calcField.setText(String.valueOf(answer));

        } else if (event.getSource().equals(cientificaToggle)) {
            cientificaToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldvalue, Boolean newValue) {
                    if (newValue) {
                        ventanaGeneral.setClip(cientificaBox);
                    } else {
                        ventanaGeneral.getChildren().remove(cientificaBox);
                    }
                }
            });

        }
    }

}