import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 feet should equal 1.0 feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityMeasurementApp.QuantityLength inch1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength inch2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(inch1.equals(inch2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(feet.equals(inches), "1.0 feet should equal 12.0 inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(inches.equals(feet), "12.0 inches should equal 1.0 feet (Symmetry)");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 feet should not equal 2.0 feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        QuantityMeasurementApp.QuantityLength inch1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength inch2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertFalse(inch1.equals(inch2), "1.0 inch should not equal 2.0 inches");
    }

    @Test
    public void testEquality_NullUnit() {
        // Validates that passing a null unit throws an IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
        assertEquals("Unit cannot be null", exception.getMessage(), "Should throw exception when unit is null");
    }

    @Test
    public void testEquality_SameReference() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet.equals(feet), "Object should equal itself (Reflexive)");
    }

    @Test
    public void testEquality_NullComparison() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(feet.equals(null), "Object should not equal null");
    }

    @Test
    public void testEquality_InvalidType() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        String invalidType = "1.0 feet";
        assertFalse(feet.equals(invalidType), "Object should not equal an object of a different type");
    }
}