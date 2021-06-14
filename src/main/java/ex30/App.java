package ex30;

public class App {
    public static void main(String [] args){
        multTable myTable = new multTable();
        myTable.genTable();
    }
}

class multTable{
    public void genTable(){
        for(int i = 1; i <= 12; i++){
            for(int t = 1; t <= 12; t++){
                System.out.printf("%4d ", i*t);
            }
            System.out.print("\n");
        }
    }

}