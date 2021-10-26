package Modelo;

public class Operaciones {
    private int a;

    public int getA() {
        return a;
    }


    public Operaciones(int a){
        this.a = a;

    }

    @Override
    public String toString() {
        return "Operaciones{" +
                "a=" + a +
                '}';
    }

    public void setA(int a) {
        this.a = a;
    }

    public int incrementar(){
        return  a+1;
    }

    public int decrementar(){
        return a-1;
    }
}
