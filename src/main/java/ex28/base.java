package ex28;
import java.util.Scanner;

public class base {
    public static void main(String [] args){
        numbers myNumbers = new numbers();
        System.out.printf("The total is %d.", myNumbers.getTotal());
    }
}

class numbers{
    static Scanner userInput = new Scanner(System.in);
    private int total;

    public numbers(){
        generateTotal();
    }

    public void generateTotal(){
        for(int i = 0; i < 5; i++){
            total += numberInput();
        }
    }

    private int numberInput(){
        System.out.printf("Enter a number: ");
        return userInput.nextInt();
    }

    public int getTotal(){
        return total;
    }
}
