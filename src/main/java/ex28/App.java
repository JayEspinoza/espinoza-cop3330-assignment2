/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex28;
import java.util.Scanner;

// Class App
public class App {
    // Main
    public static void main(String [] args){
        // Initialize variables
        int [] list = new int[5];
        numbers myNumbers = new numbers();
        list = myNumbers.numberInput();

        // Functions and final results
        myNumbers.generateTotal(list);
        System.out.printf("The total is %d.", myNumbers.getTotal());
    }
}

// Class numbers
class numbers{
    static Scanner userInput = new Scanner(System.in);
    private int total = 0;

    // Function generateTotal
    // Input: int [] list
    // Output: void
    public void generateTotal(int [] list){
        // Runs through list and adds to total
        for(int c : list){
            total += c;
        }
    }

    // Function numberInput
    // Input: N/A
    // Output: list
    // Function takes user input
    public int [] numberInput(){
        // Initialize variables
        int [] list = new int[5];

        // User input
        for(int i = 0; i < list.length; i++){
            System.out.printf("Enter a number: ");
            list[i] = userInput.nextInt();
        }

        return list;
    }

    // Function getTotal
    // Returns total
    public int getTotal(){
        return total;
    }
}
