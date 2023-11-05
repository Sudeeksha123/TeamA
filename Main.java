import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner file = null;
        float numBuy = 0;
        float numNoBuyLVT = 0;
        float numNoBuyDTI = 0;
        float numNoBuyFEDTI = 0;
        float numNoBuyCreditScore = 0;
        float numNoBuyMortgagePortionHigh = 0;
        float numCustomers = 0;
        try {
            file = new Scanner(new File("HackUTD-2023-HomeBuyerInfo.txt"));
            file.nextLine();
            HashMap<Integer, Person> homeOwnerMap = new HashMap<>();
            PrintWriter write = new PrintWriter("output.txt");
            while (file.hasNext()) {
                numCustomers++;
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
                if (homeOwner.buyHouse) {
                    numBuy++;
                } else {
                    if (homeOwner.denialReason[0]) {
                        numNoBuyLVT++;
                    }
                    if (homeOwner.denialReason[1]) {
                        numNoBuyDTI++;
                    }
                    if (homeOwner.denialReason[2]) {
                        numNoBuyFEDTI++;
                    }
                    if (homeOwner.denialReason[3]) {
                        numNoBuyCreditScore++;
                    }
                    if (homeOwner.denialReason[4]) {
                        numNoBuyMortgagePortionHigh++;
                    }
                }
                write.print("Customer ID number: ");
                write.println(id);
                if(homeOwner.buyHouse){
                    write.println("This customer is ready to buy a home");
                }
                else {
                    write.println("This customer is not ready to buy a home.");
                }
                write.print("Reasons: ");
                write.println(homeOwner.whatToDo);
                write.println("---------------------------------");
                if (file.hasNextLine()) {
                    file.nextLine();
                }
            }
            write.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

    }
}
