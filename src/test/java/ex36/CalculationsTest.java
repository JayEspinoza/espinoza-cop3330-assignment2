package ex36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

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