package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUno,btnDos,btnTres,btnCuatro,btnCinco,btnSeis,btnSiete,btnOcho,btnNueve,btnCero,
            btnMr,btnDiezPor,btnEe,btnRand,btnLogDiez,btnC,btnMasMenos,btnPorcentaje,
            btnDividir,btnMultiplicar,btnSumar,btnRestar,btnIgual,btnCuadrado,btnCubo;

    private String numeroUno="";
    private String numeroDos="";
    //private String txtResultado="0";
    private String ultimaTeclaPulsada;
    private Operacion operacion;
    private TextView textoResulatado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
        accionesHorizontal();}
        operacion=new Operacion(0,0,null);
    }

    private void accionesHorizontal() {
        btnMr.setOnClickListener(this);
        btnDiezPor.setOnClickListener(this::onClick);
        btnEe.setOnClickListener(this::onClick);
        btnRand.setOnClickListener(this::onClick);
        btnLogDiez.setOnClickListener(this::onClick);

    }

    private void acciones() {
        btnUno.setOnClickListener(this::onClick);
        btnDos.setOnClickListener(this::onClick);
        btnTres.setOnClickListener(this::onClick);
        btnCuatro.setOnClickListener(this::onClick);
        btnCinco.setOnClickListener(this::onClick);
        btnSeis.setOnClickListener(this::onClick);
        btnSiete.setOnClickListener(this::onClick);
        btnOcho.setOnClickListener(this::onClick);
        btnNueve.setOnClickListener(this::onClick);
        btnCero.setOnClickListener(this::onClick);
        btnC.setOnClickListener(this::onClick);
        btnDividir.setOnClickListener(this::onClick);
        btnMultiplicar.setOnClickListener(this::onClick);
        btnRestar.setOnClickListener(this::onClick);
        btnSumar.setOnClickListener(this::onClick);
        btnIgual.setOnClickListener(this::onClick);
        btnCubo.setOnClickListener(this);
        btnCuadrado.setOnClickListener(this);


    }

    private void instancias() {
        btnCero=findViewById(R.id.btn_cero);
        btnUno=findViewById(R.id.btn_uno);
        btnDos=findViewById(R.id.btn_dos);
        btnTres=findViewById(R.id.btn_tres);
        btnCuatro=findViewById(R.id.btn_cuatro);
        btnCinco=findViewById(R.id.btn_cinco);
        btnSeis=findViewById(R.id.btn_seis);
        btnSiete=findViewById(R.id.btn_siete);
        btnOcho=findViewById(R.id.btn_ocho);
        btnNueve=findViewById(R.id.btn_nueve);
        btnMr=findViewById(R.id.btn_MR);
        btnDiezPor=findViewById(R.id.btn_diez_por);
        btnEe=findViewById(R.id.btn_ee);
        btnRand=findViewById(R.id.rand);
        btnLogDiez=findViewById(R.id.btn_log);
        btnC=findViewById(R.id.btn_C);

        btnDividir=findViewById(R.id.btn_dividir);
        btnMultiplicar=findViewById(R.id.btn_multiplicar);
        btnSumar=findViewById(R.id.btn_mas);
        btnRestar=findViewById(R.id.btn_menos);
        btnIgual=findViewById(R.id.btn_igual);
        textoResulatado=findViewById(R.id.txt_resultado);
        btnCuadrado=findViewById(R.id.cuadrado);
        btnCubo=findViewById(R.id.btn_cubo);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btn_uno:
                textoResulatado.append(btnUno.getText());


                break;
            case R.id.btn_dos:
                textoResulatado.append(btnDos.getText());

                break;
            case R.id.btn_tres:
                textoResulatado.append(btnTres.getText());
                break;
            case R.id.btn_cuatro:
                textoResulatado.append(btnCuatro.getText());
                break;
            case R.id.btn_cinco:
                textoResulatado.append(btnCinco.getText());
                break;
            case R.id.btn_seis:
                textoResulatado.append(btnSeis.getText());
                break;
            case R.id.btn_siete:
                textoResulatado.append(btnSiete.getText());
                break;
            case R.id.btn_ocho:
                textoResulatado.append(btnOcho.getText());
                break;
            case R.id.btn_nueve:
                textoResulatado.append(btnNueve.getText());
                break;

            case R.id.btn_cero:
                textoResulatado.append(btnCero.getText());

                break;

            case R.id.btn_mas:
                operacion.setOperacion("+");
                añadirOperando();
                break;
            case R.id.btn_menos:
                operacion.setOperacion("-");
                añadirOperando();

                break;
            case R.id.btn_multiplicar:
                operacion.setOperacion("*");
                añadirOperando();

                break;
            case R.id.btn_dividir:
                operacion.setOperacion("/");
                añadirOperando();
                break;

            case R.id.cuadrado:
                operacion.setOperacion("x2");
                añadirOperando();
                calcular();
                break;

            case R.id.btn_cubo:
                operacion.setOperacion("x3");
                añadirOperando();
                calcular();
                break;

            case R.id.btn_igual:
                añadirOperando();
                calcular();

                operacion.setOperacion(null);


                break;





            case R.id.btn_C:
                operacion.setOperacion(null);
                numeroUno=null;
                numeroDos=null;
                operacion.setOperando1(0);
                operacion.setOperando2(0);
                textoResulatado.setText("");
                break;
                

        }


    }

    private void calcular() {

        int resultado=0;
        operacion.setOperando1(Integer.parseInt(numeroUno));
        if (numeroDos.length()>0){operacion.setOperando2(Integer.parseInt(numeroDos));}
        switch (operacion.getOperacion()){
            case "+":
               resultado =operacion.getOperando1()+operacion.getOperando2();
               textoResulatado.setText(String.valueOf(resultado));
                break;
            case "-":
                resultado =operacion.getOperando1()-operacion.getOperando2();
                textoResulatado.setText(String.valueOf(resultado));
                break;
            case "*":
                resultado =operacion.getOperando1()*operacion.getOperando2();
                textoResulatado.setText(String.valueOf(resultado));
                break;
            case "/":
                resultado =operacion.getOperando1()/operacion.getOperando2();
                textoResulatado.setText(String.valueOf(resultado));
                break;

            case "x2":
                resultado=operacion.getOperando1()* operacion.getOperando1();
                textoResulatado.setText(String.valueOf(resultado));
                break;
            case "x3":
                resultado= (int) Math.pow(operacion.getOperando1(),3);
                textoResulatado.setText(String.valueOf(resultado));
                break;

        }
        Log.v("text",String.valueOf(numeroUno));
        Log.v("text",String.valueOf(numeroDos));
    }

    private void añadirOperando() {

        if (numeroUno.length() == 0) {

            numeroUno = textoResulatado.getText().toString();
            Log.v("text", String.valueOf(numeroUno));
            Log.v("text", String.valueOf(numeroUno.length()));
        } else if (numeroUno.length() > 0 && numeroDos.length() == 0) {
            numeroDos = textoResulatado.getText().toString();
            //Log.v("text",textoResulatado.getText().toString());
            Log.v("text", String.valueOf(numeroDos));


        } else if (numeroUno.length() > 0 && numeroDos.length() > 0) {
            numeroUno = String.valueOf(textoResulatado.getText());
            numeroDos = "";


        }
        textoResulatado.setText("");


    }}