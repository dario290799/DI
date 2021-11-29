package com.example.examendi;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private Button activar,pedido;
    @FXML
    private TextField nombreUno,passUno,nombreDos,apellido,direccion,telefono;
    @FXML
    private CheckBox cebolla,salchichas,jamon,champinones,queso,salsa;
    @FXML
    private TextArea area;
    @FXML
    private Label total;
    private boolean variable = false;

    public void LoginAcceso(){
        String nombreUnoString= nombreUno.getText().toString();
        String passUnoString= passUno.getText().toString();
        if (nombreUnoString == "usuario 1" && passUnoString == "12345"){
            variable = true;
        }else{
            variable = false;
        }
        nombreDos.setEditable(variable);
        apellido.setEditable(variable);
        direccion.setEditable(variable);
        telefono.setEditable(variable);


    }

    public void Pedido(){
        String nombreDosString = nombreDos.getText().toString();
        String apellidoString = apellido.getText().toString();
        String telefonoString = telefono.getText().toString();
        int totalPedido=5;
        if (apellidoString == null || nombreDosString == null){
            System.out.println("Los campos Nombre o Apellido estan vacios, rellena los campos.");
        }else{
            area.setText(nombreDosString + "    " + telefonoString);
        }
        if (cebolla.isSelected() ){
            totalPedido = totalPedido+2;
        }
        if (jamon.isSelected() ){
            totalPedido = totalPedido+2;
        }
        if (queso.isSelected() ){
            totalPedido = totalPedido+2;
        }
        if (salchichas.isSelected() ){
            totalPedido = totalPedido+2;
        }
        if (champinones.isSelected() ){
            totalPedido = totalPedido+2;
        }
        if (salsa.isSelected() ){
            totalPedido = totalPedido+2;
        }
        String totalPedidoString;
        totalPedidoString = String.valueOf(totalPedido);
        total.setText(totalPedidoString);


    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mi aplicación");

    }
}