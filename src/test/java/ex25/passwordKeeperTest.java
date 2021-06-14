package ex25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class passwordKeeperTest {

    // User inputs Coolio24!@!
    // passwordValidator checks to see the entry's strength
    // Returns very strong password
    @Test
    @DisplayName("Coolio24!@!")
    void passwordValidator() {
        passwordKeeper password = new passwordKeeper("Coolio24!@!");

        assertEquals("very strong password", password.passwordValidator());
    }

    // User inputs beep1
    // Function generates the strength values of the password
    // Strength of 4 at index 0
    @Test
    @DisplayName("Strength 4")
    void strengthCheck() {
        passwordKeeper passwordKeeper = new passwordKeeper("beep1");
        int [] strength = passwordKeeper.strengthCheck("beep1");

        assertEquals(4, strength[0]);
    }
}