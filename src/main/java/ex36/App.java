package ex36;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        ArrayList<Integer> numbers = userStep();
        Calculations calc = new Calculations();

        System.out.printf("The average is %.2f%nThe minimum id %d%nThe maximum is %d%nThe standard deviation is %.2f", calc.average(numbers), calc.min(numbers), calc.max(numbers), calc.std(numbers));
    }

    static ArrayList<Integer> userStep(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        String input = "";
        System.out.printf("Enter the response time in milliseconds.%n");

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

    static int validateInput(String input) {
        char[] check = input.toCharArray();
        int invalidChar = 0;

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

class Calculations{
    public double average(ArrayList<Integer> numbers){
        double combined = 0;

        for(int i = 0; i < numbers.size(); i++){
            combined += numbers.get(i);
        }

        return combined/(double)numbers.size();
    }

    public int min(ArrayList<Integer> numbers){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < numbers.size(); i++){
            if(min > numbers.get(i))
                min = numbers.get(i);
        }

        return min;
    }

    public int max(ArrayList<Integer> numbers){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < numbers.size(); i++){
            if(max < numbers.get(i))
                max = numbers.get(i);
        }

        return max;
    }

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
