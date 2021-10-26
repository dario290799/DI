package Modelos;

public class Operaciones {

    private int a;

    private int b;

    //contructor

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;

    }

    //Getter y setters

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    //metodos

    public int sumar(){
        return a+b;
    }
    public int restar(){
        return a-b;
    }
    public int multiplicar(){
        return a*b;
    }
    public double dividir(){
        return (double) a/b;
    }
}
