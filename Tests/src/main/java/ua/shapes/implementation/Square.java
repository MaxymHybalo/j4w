package ua.shapes.implementation;

import ua.shapes.interfaces.Shape;

import java.util.Scanner;

public class Square implements Shape{
    private double a;
    private Triangle triangle;
    @Override
    public double calculateArea() {
        return a*a;
    }

    @Override
    public double calculatePerimeter() {
        return a*a;
    }

    @Override
    public void readValues(Scanner scanner) {
        System.out.println("Enter side a: ");
        this.a = scanner.nextInt();
        triangle = new Triangle(a,a,Math.sqrt(a*a+a*a));
    }

    @Override
    public String toString() {
        return   "\nSquare area equals: " + String.format("%.3f",calculateArea()) +"\nSquare perimeter equals: "+String.format("%.3f",calculatePerimeter())
                + "\nSquare consists from triangles, triangle properties: " + triangle.toString();
    }
}
