package ua.shapes.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.shapes.core.Application;
import ua.shapes.enumeration.ShapeType;
import ua.shapes.implementation.Circle;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ApplicationTest {
    Application mockApp;

    @Before
    public void init(){
        mockApp = Mockito.mock(Application.class);
        when(mockApp.readShapeName()).thenReturn(ShapeType.CIRCLE);
    }

    @Test
    public void castTypeTest(){

        when(mockApp.castType(mockApp.readShapeName())).thenCallRealMethod();
        assertEquals("Cast shape type: ", Circle.class, mockApp.castType(mockApp.readShapeName()).getClass());
    }

    @Test
    public void readShapeTest(){
        when(mockApp.input()).thenReturn("Circle");
        assertEquals(ShapeType.CIRCLE, mockApp.readShapeName());
        when(mockApp.input()).thenReturn("CIRcle");
        assertEquals(ShapeType.CIRCLE, mockApp.readShapeName());
    }

    @After
    public void clear(){
        mockApp = null;
    }

}
