import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        // Given
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertTrue(feet1.equals(feet2), "Two Feet objects with the same value should be equal");
    }

    @Test
    public void testEquality_DifferentValue() {
        // Given
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);

        // When & Then
        assertFalse(feet1.equals(feet2), "Two Feet objects with different values should not be equal");
    }

    @Test
    public void testEquality_NullComparison() {
        // Given
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertFalse(feet.equals(null), "A Feet object should not be equal to null");
    }

    @Test
    public void testEquality_NonNumericInput() {
        // Given
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        String nonNumericInput = "1.0 ft"; // Different object type completely

        // When & Then
        assertFalse(feet.equals(nonNumericInput), "A Feet object should not be equal to an object of a different class type");
    }

    @Test
    public void testEquality_SameReference() {
        // Given
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertTrue(feet.equals(feet), "A Feet object should be equal to itself (reflexive property)");
    }
}