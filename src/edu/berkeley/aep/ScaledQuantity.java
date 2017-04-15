package edu.berkeley.aep;

// Understands arithmetical measurements in a particular unit.
public class ScaledQuantity implements Bestable<ScaledQuantity> {

    final int size;
    final Unit unit;

    public ScaledQuantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity = (ScaledQuantity) other;
        if (!unit.comparableWith(((ScaledQuantity) other).unit)) return false;
        return size == otherQuantity.unit.convert(otherQuantity.size, unit);
    }

    @Override
    public String toString() {
        return size + " " + unit ;
    }

    @Override
    public boolean betterThan(ScaledQuantity other) {
        return size > other.unit.convert(other.size, unit);
    }
}