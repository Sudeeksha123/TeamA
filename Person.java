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
    private boolean buyHouse;

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
        this.buyHouse = false;
    }

    private boolean checkDebtToIncomeRatio() {
        float debt = carPayment + creditCardPayment + monthlyMortgagePayment;
        float cdiRatio = (float) (debt) / monthlyIncome;
        float mortgageDTI = (float) (monthlyMortgagePayment) / monthlyIncome;
        if (0.28 < mortgageDTI) {
            return false; // more than 28% of that debt is going towards servicing a mortgage
        }
        return cdiRatio <= 0.36;
    }

    private boolean checkFrontEndDebtToIncome() {
        float fedtiRatio = (float) (monthlyMortgagePayment) / monthlyIncome;
        return fedtiRatio <= 0.28;
    }
}
