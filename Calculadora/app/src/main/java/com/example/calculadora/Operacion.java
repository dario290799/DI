package com.example.calculadora;

public class Operacion {
    private int operando1,operando2;
    private String operacion;

    public Operacion(int operando1, int operando2, String operacion) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
