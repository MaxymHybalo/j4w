package ua.shapes.implementation;


import ua.shapes.interfaces.Shape;

import java.util.Scanner;

public class Triangle implements Shape {
    private double a,b,c;

    public Triangle(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {}

    @Override
    public double calculateArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public double calculatePerimeter() {
        return a+b+c;
    }

    @Override
    public void readValues(Scanner scanner) {
        System.out.println("Enter side a: ");
        this.a = scanner.nextInt();
        System.out.println("Enter side b: ");
        this.b = scanner.nextInt();
        System.out.println("Enter side c: ");
        this.c = scanner.nextInt();

    }

    @Override
    public String toString() {
        if(!isExist()) return "\nThe triangle doesn't exist!";
        return "\nTriangle area equals: " + String.format("%.3f",calculateArea()) + "\nTriangle perimeter equals: "+String.format("%.3f",calculatePerimeter()) ;
    }
    public boolean isExist(){
        return (a<b+c) & (b<c+a) & (c<a+b);
    }
}
