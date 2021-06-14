/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Julian Espinoza
 */
package ex30;

// Class App
public class App {
    // Main
    public static void main(String [] args){
        // Initialize variables
        multTable myTable = new multTable();
        myTable.genTable();
    }
}

// Class multTable
class multTable{
    // Function genTable
    // Input: N/A
    // Output: N/A
    // Function prints a 12 x 12 multiplication table
    public void genTable(){
        // Nested loops print tables
        for(int i = 1; i <= 12; i++){
            for(int t = 1; t <= 12; t++){
                System.out.printf("%4d ", i*t);
            }
            System.out.print("\n");
        }
    }

}