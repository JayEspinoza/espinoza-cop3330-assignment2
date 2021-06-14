/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex37;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Initialize variables
        passwordGen passwordKeeper = new passwordGen();
        int length, spec, num;

        length = userStep("What's the minimum length? ");
        spec = userStep("How many special characters? ");
        num = userStep("How many numbers? ");

        // Prints result
        System.out.printf(passwordKeeper.passCreate(length, spec, num));
    }

    // Function userStep
    // Input: String mode
    // Output: Integer.parseInt(validateRate(input, mode))
    // Function takes in user input
    static int userStep(String mode){
        String input;
        System.out.printf("%s ", mode);
        input = userInput.nextLine();

        return Integer.parseInt(validateRate(input, mode));
    }

    // Function validateRate
    // Input: String input, String mode
    // Output: input
    // Function checks if input is a number and
    // prompts the user until a valid input is entered
    static String validateRate(String input, String mode) {
        // Initialize variables
        char[] check = input.toCharArray();
        int invalidChar = 0;

        // For loop checks for validity
        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                break;
            }
        }

        // If statement checks for validity
        if (invalidChar != 1) {
            if(Integer.parseInt(input) == 0) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
            }
        }

        // If-while combo checks for validity and loops
        // until a valid input is entered
        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("%s ", mode);
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

// Class passwordGen
class passwordGen{
    // Variables
    private ArrayList<String> charList = new ArrayList<String>();
    private ArrayList<String> numList = new ArrayList<String>();
    private ArrayList<String> specList = new ArrayList<String>();

    // Constructor creates a symbol bank
    public passwordGen(){
        charList.add("B");
        charList.add("z");
        charList.add("a");
        charList.add("P");
        charList.add("o");
        charList.add("A");
        charList.add("o");
        charList.add("y");
        charList.add("q");
        charList.add("i");
        charList.add("m");
        charList.add("M");
        charList.add("P");
        charList.add("p");
        charList.add("y");
        charList.add("h");

        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");
        numList.add("5");
        numList.add("6");
        numList.add("7");
        numList.add("8");
        numList.add("9");
        numList.add("0");

        specList.add("!");
        specList.add("?");
        specList.add("`");
        specList.add("-");
        specList.add("=");
        specList.add("#");
    }

    // Function passCreate
    // Input: int length, int specx, int num
    // Output: password
    // Function generates a password using the 3 generated
    // symbol banks
    public String passCreate(int length, int spec, int num){
        // Initialize variables
        Random gen = new Random();
        int random, letters;
        letters = length - spec - num;
        String password = "";

        // For loop generates a password based on
        // the length the user gives
        for(int i = 0; i < length; i++){
            random = gen.nextInt(3) + 1;

            // If-else statements compare the amount of each symbol
            // needed and generates a password based on it utilizing
            // random numbers
            if(random == 3 && spec != 0){
                password += specList.get(gen.nextInt(specList.size()));
                spec--;
            }else if(random == 2 && num != 0){
                password += numList.get(gen.nextInt(numList.size()));
                num--;
            }else if(letters != 0){
                password += charList.get(gen.nextInt(charList.size()));
                letters--;
            }else{
                if(spec != 0){
                    password += specList.get(gen.nextInt(specList.size()));
                    spec--;
                }else if(num != 0){
                    password += numList.get(gen.nextInt(numList.size()));
                    num--;
                }
            }
        }

        return password;
    }
}