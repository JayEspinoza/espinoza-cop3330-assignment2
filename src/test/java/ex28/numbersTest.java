package ex28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class numbersTest {

    @Test
    @DisplayName("Total: 50")
    void generateTotal() {
        numbers num = new numbers();
        int [] list = {10,10,10,10,10};
        num.generateTotal(list);

        assertEquals(50, num.getTotal());
    }
}