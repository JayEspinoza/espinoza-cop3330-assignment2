/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */

package ex24;
import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Function userStep
    // Input: String placement
    // Output: input
    // Takes user input
    static String userStep(String placement){
        String input;

        System.out.printf("Enter the %s string: ", placement);
        input = userInput.nextLine();

        return input;
    }

    // Main
    public static void main(String [] args)
    {
        // Initialization of variables
        anagram myAnagram = new anagram();
        String wordOne, wordTwo;

        // User input
        System.out.printf("Enter two strings and I'll tell you if they are anagrams:%n");
        wordOne = userStep("first");
        wordTwo = userStep("second");

        // Print
        System.out.printf(myAnagram.isAnagram(wordOne, wordTwo));
    }
}

// Class Anagram
class anagram{
    // Function isAnagram
    // Input: String wordOne, wordTwo
    // Output: wordOne + " And " + wordTwo + " are (not) anagrams."
    // Function takes in two strings and utilizes tables to see if they are anagrams.
    public String isAnagram(String wordOne, String wordTwo){
        // Length Comparison
        if(wordOne.length() != wordTwo.length()){
            return wordOne + " And " + wordTwo + " are not anagrams.";
        }

        // Table Creation using tableCreation method
        int [] tableOne = tableCreation(wordOne);
        int [] tableTwo = tableCreation(wordTwo);

        // Compares letter indexes to see if anagram
        for(int i : tableOne){
            if(tableOne[i] != tableTwo[i]){
                return wordOne + " And " + wordTwo + " are not anagrams.";
            }
        }

        return wordOne + " And " + wordTwo + " are anagrams.";

    }

    // Function tableCreation
    // Input: String word
    // Output: int [] splitWord
    // Splits a word into a table and adds to it for each
    // occurrence of a number
    public int [] tableCreation(String word){
        // Table initialization
        int [] splitWord = new int[24];

        // For loop adds to indexes
        for(int i = 0; i < word.length(); i++){
            splitWord[(int)word.charAt(i) - (int)'a']++;
        }

        return splitWord;
    }
}