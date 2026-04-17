public class QuantityMeasurementApp {

    // Extended Enum to include YARDS and CENTIMETERS
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),                     // 1 Yard = 3 Feet
        CENTIMETER(0.393701 / 12.0);   // 1 cm = 0.393701 inches, and 1 inch = 1/12 feet

        private final double conversionFactorToFeet;

        LengthUnit(double conversionFactorToFeet) {
            this.conversionFactorToFeet = conversionFactorToFeet;
        }

        public double getConversionFactor() {
            return conversionFactorToFeet;
        }
    }

    // Generic QuantityLength class (Remains untouched from UC3)
    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength that = (QuantityLength) obj;

            double thisValueInBase = this.value * this.unit.getConversionFactor();
            double thatValueInBase = that.value * that.unit.getConversionFactor();

            // Value-based equality check using precision rounding
            return Double.compare(
                    Math.round(thisValueInBase * 100000.0) / 100000.0,
                    Math.round(thatValueInBase * 100000.0) / 100000.0
            ) == 0;
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit.name() + ")";
        }
    }

    // Main method to demonstrate functionality with new units
    public static void main(String[] args) {
        QuantityLength yard1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet3 = new QuantityLength(3.0, LengthUnit.FEET);
        System.out.println("Input: " + yard1 + " and " + feet3);
        System.out.println("Output: Equal (" + yard1.equals(feet3) + ")\n");

        QuantityLength inch36 = new QuantityLength(36.0, LengthUnit.INCH);
        System.out.println("Input: " + yard1 + " and " + inch36);
        System.out.println("Output: Equal (" + yard1.equals(inch36) + ")\n");

        QuantityLength yard2 = new QuantityLength(2.0, LengthUnit.YARD);
        QuantityLength yard2_copy = new QuantityLength(2.0, LengthUnit.YARD);
        System.out.println("Input: " + yard2 + " and " + yard2_copy);
        System.out.println("Output: Equal (" + yard2.equals(yard2_copy) + ")\n");

        QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
        QuantityLength cm2_copy = new QuantityLength(2.0, LengthUnit.CENTIMETER);
        System.out.println("Input: " + cm2 + " and " + cm2_copy);
        System.out.println("Output: Equal (" + cm2.equals(cm2_copy) + ")\n");

        QuantityLength cm1 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength inchFromCm = new QuantityLength(0.393701, LengthUnit.INCH);
        System.out.println("Input: " + cm1 + " and " + inchFromCm);
        System.out.println("Output: Equal (" + cm1.equals(inchFromCm) + ")");
    }