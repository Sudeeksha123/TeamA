import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        System.out.println("Please enter a file name");
        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.nextLine();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }




    }
}
