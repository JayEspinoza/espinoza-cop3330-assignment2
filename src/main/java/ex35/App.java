/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex35;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Initialize variables
        ArrayList<String> winnerList = genList();
        winner selection = new winner();

        // Print results
        System.out.printf(selection.selectWinner(winnerList));
    }

    // Function genList
    // Input: N/A
    // Output: ArrayList<String> people
    // Function generates a list of names
    static ArrayList<String> genList(){
        // Initialize variables
        String input = "placeholder";
        ArrayList<String> people = new ArrayList<String>();

        // While loop takes in names until a
        // blank name is entered
        while((!(input.equals("")))){
            System.out.printf("Enter a name: ");
            input = userInput.nextLine();
            people.add(input);
        }

        return people;
    }
}

// Class winner
class winner{
    static Random number = new Random();

    // Function selectWinner
    // Input: ArrayList people
    // Output: "The winner is..." + winnerName
    // Function selects a winner based on a random number
    public String selectWinner(ArrayList people){
        int num = number.nextInt(people.size());
        return "The winner is..." + people.get(num);
    }
}
