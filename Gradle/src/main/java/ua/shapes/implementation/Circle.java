package ua.shapes.implementation;

import ua.shapes.interfaces.Shape;

import java.util.Scanner;


public class Circle  implements Shape{
    private double r;
    @Override
    public double calculateArea() {
        return Math.PI*r*r;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public void readValues(Scanner scanner) {
        System.out.println("Enter radius: ");
        this.r = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "\nCircle area equals: " + String.format("%.3f",calculateArea()) + "\nCircle length equals: "+String.format("%.3f",calculatePerimeter()) ;
    }

    public void setR(double r) {
        this.r = r;
    }
}
