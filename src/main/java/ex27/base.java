package ex27;
import java.util.Scanner;
import java.lang.Character;

public class base {
    public static void main(String [] args){
        employee myEmployee = new employee();
        myEmployee.printResults();
    }
}

class employee{
    static Scanner userInput = new Scanner(System.in);
    private String firstName, lastName, zipCode, employeeID, validation;

    public employee(){
        setFirstName();
        setLastName();
        setZip();
        setEmployeeId();
        validation = "";
        validateInput();
    }

    private void setFirstName(){
        System.out.printf("Enter the first name: ");
        firstName = userInput.nextLine();
    }

    private void setLastName(){
        System.out.printf("Enter the last name: ");
        lastName = userInput.nextLine();
    }

    private int validateName(String name){
        if (name.length() < 2 && name.equals("")){
            return 3;
        }else if(name.length() < 2 && !name.equals("")){
            return 2;
        }else if(name.equals("")){
            return 1;
        }

        return 0;
    }

    private void setZip(){
        System.out.printf("Enter the ZIP code: ");
        zipCode = userInput.nextLine();    }

    private boolean validateZip(){
        char [] check = zipCode.toCharArray();

        for(char c : check){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }

    private void setEmployeeId(){
        System.out.printf("Enter the employee ID: ");
        employeeID = userInput.nextLine();
    }

    private boolean validateEmployeeId(){
        char [] check = employeeID.toCharArray();

        if(!Character.isAlphabetic(check[0]) || !Character.isAlphabetic(check[1])){
            return false;
        }else if(check[2] != '-'){
            return false;
        }

        for(int i = 3; i < check.length; i++){
            if(!Character.isDigit(check[i])){
                return false;
            }
        }

        return true;
    }

    public void validateInput(){
        int counter = 0;

        if(validateName(firstName) != 0){
            counter++;

            if(validateName(firstName) == 2){
                validation += "The first name must be at least 2 characters long.\n";
            }else if(validateName(firstName) == 1){
                validation += "The first name must be filled in.\n";
            }else if(validateName(firstName) == 3){
                validation += "The first name must be at least 2 characters long.\nThe first name must be filled in.\n";
            }
        }

        if(validateName(lastName) != 0){
            counter++;

            if(validateName(lastName) == 2){
                validation += "The last name must be at least 2 characters long.\n";
            }else if(validateName(lastName) == 1){
                validation += "The last name must be filled in.\n";
            }else if(validateName(lastName) == 3){
                validation += "The last name must be at least 2 characters long.\nThe last name must be filled in.\n";
            }
        }

        if(!validateEmployeeId()){
            counter++;
            validation += "The employee ID must be in the format of AA-1234.\n";
        }

        if(!validateZip()){
            counter++;
            validation += "The zipcode must be a 5 digit number.\n";
        }

        if(counter == 0){
            validation += "There were no errors found.\n";
        }
    }

    public void printResults(){
        System.out.printf("%s", validation);
    }

}