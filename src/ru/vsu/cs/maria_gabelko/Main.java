package ru.vsu.cs.maria_gabelko;

import ru.vsu.cs.maria_gabelko.shapes.LineClass;
import ru.vsu.cs.maria_gabelko.shapes.ParabolaDownClass;

import java.util.Scanner;

public class Main {

    //проверка правильного диапазона координаты точки
    static boolean validationCoordinate(double coordinate){
        return coordinate <= 10 && coordinate >= -10;
    }

    static String getColor(double x, double y){

        ParabolaDownClass miniParabola = new ParabolaDownClass(-0.5,4,-8);
        ParabolaDownClass bigParabola = new ParabolaDownClass(-0.25,0.5,4.75);
        LineClass line = new LineClass(5.5,-22.5);
        LineClass horizontalLine = new LineClass(0,-1);

        String answer = "{x: "+x+", y: "+y+"} -> ";

        //grey zone
        if(horizontalLine.isUpOrRightOfLine(x,y) && (line.isUpOrRightOfLine(x,y) || miniParabola.isInParabola(x,y))){
            return answer+SimpleColor.GRAY;
        }

        //yellow zone
        if(horizontalLine.isUpOrRightOfLine(x,y) && !line.isUpOrRightOfLine(x,y) && !miniParabola.isInParabola(x,y)){
            return answer+SimpleColor.YELLOW;
        }

        //white zone
        if(!horizontalLine.isUpOrRightOfLine(x,y) && !bigParabola.isInParabola(x,y) && x<0){
            return answer+SimpleColor.WHITE;
        }

        //blue zone
        if(!horizontalLine.isUpOrRightOfLine(x,y) && bigParabola.isInParabola(x,y) && !miniParabola.isInParabola(x,y) && x<3){
            return answer+SimpleColor.BLUE;
        }

        //orange zone
        if(!horizontalLine.isUpOrRightOfLine(x,y) && miniParabola.isInParabola(x,y) && !line.isUpOrRightOfLine(x,y)){
            return answer+SimpleColor.ORANGE;
        }
        return answer+SimpleColor.GREEN;
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Point point = new Point();
        double x,y;

        //ввод данных и одновременная проверка на диапазон
        while (true){
            int flag = -1;
            System.out.print("Enter x-coordinate: ");
            x=scanner.nextDouble();
            //проверка координаты x, ввод пока координата не будет в диапазоне
            if(validationCoordinate(x)){
                point.setX(x);
                while (true){
                    //проверка координаты y, ввод пока координата не будет в диапазоне
                    System.out.print("Enter y-coordinate: ");
                    y=scanner.nextDouble();
                    if(validationCoordinate(y)){
                        point.setY(y);
                        flag=1;
                        break;
                    }else{
                        System.out.println("Error.The y-coordinate must be >=-10 and <=10. Pls,retry");
                    }
                }
            }else{
                System.out.println("Error.The x-coordinate must be >=-10 and <=10. Pls,retry");
            }
            if(flag==1) break;
        }

        System.out.println(getColor(point.getX(), point.getY()));
    }
}