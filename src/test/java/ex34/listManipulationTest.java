package ex34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class listManipulationTest {

    // User inputs "Two"
    // removeEmployee checks the list for "Two"
    // testList at index 1 has a value of "Three"
    @Test
    @DisplayName("Remove Two")
    void removeEmployee() {
        ArrayList<String> testList = new ArrayList<String>();
        listManipulation test = new listManipulation();

        testList.add("One");
        testList.add("Two");
        testList.add("Three");

        test.removeEmployee("Two", testList);

        assertEquals("Three", testList.get(1));
    }
}