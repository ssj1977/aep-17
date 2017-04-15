package edu.berkeley.aep;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

// Validates that a rectangle has four sides and four right angles
public class RectangleTest {
    @Test
    public void rectangleWithSlidesTwoByTwoShouldHaveAreaFour() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }

    @Test
    public void rectangleWithSlidesTwoByTwoShouldHaveAreaEight() {
        Rectangle rectangle = new Rectangle(2, 4);
        assertEquals(8, rectangle.area());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleWithNegativeLengthSidesShouldNotBeCreatable(){
        Rectangle rectangle = new Rectangle(-2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleWithNegativeWidthSidesShouldNotBeCreatable(){
        Rectangle rectangle = new Rectangle(2, -4);
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour(){
        Rectangle square = Rectangle.createSquare(2);
        assertEquals (4, square.area());
    }

}