/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex26;
import java.util.Scanner;
import java.lang.Math;

// Class App
public class App {
    // Main
    public static void main(String [] args){
        // Variable initialization
        paymentCalculator creditCard = new paymentCalculator();
        double balance, apr, monthlyPayment;

        // Functions from creditCard run
        balance = creditCard.setBalance();
        apr = creditCard.setAPR();
        monthlyPayment = creditCard.setMonthlyPayment();
        creditCard.printMonths(creditCard.calculateMonthsUntilPaidOff(balance, apr, monthlyPayment));
    }
}

// Class paymentCalculator
class paymentCalculator{
    static Scanner userInput = new Scanner(System.in);

    // Function calculateMonthsUntilPaidOff
    // Input: bal, rate, pay
    // Output: (calc1 * calc2) / calc3;
    // Calculates the months until the card is paid off
    public double calculateMonthsUntilPaidOff(double bal, double rate, double pay)
    {
        double calc1, calc2, calc3;
        calc1 = -(1.00/30.00);
        calc2 = Math.log(1 + (bal/pay) * (1 - Math.pow((1 + ((rate/100)/365.00)), 30)));
        calc3 = Math.log(1 + ((rate/100)/365.00));
        return (calc1 * calc2) / calc3;
    }

    // Function setBalance
    // Input: N/A
    // Output: userInput
    // Function takes user input
    public double setBalance(){
        System.out.printf("What is your balance? ");
        return userInput.nextDouble();
    }

    // Function setAPR
    // Input: N/A
    // Output: userInput
    // Function takes user input
    public int setAPR(){
        System.out.printf("What is the APR on the card (as a percent)? ");
        return userInput.nextInt();
    }

    // Function setMonthlyPayment
    // Input: N/A
    // Output: userInput
    // Function takes user input
    public double setMonthlyPayment(){
        System.out.printf("What is the monthly payment you can make? ");
        return userInput.nextDouble();
    }

    // Function printMonths
    // Input: months
    // Output: N/A
    // Function prints the result
    public void printMonths(double months){
        System.out.printf("It will take you %.0f months to pay off this card.", Math.ceil(months));
    }
}