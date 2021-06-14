package ex31;

import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        int resting, age;
        resting = userStep("Resting Pulse");
        age = userStep("Age");
        heartRate myHeartRate = new heartRate(resting, age);
        myHeartRate.printRates(age, resting);
    }

    static int userStep(String mode){
        System.out.printf("Enter the %s: ", mode);
        return Integer.parseInt(validateRate(userInput.nextLine(), mode));
    }

    static String validateRate(String input, String mode) {
        char[] check = input.toCharArray();
        int invalidChar = 0;

        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                break;
            }
        }

        if (invalidChar != 1) {
            if(Integer.parseInt(input) == 0) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
            }
        }

        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Enter the %s: ", mode);
                input = userInput.nextLine();
                check = input.toCharArray();

                for (char c : check) {
                    if (!Character.isDigit(c)) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                        break;
                    }
                    invalidChar = 0;
                }

                if (invalidChar != 1) {
                    if(Integer.parseInt(input) == 0) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                    }
                }
            }
        }

        return input;
    }
}

class heartRate{
    double [] targetHeartRate = new double[9];

    public heartRate(int resting, int age){
        genRates(resting, age);
    }

    public void genRates(int resting, int age){
        for(int i = 0; i < 9; i++){
            targetHeartRate[i] = (((220 - age) - resting) * (((i*5.00) + 55.00)/100.00)) + resting;
        }
    }

    public void printRates(int age, int resting){
        System.out.printf("Resting pulse: %d \tAge: %d%n", resting, age);
        System.out.printf("Intensity\t| Rate%n------------|------%n");
        for(int i = 0; i < 9; i++){
            System.out.printf("%d%%\t\t\t| %.0f bpm\n", (((i) * 5) + 55), targetHeartRate[i]);
        }
    }

    public double [] getRates(){
        return targetHeartRate;
    }
}
