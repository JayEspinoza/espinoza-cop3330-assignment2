/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */

package ex25;
import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Function userStep
    // Input: None
    // Output: String input
    // Takes and returns user input
    static String userStep(){
        String input;

        System.out.printf("Enter a password: ");
        input = userInput.nextLine();

        return input;
    }

    // Function output
    // Input: String password, String strength
    // Output: None
    // Prints the password
    static void output(String password, String strength){
        System.out.printf("The password '%s' is a %s.", password, strength);
    }

    // Main
    public static void main(String [] args){
        // Running Functions
        passwordKeeper password = new passwordKeeper(userStep());
        output(password.getPassword(), password.getStrength());
    }
}

// Class passwordKeeper
class passwordKeeper {
    // Variables
    String password;
    String strength;

    public passwordKeeper(String input){
        // Initialization of Variables
        password = input;
        strength = passwordValidator();
    }

    // Function getPassword
    // Input: N/A
    // Output: password
    public String getPassword(){
        return password;
    }

    // Function getStrength
    // Input: N/A
    // Output: strength
    public String getStrength(){
        return strength;
    }

    // Function passwordValidator
    // Input: N/A
    // Output: 1 of 5 password variations
    // Function determines the strength of the password
    public String passwordValidator(){
        // Initialization of variables
        int [] strengthArray = strengthCheck(password);

        // Determines password strength
        if(password.length() < 8){
            if((strengthArray[1] > 0 && strengthArray[0] == 0 && strengthArray[2] == 0)){
                return "very weak password";
            }else if(strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] == 0){
                return "weak password";
            }
        }else if((strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] == 0)){
            return "strong password";
        }else if(strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] > 0){
            return "very strong password";
        }

        return "N/A";
    }

    // Function strengthCheck
    // Input: String password
    // Output: int [] strength
    // Sets up the strength array depending on the character's values
    int [] strengthCheck(String password){
        // Initialize variable
        int [] strength = new int [3];

        // Compares character values and
        // adds them to their respective strength
        // index
        for(int i = 0; i < password.length(); i++){
            if ((int)password.charAt(i) >= 97 && (int)password.charAt(i) <= 122) {
                strength[0]++;
            }else if((int)password.charAt(i) >= 65 && (int)password.charAt(i) <= 90) {
                strength[0]++;
            }else if((int)password.charAt(i) >= 48 && (int)password.charAt(i) <= 57){
                strength[1]++;
            }else{
                strength[2]++;
            }
        }

        return strength;
    }
}
