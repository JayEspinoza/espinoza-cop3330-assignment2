package ex34;
import java.util.Scanner;
import java.util.ArrayList;

public class base {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        ArrayList employee = createList();
        listManipulation list = new listManipulation();
        String input;

        list.printList(employee);
        input = userStep();
        list.removeEmployee(input, employee);
        System.out.println();
        list.printList(employee);
    }

    static ArrayList createList(){
        ArrayList<String> employee = new ArrayList<String>();

        employee.add("John Smith");
        employee.add("Jackie Jackson");
        employee.add("Chris Jones");
        employee.add("Amanda Cullen");
        employee.add("Jeremy Goodwin");

        return employee;
    }

    static String userStep(){
        System.out.printf("%nEnter an employee name to remove: ");
        return userInput.nextLine();
    }
}

class listManipulation{
    public void printList(ArrayList employee){
        System.out.printf("There are %d employees: %n", employee.size());

        for(int i = 0; i < employee.size(); i++)
            System.out.println(employee.get(i));
    }

    public void removeEmployee(String remove, ArrayList employee){
        for(int i = 0; i < employee.size(); i++){
            if((employee.get(i).equals(remove))){
                employee.remove(i);
                break;
            }
        }
    }
}
