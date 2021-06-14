package ex24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class appTest {

    // User inputs ball and lalb
    // isAnagram compares the entries
    // Returns that they are anagrams
    @Test
    @DisplayName("ball and lalb")
    public void isAnagram() {
        anagram Anagram = new anagram();

        assertEquals("ball And lalb are anagrams.", Anagram.isAnagram("ball", "lalb"));
    }
}