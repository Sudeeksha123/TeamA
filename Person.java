public class Person {
    public boolean buyHouse;
    public String whatToDo;
    public boolean[] denialReason = new boolean[4];
    private int creditScore;
    private int monthlyIncome;
    private int creditCardPayment;
    private int studentLoanPayment;
    private int appraisedValue;
    private float loanAmount;
    private float monthlyMortgagePayment;
    private int carPayment;
    private float downPayment;


    public Person() {

    }

    public Person(int monthlyIncome, int creditCardPayment, int carPayment, int studentLoanPayment, int appraisedValue, float downPayment, float loanAmount, float monthlyMortgagePayment, int creditScore) {
        this.monthlyIncome = monthlyIncome;
        this.creditCardPayment = creditCardPayment;
        this.carPayment = carPayment;
        this.studentLoanPayment = studentLoanPayment;
        this.appraisedValue = appraisedValue;
        this.downPayment = downPayment;
        this.loanAmount = loanAmount;
        this.monthlyMortgagePayment = monthlyMortgagePayment;
        this.creditScore = creditScore;
        this.buyHouse = true;
        this.whatToDo = "";
        this.denialReason = new boolean[]{false,false,false,false};
        this.checkCreditScore();
        this.checkDebtToIncomeRatio();
        this.checkLoanToValue();
        this.checkFrontEndDebtToIncome();
    }

    private void checkLoanToValue() {
        float result = 1 - (float) ((downPayment * 1.0) / appraisedValue);
        if (result < .8) {
            return;
        } else {
            whatToDo = whatToDo + "increase down payment\n";
            buyHouse = false;
            denialReason[0] = true;
            return;
        }
    }

    private void checkDebtToIncomeRatio() {
        float debt = carPayment + creditCardPayment + monthlyMortgagePayment + studentLoanPayment;
        float cdiRatio = (float) (debt) / monthlyIncome;
        float mortgageDTI = (float) (monthlyMortgagePayment) / monthlyIncome;
        if (0.28 < mortgageDTI) {
            buyHouse = false;
            denialReason[1] = true;
            return; // more than 28% of that debt is going towards servicing a mortgage
        }
        if (cdiRatio > 0.36) {
            buyHouse = false;
            denialReason[1] = true;
            whatToDo = whatToDo + "pay off loans\n";
            return;
        }
        return;
    }

    private void checkFrontEndDebtToIncome() {
        float fedtiRatio = (float) (monthlyMortgagePayment) / monthlyIncome;
        if (fedtiRatio > 28) {
            denialReason[2] = true;
            whatToDo = whatToDo + "refinance mortgage\n";
            buyHouse = false;
            return;
        }
    }

    private void checkCreditScore() {
        if (creditScore < 640) {
            denialReason[3] = true;
            buyHouse = false;
            return;
        }
    }
}
