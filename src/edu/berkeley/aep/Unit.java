package edu.berkeley.aep;

// Understands how to convert lengths into inches
public enum Unit {
    YARD(3 * 12, 0, UnitType.LENGTH), FOOT(12, 0, UnitType.LENGTH), MILE(1760 * 3 * 12, 0, UnitType.LENGTH), INCHES(1, 0, UnitType.LENGTH),
    TEASPOON(1, 0, UnitType.VOLUME), TABLESPOON(3, 0, UnitType.VOLUME), OUNCE(6, 0, UnitType.VOLUME), CUP(48, 0, UnitType.VOLUME),
    FAHRENHEIT(5, -32, UnitType.TEMPERATURE), CELSIUS(9, 0, UnitType.TEMPERATURE);

    private final int inBaseUnit;
    private final int offset;
    private final UnitType type;

    public boolean comparableWith(Unit other) {
        return other.type.equals(type);
    }

    enum UnitType { LENGTH, VOLUME, TEMPERATURE }

    Unit(int inBaseUnit, int offset, UnitType type) {
        this.inBaseUnit = inBaseUnit;
        this.offset = offset;
        this.type = type;
    }

    public int convert(int size, Unit other) {
        if (!other.comparableWith(this)) {
            throw new RuntimeException("Cannot compare " + type + " to " + other.type + "!");
        }
        return ((size + offset) * inBaseUnit / other.inBaseUnit) - other.offset;
    }
}