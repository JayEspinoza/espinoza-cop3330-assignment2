package ex27;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class employeeTest {

    // User inputs "Watson"
    // validateName checks for validity
    // Function returns 0 for valid
    @Test
    @DisplayName("Watson")
    void validateName() {
        employee emp = new employee();

        assertEquals(0, emp.validateName("Watson"));
    }

    // User inputs "Watson"
    // validateZip checks for validity
    // Function returns false as not a valid input
    @Test
    @DisplayName("Watson ZIP")
    void validateZip() {
        employee emp = new employee();

        assertEquals(false, emp.validateZip("Watson"));
    }

    // User inputs "AA-1234"
    // validateEmployeeId checks for validity
    // Function returns true
    @Test
    @DisplayName("AA-1234")
    void validateEmployeeId() {
        employee emp = new employee();

        assertEquals(true, emp.validateEmployeeId("AA-1234"));
    }
}