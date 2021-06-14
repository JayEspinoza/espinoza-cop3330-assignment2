/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex27;
import java.util.Scanner;
import java.lang.Character;

// Class App
public class App {
    // Main
    public static void main(String [] args){
        // Initialization of variables
        employee myEmployee = new employee();
        myEmployee.setFirstName();
        myEmployee.setLastName();
        myEmployee.setZip();
        myEmployee.setEmployeeId();

        // Validation of input/printing of results
        myEmployee.validateInput();
        myEmployee.printResults();
    }
}

// Class employee
class employee{
    // Variables
    static Scanner userInput = new Scanner(System.in);
    private String firstName, lastName, zipCode, employeeID, validation;

    // Constructor
    public employee(){
        validation = "";
    }

    // Function setFirstName
    // Input: N/A
    // Output: N/A
    // Function takes user input
    public void setFirstName(){
        System.out.printf("Enter the first name: ");
        firstName = userInput.nextLine();
    }

    // Function setLastName
    // Input: N/A
    // Output: N/A
    // Function takes user input
    public void setLastName(){
        System.out.printf("Enter the last name: ");
        lastName = userInput.nextLine();
    }

    // Function validateName
    // Input: String name
    // Output: 0-3 depending on the result
    // Function validates the name
    public int validateName(String name){
        if (name.length() < 2 && name.equals("")){
            return 3;
        }else if(name.length() < 2 && !name.equals("")){
            return 2;
        }else if(name.equals("")){
            return 1;
        }

        return 0;
    }

    // Function setZip
    // Input: N/A
    // Output: N/A
    // Function takes user input
    public void setZip(){
        System.out.printf("Enter the ZIP code: ");
        zipCode = userInput.nextLine();    }

    // Function validateZip
    // Input: String zip
    // Output: true or false
    // Function validates if zip is valid depending on
    // if it's a number
    public boolean validateZip(String zip){
        // Initialize variables
        char [] check = zip.toCharArray();

        // Checks to see if check is only numbers
        for(char c : check){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }

    // Function setEmployeeID
    // Input: N/A
    // Output: N/A
    // Function takes user input
    public void setEmployeeId(){
        System.out.printf("Enter the employee ID: ");
        employeeID = userInput.nextLine();
    }

    // Function validateEmployeeID
    // Input: String id
    // Output: true or false
    // Function compares employee id to see if it fits into
    // the format of AA-1234
    public boolean validateEmployeeId(String id){
        // Initialize variables
        char [] check = id.toCharArray();

        // Checks for AA-
        if(!Character.isAlphabetic(check[0]) || !Character.isAlphabetic(check[1])){
            return false;
        }else if(check[2] != '-'){
            return false;
        }

        // Checks for 1234
        for(int i = 3; i < check.length; i++){
            if(!Character.isDigit(check[i])){
                return false;
            }
        }

        return true;
    }

    // Function validateInput
    // Input: N/A
    // Output: N/A
    // Function runs all four validations
    // (first name, last name, id, and zip code)
    // and determines if they are valid.
    public void validateInput(){
        // Initialize variables
        // Counter determines if there are any errors
        int counter = 0;

        // If statement checks for first name errors
        if(validateName(firstName) != 0){
            counter++;

            // Selection of error statement
            if(validateName(firstName) == 2){
                validation += "The first name must be at least 2 characters long.\n";
            }else if(validateName(firstName) == 1){
                validation += "The first name must be filled in.\n";
            }else if(validateName(firstName) == 3){
                validation += "The first name must be at least 2 characters long.\nThe first name must be filled in.\n";
            }
        }

        // If statement checks for last name errors
        if(validateName(lastName) != 0){
            counter++;

            // Selection of error message
            if(validateName(lastName) == 2){
                validation += "The last name must be at least 2 characters long.\n";
            }else if(validateName(lastName) == 1){
                validation += "The last name must be filled in.\n";
            }else if(validateName(lastName) == 3){
                validation += "The last name must be at least 2 characters long.\nThe last name must be filled in.\n";
            }
        }

        // If statement checks for id errors
        if(!validateEmployeeId(employeeID)){
            counter++;
            validation += "The employee ID must be in the format of AA-1234.\n";
        }

        // If statement checks for zip errors
        if(!validateZip(zipCode)){
            counter++;
            validation += "The zipcode must be a 5 digit number.\n";
        }

        // No errors result
        if(counter == 0){
            validation += "There were no errors found.\n";
        }
    }

    // Function printResults
    // Prints results
    public void printResults(){
        System.out.printf("%s", validation);
    }

}