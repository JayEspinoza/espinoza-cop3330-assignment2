/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex36;

import java.util.Scanner;
import java.util.ArrayList;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Initialize variables
        ArrayList<Integer> numbers = userStep();
        Calculations calc = new Calculations();

        // Print results
        System.out.printf("The average is %.2f%nThe minimum id %d%nThe maximum is %d%nThe standard deviation is %.2f", calc.average(numbers), calc.min(numbers), calc.max(numbers), calc.std(numbers));
    }

    // Function userStep
    // Input: N/A
    // Output: ArrayList<Integer> list
    // Function takes in user input until done
    static ArrayList<Integer> userStep(){
        // Variable initialize
        ArrayList<Integer> list = new ArrayList<Integer>();
        String input = "";
        System.out.printf("Enter the response time in milliseconds.%n");

        // While loop continues until prompted "done"
        while(!(input.equals("Done") || input.equals("done"))) {
            System.out.printf("Enter a number: ");
            input = userInput.nextLine();

            if(!(input.equals("Done") || input.equals("done"))) {
                if (validateInput(input) == 0) {
                    list.add(Integer.parseInt(input));
                }
            }
        }

        return list;
    }

    // Function validateInput
    // Input: String input
    // Output: invalidChar
    // Function validates if the input is a number
    static int validateInput(String input) {
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

        return invalidChar;
    }
}

// Class Calculations
class Calculations{
    // Function average
    // Input: ArrayList<Integer> numbers
    // Output: combined/(double)numbers.size()
    // Function calculates and returns the average of the
    // numbers in the list
    public double average(ArrayList<Integer> numbers){
        double combined = 0;

        for(int i = 0; i < numbers.size(); i++){
            combined += numbers.get(i);
        }

        return combined/(double)numbers.size();
    }

    // Function min
    // Input: ArrayList<Integer> numbers
    // Output: min
    // Function returns the minimum value in the
    // list
    public int min(ArrayList<Integer> numbers){
        int min = Integer.MAX_VALUE;

        // For loop finds the minimum integer
        for(int i = 0; i < numbers.size(); i++){
            if(min > numbers.get(i))
                min = numbers.get(i);
        }

        return min;
    }

    // Function max
    // Input: ArrayList<Integer> numbers
    // Output: max
    // Function calculates and returns
    // the maximum value in the list
    public int max(ArrayList<Integer> numbers){
        int max = Integer.MIN_VALUE;

        // For loop finds the maximum integer
        for(int i = 0; i < numbers.size(); i++){
            if(max < numbers.get(i))
                max = numbers.get(i);
        }

        return max;
    }

    // Function std
    // Input: ArrayList<Integer> numbers
    // Output: standard deviation
    // Function calculates and returns the
    // standard deviation of the list
    public double std(ArrayList<Integer> numbers){
        double mean = average(numbers);
        double total = 0;
        double result;

        for(int i = 0; i < numbers.size(); i++){
            total += Math.pow((numbers.get(i)) - mean, 2);
        }

        total = total/(double)numbers.size();
        result = Math.sqrt(total);

        return result;
    }
}
