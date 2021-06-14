package ex37;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        passwordGen passwordKeeper = new passwordGen();
        int length, spec, num;

        length = userStep("What's the minimum length? ");
        spec = userStep("How many special characters? ");
        num = userStep("How many numbers? ");

        System.out.printf(passwordKeeper.passCreate(length, spec, num));
    }

    static int userStep(String mode){
        String input;
        System.out.printf("%s ", mode);
        input = userInput.nextLine();

        return Integer.parseInt(validateRate(input, mode));
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
                System.out.printf("%s ", mode);
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

class passwordGen{
    private ArrayList<String> charList = new ArrayList<String>();
    private ArrayList<String> numList = new ArrayList<String>();
    private ArrayList<String> specList = new ArrayList<String>();

    public passwordGen(){
        charList.add("B");
        charList.add("z");
        charList.add("a");
        charList.add("P");
        charList.add("o");
        charList.add("A");
        charList.add("o");
        charList.add("y");
        charList.add("q");
        charList.add("i");
        charList.add("m");
        charList.add("M");
        charList.add("P");
        charList.add("p");
        charList.add("y");
        charList.add("h");

        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");
        numList.add("5");
        numList.add("6");
        numList.add("7");
        numList.add("8");
        numList.add("9");
        numList.add("0");

        specList.add("!");
        specList.add("?");
        specList.add("`");
        specList.add("-");
        specList.add("=");
        specList.add("#");
    }

    public String passCreate(int length, int spec, int num){
        Random gen = new Random();
        int random, letters;
        letters = length - spec - num;
        String password = "";

        for(int i = 0; i < length; i++){
            random = gen.nextInt(3) + 1;

            if(random == 3 && spec != 0){
                password += specList.get(gen.nextInt(specList.size()));
                spec--;
            }else if(random == 2 && num != 0){
                password += numList.get(gen.nextInt(numList.size()));
                num--;
            }else if(letters != 0){
                password += charList.get(gen.nextInt(charList.size()));
                letters--;
            }else{
                if(spec != 0){
                    password += specList.get(gen.nextInt(specList.size()));
                    spec--;
                }else if(num != 0){
                    password += numList.get(gen.nextInt(numList.size()));
                    num--;
                }
            }
        }

        return password;
    }
}