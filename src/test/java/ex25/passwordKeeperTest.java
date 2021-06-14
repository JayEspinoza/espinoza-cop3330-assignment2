package ex25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class passwordKeeperTest {

    @Test
    @DisplayName("Coolio24!@!")
    void passwordValidator() {
        passwordKeeper password = new passwordKeeper("Coolio24!@!");

        assertEquals("very strong password", password.passwordValidator());
    }

    @Test
    void strengthCheck() {
        passwordKeeper passwordKeeper = new passwordKeeper("beep1");
        int [] strength = passwordKeeper.strengthCheck("beep1");

        assertEquals(4, strength[0]);
    }
}