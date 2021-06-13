package ex32;
import java.util.Scanner;
import java.util.Random;

public class base {

    public static void main(String [] args){
        System.out.printf("Let's play Guess the Number!%n%n");
        number game = new number();
        game.guess();
    }
}


class number {
    static Scanner userInput = new Scanner(System.in);
    private int answer;
    private int guesses;
    private Random rand = new Random();


    public number() {
        generateNumber();
        guesses = 0;
    }

    public void generateNumber() {
        int difficulty = setDiff();
        if (difficulty == 1) {
            answer = rand.nextInt(10) + 1;
        } else if (difficulty == 2) {
            answer = rand.nextInt(100) + 1;
        } else {
            answer = rand.nextInt(1000) + 1;
        }
    }

    private void guessIncrement() {
        guesses++;
    }

    private int setDiff() {
        System.out.printf("Enter the difficulty level (1, 2, 3): ");
        return Integer.parseInt(validateDifficulty(userInput.nextLine()));
    }

    private String validateDifficulty(String input) {
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
            if ((Integer.parseInt(input) == 1) || (Integer.parseInt(input) == 2) || (Integer.parseInt(input) == 3)) {
                invalidChar = 0;
            }else {
                System.out.println("Sorry. That is not a valid input.");
                invalidChar = 1;
            }
        }

        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Enter the difficulty level (1, 2, or 3): ");
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
                    if ((Integer.parseInt(input) == 1) || (Integer.parseInt(input) == 2) || (Integer.parseInt(input) == 3)) {
                        invalidChar = 0;
                    }else {
                        System.out.println("Sorry. That is not a valid input.");
                        invalidChar = 1;
                    }

                }
            }
        }

        return input;
    }

    public void guess() {
        System.out.printf("I have my number. What's your guess? ");
        guessIncrement();
        validateNum(userInput.nextLine());
    }


    private void validateNum(String input) {
        char[] check = input.toCharArray();
        int invalidChar = 0;

        for (char c : check) {
            if (!Character.isDigit(c)) {
                invalidChar = 1;
                System.out.println("Sorry. That is not a valid input.");
                guessIncrement();
                break;
            }
        }

        if (invalidChar != 1) {
            if (Integer.parseInt(input) > answer) {
                invalidChar = 1;
                System.out.println("Too high. ");
                guessIncrement();
            }

            if (Integer.parseInt(input) < answer) {
                invalidChar = 1;
                System.out.println("Too low. ");
                guessIncrement();
            }

        }


        if (invalidChar > 0) {
            while (invalidChar > 0) {
                System.out.printf("Guess again: ");
                input = userInput.nextLine();
                check = input.toCharArray();

                for (char c : check) {
                    if (!Character.isDigit(c)) {
                        invalidChar = 1;
                        System.out.println("Sorry. That is not a valid input.");
                        guessIncrement();
                        break;
                    }
                    invalidChar = 0;
                }

                if (invalidChar != 1) {
                    if (Integer.parseInt(input) > answer) {
                        invalidChar = 1;
                        System.out.println("Too high. ");
                        guessIncrement();
                    }

                    if (Integer.parseInt(input) < answer) {
                        invalidChar = 1;
                        System.out.println("Too low. ");
                        guessIncrement();
                    }
                }
            }
        }

        endGameSequence();
    }

    private void endGameSequence(){
        String choice;

        System.out.printf("You got it in %d guesses!%nWould you like to play again? ", guesses);
        choice = repeat();

        if(choice.equals("Y") || choice.equals("y")){
            generateNumber();
            guess();
        }
    }

    private String repeat(){
        return userInput.nextLine();
    }
}

