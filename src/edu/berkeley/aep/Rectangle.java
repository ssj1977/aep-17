package edu.berkeley.aep;

//Understands a four-sided figure with four right angles
public class Rectangle {
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        if (width<0 || length<0) {
            throw new IllegalArgumentException(("Sides must be positive integers."));
        }
        this.width = width;
        this.length = length;
    }

    public int area() {
        return width * length;
    }

    public static Rectangle createSquare(int side){
        return new Rectangle(side, side);
    }
}