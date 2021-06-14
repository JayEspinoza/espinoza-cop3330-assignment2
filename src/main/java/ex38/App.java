package ex38;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        String input = userStep();
        numFilter list = new numFilter();

        System.out.printf("The even numbers are %s.", list.filterList(list.arraySplit(input)));
    }

    static String userStep(){
        System.out.printf("Enter a list of numbers, separated by spaces: ");
        return userInput.nextLine();
    }
}

class numFilter{
    public numFilter(){

    }

    public String [] arraySplit(String initList){
        String [] postList = initList.split(" ");
        return postList;
    }

    public String filterList(String [] initList){
        String postList = "";
        for(String c : initList){
            if(Character.isDigit(c.charAt(0))){
                if(Integer.parseInt(c) % 2 == 0){
                    postList += (c + " ");
                }
            }
        }

        return postList;
    }
}