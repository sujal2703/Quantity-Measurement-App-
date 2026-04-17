public class QuantityMeasurementApp {

    // Step 1: Enum to define units and their conversion factors to a base unit (Feet)
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0); // 1 Inch is 1/12th of a Foot

        private final double conversionFactorToFeet;

        LengthUnit(double conversionFactorToFeet) {
            this.conversionFactorToFeet = conversionFactorToFeet;
        }

        public double getConversionFactor() {
            return conversionFactorToFeet;
        }
    }

    // Step 2: Generic QuantityLength class replacing separate Feet and Inches classes
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
            // 1. Reflexive check
            if (this == obj) return true;

            // 2. Null and Type safety check
            if (obj == null || getClass() != obj.getClass()) return false;

            // 3. Cast to QuantityLength
            QuantityLength that = (QuantityLength) obj;

            // 4. Convert both values to the common base unit (Feet) for comparison
            double thisValueInBase = this.value * this.unit.getConversionFactor();
            double thatValueInBase = that.value * that.unit.getConversionFactor();

            // 5. Value-based equality check
            // Note: Math.round is used here to avoid standard IEEE 754 floating-point precision issues
            return Double.compare(
                    Math.round(thisValueInBase * 10000.0) / 10000.0,
                    Math.round(thatValueInBase * 10000.0) / 10000.0
            ) == 0;
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", \"" + unit.name().toLowerCase() + "\")";
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Feet to Inches equality
        QuantityLength feet1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch12 = new QuantityLength(12.0, LengthUnit.INCH);
        System.out.println("Input: " + feet1 + " and " + inch12);
        System.out.println("Output: Equal (" + feet1.equals(inch12) + ")");

        // Inch to Inch equality
        QuantityLength inch1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength inch1_copy = new QuantityLength(1.0, LengthUnit.INCH);
        System.out.println("Input: " + inch1 + " and " + inch1_copy);
        System.out.println("Output: Equal (" + inch1.equals(inch1_copy) + ")");
    }
}