package ex38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class numFilterTest {

    // User inputs "1 2 3 4 5 6 7 8"
    // filterList finds the even numbers
    // Function returns "2 4 6 8 "
    @Test
    @DisplayName("1 2 3 4 5 6 7 8")
    void filterList() {
        numFilter test = new numFilter();
        String [] testArray = {"1", "2", "3", "4", "5", "6", "7", "8"};

        assertEquals("2 4 6 8 ", test.filterList(testArray));
    }
}