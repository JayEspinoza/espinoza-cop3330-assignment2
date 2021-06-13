package ex25;
import java.util.Scanner;

public class base {
    static Scanner userInput = new Scanner(System.in);

    static String userStep(){
        String input;

        System.out.printf("Enter a password: ");
        input = userInput.nextLine();

        return input;
    }

    static void output(String password, String strength){
        System.out.printf("The password '%s' is a %s.", password, strength);
    }

    public static void main(String [] args){
        passwordKeeper password = new passwordKeeper(userStep());
        output(password.getPassword(), password.getStrength());
    }
}

class passwordKeeper {
    String password;
    String strength;

    public passwordKeeper(String input){
        password = input;
        strength = passwordValidator();
    }

    public String getPassword(){
        return password;
    }

    public String getStrength(){
        return strength;
    }

    private String passwordValidator(){
        int [] strengthArray = strengthCheck(password);

        if(password.length() < 8){
            if((strengthArray[1] > 0 && strengthArray[0] == 0 && strengthArray[2] == 0)){
                return "very weak password";
            }else if(strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] == 0){
                return "weak password";
            }
        }else if((strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] == 0)){
            return "strong password";
        }else if(strengthArray[0] > 0 && strengthArray[1] > 0 && strengthArray[2] > 0){
            return "very strong password";
        }

        return "N/A";
    }

    private int [] strengthCheck(String password){
        int [] strength = new int [3];

        for(int i = 0; i < password.length(); i++){
            if ((int)password.charAt(i) >= 97 && (int)password.charAt(i) <= 122) {
                strength[0]++;
            }else if((int)password.charAt(i) >= 65 && (int)password.charAt(i) <= 90) {
                strength[0]++;
            }else if((int)password.charAt(i) >= 48 && (int)password.charAt(i) <= 57){
                strength[1]++;
            }else{
                strength[2]++;
            }
        }

        return strength;
    }
}
