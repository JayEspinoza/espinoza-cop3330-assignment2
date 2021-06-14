package ex27;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class employeeTest {

    @Test
    @DisplayName("Watson")
    void validateName() {
        employee emp = new employee();

        assertEquals(0, emp.validateName("Watson"));
    }

    @Test
    @DisplayName("Watson ZIP")
    void validateZip() {
        employee emp = new employee();

        assertEquals(false, emp.validateZip("Watson"));
    }

    @Test
    @DisplayName("AA-1234")
    void validateEmployeeId() {
        employee emp = new employee();

        assertEquals(true, emp.validateEmployeeId("AA-1234"));
    }
}