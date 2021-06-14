/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex29;
import java.util.Scanner;
import java.lang.Character;

// Class App
public class App {
    // Main
    public static void main(String [] args){
        // Initialize variables
        investment myInvestment = new investment();
        myInvestment.setRate();
        myInvestment.setMonths(myInvestment.getRate());

        // Print result
        System.out.printf("It will take %.0f years to double your initial investment.", myInvestment.getMonths());
    }
}

// Class investment
class investment{
    // Variables
    static Scanner userInput = new Scanner(System.in);
    private String rate;
    private double months;

    // Function setMonths
    // Input: String bottom
    // Output: months
    // Function calculates months via
    // parsing bottom into a double
    public void setMonths(String bottom){
        months = 72/Double.parseDouble(bottom);
    }

    // Function setRate
    // Input: N/A
    // Output: N/A
    // Function sets the rate
    public void setRate(){
        System.out.printf("What is the rate of return? ");
        rate = userInput.nextLine();
        validateRate();
    }

    // Function validateRate
    // Input: N/A
    // Output: N/A
    // Function checks to see if the rate
    // is a valid number
    private void validateRate() {
        // Initialize variables
        char[] check = rate.toCharArray();
        int invalidChar = 0;

        //
        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                break;
            }
        }

        if (invalidChar != 1) {
            if(Double.parseDouble(rate) == 0) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
            }
        }

        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("What is the rate of return? ");
                rate = userInput.nextLine();
                check = rate.toCharArray();

                for (char c : check) {
                    if (!Character.isDigit(c)) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                        break;
                    }
                    invalidChar = 0;
                }

                if (invalidChar != 1) {
                    if(Double.parseDouble(rate) == 0) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                    }
                }
            }
        }
    }

    public double getMonths(){
        return months;
    }

    public String getRate(){
        return rate;
    }
}

