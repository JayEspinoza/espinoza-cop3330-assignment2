package ex29;
import java.util.Scanner;
import java.lang.Character;

public class base {
    public static void main(String [] args){
        investment myInvestment = new investment();
        System.out.printf("It will take %.0f years to double your initial investment.", myInvestment.getMonths());
    }
}

class investment{
    static Scanner userInput = new Scanner(System.in);
    private String rate;
    private double months;

    public investment(){
        setRate();
        setMonths();
    }

    public void setMonths(){
        months = 72/Double.parseDouble(rate);
    }

    public void setRate(){
        System.out.printf("What is the rate of return? ");
        rate = userInput.nextLine();
        validateRate();
    }

    private void validateRate() {
        char[] check = rate.toCharArray();
        int invalidChar = 0;

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
}

