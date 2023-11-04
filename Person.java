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
        this.buyHouse = false;

    }
    private boolean checkLoanToValue(){
        float result = (float) ((downPayment*1.0)/appraisedValue);
        if (result < .8){
            return true;
        }
        else {
            whatToDo = whatToDo + "increase down payment\n";
            return false;
        }
    }
    private boolean checkFrontEndDebtToIncome() {
        float fedtiRatio = (float) (monthlyMortgagePayment) / monthlyIncome;
        return fedtiRatio <= 0.28;
    }
}
