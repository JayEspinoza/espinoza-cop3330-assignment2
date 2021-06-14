package ex29;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class investmentTest {

    @Test
    @DisplayName("72/4")
    void setMonths() {
        investment test = new investment();
        test.setMonths("4");

        assertEquals(18, test.getMonths());
    }
}