import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String []args){
        System.out.println("Please enter a file name");
        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.nextLine();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
            file.nextLine();
            HashMap<Integer, Person> homeOwnerMap = new HashMap<>();
            while(file.hasNext())
            {
            int id = file.nextInt();
            int monthlyIncome = file.nextInt();
            int creditCardPayment = file.nextInt();
            int carPayment = file.nextInt();
            int studentLoanPayments = file.nextInt();
            int appraisedValue = file.nextInt();
            float downPayment = file.nextFloat();
            float loanPayment = file.nextFloat();
            float monthlyMortgagePayment = file.nextFloat();
            int creditScore = file.nextInt();
            Person homeOwner = new Person(monthlyIncome, creditCardPayment, carPayment, studentLoanPayments, appraisedValue, downPayment, loanPayment, monthlyMortgagePayment, creditScore);
            homeOwnerMap.put(id, homeOwner);
            
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }
        
        




    }
}
