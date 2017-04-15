package edu.berkeley.aep;

// Understands arithmetical measurements in a particular unit.
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int size, Unit unit) {
        super(size, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(size + other.unit.convert(other.size, unit), unit);
    }
}