/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex34;
import java.util.Scanner;
import java.util.ArrayList;

// Class App
public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main
    public static void main(String [] args){
        // Variable initialize
        ArrayList employee = createList();
        listManipulation list = new listManipulation();
        String input;

        // Print results
        list.printList(employee);
        input = userStep();
        list.removeEmployee(input, employee);
        System.out.println();
        list.printList(employee);
    }

    // Function createList
    // Input: N/A
    // Output: ArrayList<String> employee
    // Function creates a new ArrayList and
    // returns it
    static ArrayList createList(){
        ArrayList<String> employee = new ArrayList<String>();

        employee.add("John Smith");
        employee.add("Jackie Jackson");
        employee.add("Chris Jones");
        employee.add("Amanda Cullen");
        employee.add("Jeremy Goodwin");

        return employee;
    }

    // Function userStep
    // Input: N/A
    // Output: user input
    // Function takes user input
    static String userStep(){
        System.out.printf("%nEnter an employee name to remove: ");
        return userInput.nextLine();
    }
}

// Class listManipulation
class listManipulation{
    // Function printList
    // Input: N/A
    // Output: N/A
    // Prints employees
    public void printList(ArrayList employee){
        System.out.printf("There are %d employees: %n", employee.size());

        // For loop prints all employees in list
        for(int i = 0; i < employee.size(); i++)
            System.out.println(employee.get(i));
    }

    // Function removeEmployee
    // Input: String remove, ArrayList employee
    // Output: N/A
    // Function loops through the list until the
    // employee is found and removes it
    public void removeEmployee(String remove, ArrayList employee){
        for(int i = 0; i < employee.size(); i++){
            if((employee.get(i).equals(remove))){
                employee.remove(i);
                break;
            }
        }
    }
}
