package ex35;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        ArrayList<String> winnerList = genList();
        winner selection = new winner();

        System.out.printf(selection.selectWinner(winnerList));
    }

    static ArrayList<String> genList(){
        String input = "placeholder";
        ArrayList<String> people = new ArrayList<String>();

        while((!(input.equals("")))){
            System.out.printf("Enter a name: ");
            input = userInput.nextLine();
            people.add(input);
        }

        return people;
    }
}

class winner{
    static Random number = new Random();

    public String selectWinner(ArrayList people){
        int num = number.nextInt(people.size());
        return "The winner is..." + people.get(num);
    }
}
