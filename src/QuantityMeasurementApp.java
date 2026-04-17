public class QuantityMeasurementApp {

    // Inner class representing a measurement in Feet
    public static class Feet {
        private final double value;

        // Constructor to initialize the value
        public Feet(double value) {
            this.value = value;
        }

        // Overriding the equals method to ensure value-based equality
        @Override
        public boolean equals(Object obj) {
            // 1. Check if the object is the same reference (Reflexive)
            if (this == obj) {
                return true;
            }

            // 2. Check for null and ensure exact type match to avoid ClassCastException
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // 3. Cast to Feet safely
            Feet otherFeet = (Feet) obj;

            // 4. Compare double values using Double.compare() instead of ==
            return Double.compare(otherFeet.value, this.value) == 0;
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Feet length1 = new Feet(1.0);
        Feet length2 = new Feet(1.0);

        boolean areEqual = length1.equals(length2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + areEqual + ")");
    }
}