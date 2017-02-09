package ua.shapes.implementation;


import ua.shapes.interfaces.Shape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle implements Shape{
    private double a,b;
    private Triangle triangle;
    @Override
    public double calculateArea() {
        return a*b;
    }

    @Override
    public double calculatePerimeter() {
        return 2*(a+b);
    }

    @Override
    public void readValues(Scanner scanner) throws InputMismatchException {
        System.out.println("Enter side a: ");
        this.a = scanner.nextInt();
        System.out.println("Enter side b: ");
        this.b = scanner.nextInt();

        triangle = new Triangle(a,b,Math.sqrt(a*a+b*b));

    }
    @Override
    public String toString() {
        return  "\nRectangle area equals: " + String.format("%.3f",calculateArea()) +"\nRectangle perimeter equals: "+String.format("%.3f",calculatePerimeter())
                + "\nRectangle consists from triangles, triangle properties: " + triangle.toString();
    }
}
