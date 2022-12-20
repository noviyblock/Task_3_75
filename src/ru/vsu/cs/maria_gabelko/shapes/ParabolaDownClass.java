package ru.vsu.cs.maria_gabelko.shapes;

public class ParabolaDownClass {
    private final double a;
    private final double b;
    private final double c;

    public ParabolaDownClass(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double countValue(double x){
        return a*x*x+b*x+c;
    }

    public boolean isInParabola(double x,double y){
        return y<=countValue(x);
    }
}
