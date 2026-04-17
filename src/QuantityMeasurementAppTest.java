import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

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
    }
}