/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex32;
import java.util.Scanner;
import java.util.Random;

// Class App
public class App {

    // Main
    public static void main(String [] args){
        // Variable initialization
        System.out.printf("Let's play Guess the Number!%n%n");
        number game = new number();
        game.generateNumber();

        // Guessing game
        game.guess();
    }
}

// Class number
class number {
    // Variables
    static Scanner userInput = new Scanner(System.in);
    private int answer;
    private int guesses;
    private Random rand = new Random();

    // Constructor
    public number() {
        guesses = 0;
    }

    // Function generateNumber
    // Input: N/A
    // Output: N/A
    // Generates a number to guess based
    // on the difficulty level
    public void generateNumber() {
        // Initialize variables
        int difficulty = setDiff();

        // Generates an answer based on the difficulty
        // chosen
        if (difficulty == 1) {
            answer = rand.nextInt(10) + 1;
        } else if (difficulty == 2) {
            answer = rand.nextInt(100) + 1;
        } else {
            answer = rand.nextInt(1000) + 1;
        }
    }

    // Function guessIncrement
    // Increments guess
    private void guessIncrement() {
        guesses++;
    }

    // Function setDiff
    // Input: N/A
    // Output: N/A
    // Function sets difficulty level
    private int setDiff() {
        System.out.printf("Enter the difficulty level (1, 2, 3): ");
        return Integer.parseInt(validateDifficulty(userInput.nextLine()));
    }

    // Function validateDifficulty
    // Input: String input
    // Output: N/A
    // Function validates if difficulty is a number
    // and whether or not it's 1, 2, or 3
    private String validateDifficulty(String input) {
        // Initialize variables
        char[] check = input.toCharArray();
        int invalidChar = 0;

        // For loop checks validity based on parameters
        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                break;
            }
        }

        // If loop checks validity based on parameters
        if (invalidChar != 1) {
            if ((Integer.parseInt(input) == 1) || (Integer.parseInt(input) == 2) || (Integer.parseInt(input) == 3)) {
                invalidChar = 0;
            }else {
                System.out.println("Sorry. That is not a valid input.");
                invalidChar = 1;
            }
        }

        // If-while combo checks validity and loops until
        // a proper number is entered
        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Enter the difficulty level (1, 2, or 3): ");
                input = userInput.nextLine();
                check = input.toCharArray();

                for (char c : check) {
                    if (!Character.isDigit(c)) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                        break;
                    }
                    invalidChar = 0;
                }

                if (invalidChar != 1) {
                    if ((Integer.parseInt(input) == 1) || (Integer.parseInt(input) == 2) || (Integer.parseInt(input) == 3)) {
                        invalidChar = 0;
                    }else {
                        System.out.println("Sorry. That is not a valid input.");
                        invalidChar = 1;
                    }

                }
            }
        }

        return input;
    }

    // Function guess
    // Input: N/A
    // Output: N/A
    // Function runs the guessing game
    public void guess() {
        // User input
        System.out.printf("I have my number. What's your guess? ");
        guessIncrement();
        // Checks answer
        validateNum(userInput.nextLine());
    }

    // Function validateNum
    // Input: String input
    // Output: N/A
    // Function loops until the correct answer is entered
    private void validateNum(String input) {
        char[] check = input.toCharArray();
        int invalidChar = 0;

        // For loop validates if number
        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                guessIncrement();
                break;
            }
        }

        // If statement checks to see if it's the answer
        if (invalidChar != 1) {
            // If statements check to see the range it's
            // in
            if (Integer.parseInt(input) > answer) {
                invalidChar = 1;
                System.out.println("Too high. ");
                guessIncrement();
            }

            if (Integer.parseInt(input) < answer) {
                invalidChar = 1;
                System.out.println("Too low. ");
                guessIncrement();
            }

        }

        // If-while loop checks for validity
        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Guess again: ");
                input = userInput.nextLine();
                check = input.toCharArray();

                for (char c : check) {
                    if (!Character.isDigit(c)) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                        guessIncrement();
                        break;
                    }
                    invalidChar = 0;
                }

                if (invalidChar != 1) {
                    if (Integer.parseInt(input) > answer) {
                        invalidChar = 1;
                        System.out.println("Too high. ");
                        guessIncrement();
                    }

                    if (Integer.parseInt(input) < answer) {
                        invalidChar = 1;
                        System.out.println("Too low. ");
                        guessIncrement();
                    }
                }
            }
        }

        // endGameSequence to repeat
        endGameSequence();
    }

    // Function endGameSequence
    // Input: N/A
    // Output: N/A
    // Function repeats the game with a new number
    // depending on the user's input
    private void endGameSequence(){
        String choice;

        System.out.printf("You got it in %d guesses!%nWould you like to play again? ", guesses);
        choice = repeat();

        // Input comparison
        if(choice.equals("Y") || choice.equals("y")){
            generateNumber();
            guess();
        }
    }

    // Function repeat
    // Output: user input
    private String repeat(){
        return userInput.nextLine();
    }
}

