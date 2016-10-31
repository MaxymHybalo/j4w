package ua.shapes.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Shape {

    public double calculateArea();
    public double calculatePerimeter();
    public void readValues(Scanner scanner) throws InputMismatchException;
}
