package ex26;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;

class paymentCalculatorTest {

    // User inputs 5000, 12, and 100 respectively
    // calculateMonthsUntilPaidOff calculates the result
    // Function returns 70 when rounded up for output
    @Test
    @DisplayName("5000, 12, 100")
    void calculateMonthsUntilPaidOff() {
        paymentCalculator calc = new paymentCalculator();

        assertEquals(70, Math.ceil(calc.calculateMonthsUntilPaidOff(5000.00, 12.00, 100.00)));
    }
}