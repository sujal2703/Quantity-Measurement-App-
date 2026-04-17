import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

feature/UC4
    // ==========================================
    // Yard Comparisons
    // ==========================================

    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityMeasurementApp.QuantityLength yard1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength yard2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(yard1.equals(yard2), "1.0 yard should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        QuantityMeasurementApp.QuantityLength yard1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength yard2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertFalse(yard1.equals(yard2), "1.0 yard should not equal 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(yard.equals(feet), "1.0 yard should equal 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(feet.equals(yard), "3.0 feet should equal 1.0 yard (Symmetry)");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(yard.equals(inches), "1.0 yard should equal 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(inches.equals(yard), "36.0 inches should equal 1.0 yard (Symmetry)");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(yard.equals(feet), "1.0 yard should not equal 2.0 feet");
    }

    // ==========================================
    // Centimeter Comparisons
    // ==========================================

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength inch = new QuantityMeasurementApp.QuantityLength(0.393701, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(cm.equals(inch), "1.0 cm should equal 0.393701 inches");
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(cm.equals(feet), "1.0 cm should not equal 1.0 feet");
    }

    // ==========================================
    // Multi-Unit & Transitivity
    // ==========================================

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet), "A = B");
        assertTrue(feet.equals(inches), "B = C");
        assertTrue(yard.equals(inches), "A = C (Transitive)");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(72.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet), "2.0 yards should equal 6.0 feet");
        assertTrue(yard.equals(inches), "2.0 yards should equal 72.0 inches");
    }

    // ==========================================
    // Null & Reference Checks
    // ==========================================

    @Test
    public void testEquality_YardWithNullUnit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
        assertEquals("Unit cannot be null", exception.getMessage());
    }

    @Test
    public void testEquality_YardSameReference() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(yard.equals(yard), "Yard object should equal itself");
    }

    @Test
    public void testEquality_YardNullComparison() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertFalse(yard.equals(null), "Yard object should not equal null");
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
        assertEquals("Unit cannot be null", exception.getMessage());
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        assertTrue(cm.equals(cm), "Centimeter object should equal itself");
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        assertFalse(cm.equals(null), "Centimeter object should not equal null");

    @Test
feature/UC3
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