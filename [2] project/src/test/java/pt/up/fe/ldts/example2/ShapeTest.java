package pt.up.fe.ldts.example2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShapeTest {
    @Test
    public void getAreaCircle() throws Exception {
        Circle circle = new Circle(5, 5, 10);
        assertEquals(314.16, circle.getArea(), 0.01);
    }
    @Test
    public void getAreaRectangle() {
        Rectangle rectangle = new Rectangle(5, 5, 10, 20);
        assertEquals(200, rectangle.getArea(), 0.01);
    }
    @Test
    public void getPerimeterCircle() throws Exception {
        Circle circle = new Circle(5, 5, 10);
        assertEquals(62.83, circle.getPerimeter(), 0.01);
    }
    @Test
    public void getPerimeterRectangle() throws Exception {
        Rectangle rectangle = new Rectangle(5, 5, 10, 20);
        assertEquals(60, rectangle.getPerimeter(), 0.01);
    }
    @Test
    public void drawCircle() {
        GraphicFramework graphics = mock(GraphicFramework.class);
        Circle circle = new Circle(5, 5, 10);
        circle.draw(graphics);
        verify(graphics, times(1)).drawCircle(5, 5, 10);
    }
    @Test
    public void drawRectangle() {
        GraphicFramework graphics = mock(GraphicFramework.class);
        Rectangle rectangle = new Rectangle(5, 5, 10, 20);
        rectangle.draw(graphics);
        verify(graphics, times(1)).drawLine(5, 5, 15, 5);
        verify(graphics, times(1)).drawLine(15, 5, 15, 25);
        verify(graphics, times(1)).drawLine(15, 25, 5, 25);
        verify(graphics, times(1)).drawLine(5, 25, 5, 5);
    }
}