package ua.shapes.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.shapes.implementation.Circle;
import ua.shapes.implementation.Rectangle;
import ua.shapes.implementation.Triangle;

import static org.junit.Assert.*;

public class ShapeTest {

    Circle circle;
    Rectangle rectangle;
    Triangle triangle;

    @Before
    public void init(){
        circle = new Circle();
        circle.setR(10d);
        rectangle = new Rectangle();
        rectangle.setA(10d);
        rectangle.setB(10d);
        triangle = new Triangle(6d,6d,6d);
    }

    @Test
    public void rectangleTest(){
        assertEquals(new Double(100),new Double( rectangle.calculateArea()));
        assertEquals(new Double(40), new Double(rectangle.calculatePerimeter()));
    }

    @Test
    public void circleTest(){
        assertNotEquals(new Double(100),new Double( circle.calculateArea()));
        assertNotEquals(new Double(40), new Double(circle.calculatePerimeter()));
    }

    @Test
    public void triangleExistingTest(){
        assertTrue(triangle.isExist());
    }

    @After
    public void clear(){
        circle = null;
        rectangle = null;
        triangle = null;
    }
}
