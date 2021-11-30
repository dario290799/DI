package com.example.jsonpractica;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button perAle;
    @FXML
    private ImageView imagePer;
    @FXML
    private Label nomPer;
    @FXML
    private TextArea frasePer;
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            realizarPeticion();
        } catch (IOException e) {
            e.printStackTrace();
            frasePer.setText("Error de conexion");
        }
        try {
            sacarElementos();
        } catch (IOException e) {
            e.printStackTrace();
            frasePer.setText("No saca los elementos");
        }

    }
    public static JSONArray realizarPeticion() throws IOException, JSONException {
        JSONArray array = null;

        String url = "https://thesimpsonsquoteapi.glitch.me/quotes";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject myResponse = new JSONObject(response.toString());
        array = myResponse.getJSONArray("quotes");
        return array;
    }
    public void sacarElementos() throws IOException {
        JSONArray array = realizarPeticion();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            nomPer.setText(object.getString("quote"));
            frasePer.setText(object.getString("character"));
            String imagenString = object.getString("image");
            Image img = new Image(imagenString);
            imagePer.setImage(img);
        }
    }


}