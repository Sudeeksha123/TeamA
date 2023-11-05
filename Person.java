public class Person {
    private int creditScore;
    private int monthlyIncome;
    private int creditCardPayment;
    private int studentLoanPayment;
    private int appraisedValue;
    private int loanAmount;
    private int monthlyMortgagePayment;
    private int carPayment;
    private int downPayment;
    public boolean buyHouse;
    public String whatToDo;


    public Person() {

    }
    public Person(int monthlyIncome, int creditCardPayment, int carPayment, int studentLoanPayment, int appraisedValue, int downPayment, int loanAmount, int monthlyMortgagePayment, int creditScore){
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

    }
    private boolean checkLoanToValue(){
        float result = (float) ((downPayment*1.0)/appraisedValue);
        if (result < .8){
            return true;
        }
        else {
            whatToDo = whatToDo + "increase down payment\n";
            buyHouse = false;
            return false;
        }
    }

    private boolean checkDebtToIncomeRatio() {
        float debt = carPayment + creditCardPayment + monthlyMortgagePayment;
        float cdiRatio = (float) (debt) / monthlyIncome;
        float mortgageDTI = (float) (monthlyMortgagePayment) / monthlyIncome;
        if (0.28 < mortgageDTI) {
            buyHouse = false;
            return false; // more than 28% of that debt is going towards servicing a mortgage
        }
        return cdiRatio <= 0.36;
    }

    private boolean checkFrontEndDebtToIncome() {
        float fedtiRatio = (float) (monthlyMortgagePayment) / monthlyIncome;
        return fedtiRatio <= 0.28;
    }
}
