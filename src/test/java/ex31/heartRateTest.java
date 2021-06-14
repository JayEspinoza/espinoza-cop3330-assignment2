package ex31;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class heartRateTest {

    // User inputs 65 and 22
    // getRates calculates the heart rates
    // getRates[0] has a value of 138
    @Test
    @DisplayName("65, 22")
    void genRates() {
        heartRate test = new heartRate(65, 22);

        assertEquals(138, Math.round(test.getRates()[0]));
    }
}