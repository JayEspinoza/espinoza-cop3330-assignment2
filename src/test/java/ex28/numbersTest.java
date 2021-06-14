package ex28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class numbersTest {

    // User inputs 10 for all 5 entries
    // getTotal adds up the inputs
    // Function returns 50
    @Test
    @DisplayName("Total: 50")
    void generateTotal() {
        numbers num = new numbers();
        int [] list = {10,10,10,10,10};
        num.generateTotal(list);

        assertEquals(50, num.getTotal());
    }
}