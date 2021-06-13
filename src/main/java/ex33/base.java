package ex33;
import java.util.Random;
import java.util.Scanner;

public class base {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        ball magicEight = new ball();

        System.out.printf("What's your question?%n> ");
        setUserInput();
        System.out.printf("%s", magicEight.returnResult());
    }

    static String setUserInput(){
        return userInput.nextLine();
    }
}

class ball{
    private Random gen = new Random();
    private int num;

    public ball(){
        num = gen.nextInt(4) + 1;
    }

    public String returnResult(){
        switch(num){
            case 1:
                return "Yes";
            case 2:
                return "No";
            case 3:
                return "Maybe";
            default:
                return "Ask again later";
        }
    }
}