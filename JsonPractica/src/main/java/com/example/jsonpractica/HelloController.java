package com.example.jsonpractica;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button equipo1,equipo2,equipo3,equipo4,equipo5,equipo6,equipo7,equipo8,equipo9,equipo10;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lecturaJSON();
    }
    private void lecturaJSON() {


        String url = "https://www.thesportsdb.com/api/v1/json/2/searchteams.php?t=";

        InputStream input;
        try {
            input = new URL(url).openStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(input));
            String respuesta = bis.readLine();
            JSONObject jsonGeneral = new JSONObject(respuesta);
            JSONArray array = jsonGeneral.getJSONArray("teams");

            for (int i = 0; i < array.length(); i++) {
                JSONObject liga = array.getJSONObject(i);
                String equipo = liga.getString("strAlternate");
                String escudo = liga.getString("strTeamBadge");
                String descripcion = liga.getString("strDescriptionEN");
                String nombreEstadio = liga.getString("Akureyrarvöllur");
                String descripcionEstadio = liga.getString("strStadiumDescription");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void imprimirJson(){

    }

}