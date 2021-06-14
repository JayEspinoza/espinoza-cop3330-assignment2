package ex33;
import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        magicEight magicEight = new magicEight();

        System.out.printf("What's your question?%n> ");
        setUserInput();
        System.out.printf("%s", magicEight.returnResult());
    }

    static String setUserInput(){
        return userInput.nextLine();
    }
}

class magicEight {
    private Random gen = new Random();
    private int num;

    public magicEight(){
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