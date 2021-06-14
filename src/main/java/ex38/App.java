/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex38;
import java.util.Scanner;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Initialize variables
        String input = userStep();
        numFilter list = new numFilter();

        // Prints output
        System.out.printf("The even numbers are %s.", list.filterList(list.arraySplit(input)));
    }

    // Function userStep
    // Input: N/A
    // Output: user input
    // Function takes user input
    static String userStep(){
        System.out.printf("Enter a list of numbers, separated by spaces: ");
        return userInput.nextLine();
    }
}

// Class numFilter
class numFilter{
    // Function arraySplit
    // Input: String initList
    // Output: String [] postList
    // Function splits the inputted String into an array
    public String [] arraySplit(String initList){
        String [] postList = initList.split(" ");
        return postList;
    }

    // Function filterList
    // Input: String [] initList
    // Output: postList
    // Function filters out all non-even numbers and returns
    // them in string format
    public String filterList(String [] initList){
        String postList = "";

        // For loop checks the entire list to see
        // if an entry is even
        for(String c : initList){
            if(Character.isDigit(c.charAt(0))){
                if(Integer.parseInt(c) % 2 == 0){
                    postList += (c + " ");
                }
            }
        }

        return postList;
    }
}