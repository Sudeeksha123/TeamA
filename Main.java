import java.io.File;
import java.io.FileNotFoundException;
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
                if (file.hasNextLine()) {
                    file.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
    }
}
