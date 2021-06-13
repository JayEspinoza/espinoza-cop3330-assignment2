package ex24;
import java.util.Scanner;

public class base {
    static Scanner userInput = new Scanner(System.in);

    public void isAnagram(String wordOne, String wordTwo){
        if(wordOne.length() != wordTwo.length()){
            System.out.printf("\"%s\" and \"%s\" are not anagrams.", wordOne, wordTwo);
            return;
        }

        int [] tableOne = tableCreation(wordOne);
        int [] tableTwo = tableCreation(wordTwo);

        for(int i : tableOne){
            if(tableOne[i] != tableTwo[i]){
                System.out.printf("\"%s\" and \"%s\" are not anagrams.", wordOne, wordTwo);
                return;
            }
        }

        System.out.printf("\"%s\" and \"%s\" are anagrams.", wordOne, wordTwo);
        return;
    }

    public int [] tableCreation(String word){
        int [] splitWord = new int[24];

        for(int i = 0; i < word.length(); i++){
            splitWord[(int)word.charAt(i) - (int)'a']++;
        }

        return splitWord;
    }

    public String userStep(String placement){
        String input;

        System.out.printf("Enter the %s string: ", placement);
        input = userInput.nextLine();

        return input;
    }

    public static void main(String [] args)
    {
        base myBase = new base();
        String wordOne, wordTwo;

        System.out.printf("Enter two strings and I'll tell you if they are anagrams:%n");
        wordOne = myBase.userStep("first");
        wordTwo = myBase.userStep("second");

        myBase.isAnagram(wordOne, wordTwo);
    }
}
