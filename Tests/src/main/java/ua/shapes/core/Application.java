package ua.shapes.core;

import ua.shapes.enumeration.ShapeType;
import ua.shapes.implementation.Circle;
import ua.shapes.implementation.Rectangle;
import ua.shapes.implementation.Square;
import ua.shapes.implementation.Triangle;
import ua.shapes.interfaces.Shape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {


    public Application() {

        ShapeType shapeName = readShapeName();
        Shape shape = castType(shapeName);
        getShapeValues(shape);
        System.out.println(shape.toString());

    }
    public static void main(String[] args) {
        new Application();
    }
    public Shape castType(ShapeType type){
        switch (type){
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            case TRIANGLE:
                return new Triangle();
        }
        return null;
    }
    public void getShapeValues(Shape shape) {
        boolean isRead = false;
        while (!isRead) {
            try {
                isRead = true;
                shape.readValues(new Scanner(System.in));
            } catch (InputMismatchException ie) {
                System.out.println("Some values maybe wrong!");
                isRead = false;
            }
        }
    }
    public ShapeType readShapeName(){

        ShapeType type = null;


        boolean isRead = false;

        while (!isRead){
            System.out.println("Write shape name(Like:circle,square,rectangle,triangle):");
            String shapeName = input();
            for (ShapeType s:
                 ShapeType.values()) {
                if(shapeName.toUpperCase().equals(s.toString())){
                    type = s;
                    isRead = true;
                }
            }
        }
        return type;
    }

    public String input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
