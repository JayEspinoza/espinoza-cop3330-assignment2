/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex31;

import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Initialize variables
        int resting, age;
        resting = userStep("Resting Pulse");
        age = userStep("Age");
        heartRate myHeartRate = new heartRate(resting, age);

        // Print rates
        myHeartRate.printRates(age, resting);
    }

    // Function userInput
    // Input: String mode
    // Output: inputted int
    // Function takes user input
    static int userStep(String mode){
        System.out.printf("Enter the %s: ", mode);
        return Integer.parseInt(validateRate(userInput.nextLine(), mode));
    }

    // Function validateRate
    // Input: String input, String mode
    // Output: String input
    // Function ensures the rate is valid
    // by checking to see if it is a number
    static String validateRate(String input, String mode) {
        // Initialize variables
        char[] check = input.toCharArray();
        int invalidChar = 0;

        // For loop checks validity
        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                break;
            }
        }

        // If statement checks validity
        if (invalidChar != 1) {
            if(Integer.parseInt(input) == 0) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
            }
        }

        // If-while combo checks for validity by
        // looping until a condition is met
        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Enter the %s: ", mode);
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
                    if(Integer.parseInt(input) == 0) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                    }
                }
            }
        }

        return input;
    }
}

// Class heartRate
class heartRate{
    // Variables
    double [] targetHeartRate = new double[9];

    // Constructor
    public heartRate(int resting, int age){
        genRates(resting, age);
    }

    // Function genRates
    // Input: int resting, int age
    // Output: N/A
    // Function generates the heart rates based on
    // the resting heart rate and the age
    public void genRates(int resting, int age){
        // Generates the target heart rate
        for(int i = 0; i < 9; i++){
            targetHeartRate[i] = (((220 - age) - resting) * (((i*5.00) + 55.00)/100.00)) + resting;
        }
    }

    // Function printRates
    // Input: int age, int resting
    // Output: N/A
    // Function prints heart rates in a tabular format
    public void printRates(int age, int resting){
        // Print
        System.out.printf("Resting pulse: %d \tAge: %d%n", resting, age);
        System.out.printf("Intensity\t| Rate%n------------|------%n");
        for(int i = 0; i < 9; i++){
            System.out.printf("%d%%\t\t\t| %.0f bpm\n", (((i) * 5) + 55), targetHeartRate[i]);
        }
    }

    // Function getRates
    // Output: targetHeartRate
    public double [] getRates(){
        return targetHeartRate;
    }
}
