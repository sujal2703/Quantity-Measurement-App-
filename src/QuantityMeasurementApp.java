public class QuantityMeasurementApp {

    // Inner class representing a measurement in Feet
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet otherFeet = (Feet) obj;
            return Double.compare(otherFeet.value, this.value) == 0;
        }
    }

    // Inner class representing a measurement in Inches
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches otherInches = (Inches) obj;
            return Double.compare(otherInches.value, this.value) == 0;
        }
    }

    // Static method to handle Feet equality check
    public static boolean compareFeet(double val1, double val2) {
        Feet feet1 = new Feet(val1);
        Feet feet2 = new Feet(val2);
        return feet1.equals(feet2);
    }

    // Static method to handle Inches equality check
    public static boolean compareInches(double val1, double val2) {
        Inches inches1 = new Inches(val1);
        Inches inches2 = new Inches(val2);
        return inches1.equals(inches2);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Inches comparison
        boolean areInchesEqual = compareInches(1.0, 1.0);
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + areInchesEqual + ")");

        // Feet comparison
        boolean areFeetEqual = compareFeet(1.0, 1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + areFeetEqual + ")");
    }
}