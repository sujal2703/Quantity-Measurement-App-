import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ==========================================
    // Tests for Feet Equality
    // ==========================================

    @Test
    public void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet2), "Two Feet objects with the same value should be equal");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);
        assertFalse(feet1.equals(feet2), "Two Feet objects with different values should not be equal");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(null), "A Feet object should not be equal to null");
    }

    @Test
    public void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        String nonNumericInput = "1.0 ft";
        assertFalse(feet.equals(nonNumericInput), "A Feet object should not be equal to a String");
    }

    @Test
    public void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet.equals(feet), "A Feet object should be equal to itself (reflexive property)");
    }

    // ==========================================
    // Tests for Inches Equality
    // ==========================================

    @Test
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inches1.equals(inches2), "Two Inches objects with the same value should be equal");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(2.0);
        assertFalse(inches1.equals(inches2), "Two Inches objects with different values should not be equal");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inches.equals(null), "An Inches object should not be equal to null");
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        String nonNumericInput = "1.0 inch";
        assertFalse(inches.equals(nonNumericInput), "An Inches object should not be equal to a String");
    }

    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inches.equals(inches), "An Inches object should be equal to itself (reflexive property)");
    }
}