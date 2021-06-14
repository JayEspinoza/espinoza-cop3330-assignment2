/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex33;
import java.util.Random;
import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Variable initialize
        magicEight magicEight = new magicEight();
        System.out.printf("What's your question?%n> ");
        setUserInput();

        // Print output
        System.out.printf("%s", magicEight.returnResult());
    }

    static String setUserInput(){
        return userInput.nextLine();
    }
}

// Class magicEight
class magicEight {
    // Variables
    private Random gen = new Random();
    private int num;

    // Constructor
    public magicEight(){
        num = gen.nextInt(4) + 1;
    }

    // Function returnResult
    // Input: N/A
    // Output: 1 of 4 strings
    public String returnResult(){
        // Switch statement uses random
        // num to return a string
        switch(num){
            case 1:
                return "Yes";
            case 2:
                return "No";
            case 3:
                return "Maybe";
            default:
                return "Ask again later";
        }
    }
}