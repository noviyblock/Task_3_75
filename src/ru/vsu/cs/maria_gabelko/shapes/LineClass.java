package ru.vsu.cs.maria_gabelko.shapes;

public class LineClass {
    private final double k;
    private final double c;

    public LineClass(double k, double c) {
        this.k=k;
        this.c=c;
    }

    private double countValueLine(double x){
        return k*x+c;
    }

    public boolean isUpOrRightOfLine(double x,double y){
        return y>=countValueLine(x);
    }
}
