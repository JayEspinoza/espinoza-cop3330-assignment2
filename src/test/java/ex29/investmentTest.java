package ex29;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class investmentTest {

    // User inputs 4
    // getMonths calculates the months
    // Function returns 18
    @Test
    @DisplayName("72/4")
    void setMonths() {
        investment test = new investment();
        test.setMonths("4");

        assertEquals(18, test.getMonths());
    }
}