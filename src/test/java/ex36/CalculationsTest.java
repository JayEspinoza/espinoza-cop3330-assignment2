package ex36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    // User inputs 100, 200, 1000, 300 for all 3 tests

    // average calculates the average of the inputs
    // Function returns 400
    @Test
    @DisplayName("Average")
    void average() {
        Calculations test = new Calculations();
        ArrayList<Integer> testList = new ArrayList<Integer>();

        testList.add(100);
        testList.add(200);
        testList.add(1000);
        testList.add(300);

        assertEquals(400, test.average(testList));
    }

    // min finds minimum input
    // Function returns 100
    @Test
    @DisplayName("Min")
    void min() {
        Calculations test = new Calculations();
        ArrayList<Integer> testList = new ArrayList<Integer>();

        testList.add(100);
        testList.add(200);
        testList.add(1000);
        testList.add(300);

        assertEquals(100, test.min(testList));
    }

    // max finds maximum input
    // Function returns 1000
    @Test
    @DisplayName("Max")
    void max() {
        Calculations test = new Calculations();
        ArrayList<Integer> testList = new ArrayList<Integer>();

        testList.add(100);
        testList.add(200);
        testList.add(1000);
        testList.add(300);

        assertEquals(1000, test.max(testList));
    }

    // std calculates standard deviation
    // Function returns 354 when rounded with ceil
    @Test
    @DisplayName("Standard Deviation")
    void std() {
        Calculations test = new Calculations();
        ArrayList<Integer> testList = new ArrayList<Integer>();

        testList.add(100);
        testList.add(200);
        testList.add(1000);
        testList.add(300);

        assertEquals(354, Math.ceil(test.std(testList)));
    }
}