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

    public Person(){}
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
    }
}
