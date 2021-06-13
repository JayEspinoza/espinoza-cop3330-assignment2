package ex26;
import java.util.Scanner;
import java.lang.Math;

public class base {
    public static void main(String [] args){
        paymentCalculator creditCard = new paymentCalculator();
        creditCard.printMonths();
    }
}

class paymentCalculator{
    static Scanner userInput = new Scanner(System.in);

    private double balance, monthlyPayment, dailyRate, months;

    public paymentCalculator(){
        balance = setBalance();
        dailyRate = ((double) setAPR())/365.00;
        monthlyPayment = setMonthlyPayment();
        months = calculateMonthsUntilPaidOff();
    }

    public double calculateMonthsUntilPaidOff()
    {
        double calc;
        calc = -(1.00/30.00) * Math.log(1.00 + balance/monthlyPayment * (1.00 - Math.pow((1.00-dailyRate), 30))) / Math.log(1.00 + dailyRate);
        return calc;
    }

    private double setBalance(){
        System.out.printf("What is your balance? ");
        return userInput.nextDouble();
    }

    private int setAPR(){
        System.out.printf("What is the APR on the card (as a percent)? ");
        return userInput.nextInt();
    }

    private double setMonthlyPayment(){
        System.out.printf("What is the monthly payment you can make? ");
        return userInput.nextDouble();
    }

    public void printMonths(){
        System.out.printf("It will take you %.1f months to pay off this card.", months);
    }
}