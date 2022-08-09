public class UserInputs {

  String name;
  String individualOrFamily;
  boolean isHomeowner;
  double rent;
  double mortgage;
  double annualIncome;
  double monthlyDeptPayment;
  double monthlyExpenses;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIndividualOrFamily() {
    return individualOrFamily;
  }

  public void setIndividualOrFamily(String individualOrFamily) {
    this.individualOrFamily = individualOrFamily;
  }

  public boolean getHomeowner() {
    return isHomeowner;
  }

  public boolean setHomeowner(String homeowner) {
    this.isHomeowner = isHomeowner;
    return false;
  }

  public double getRent() {
    return rent;
  }

  public void setRent(double rent) {
    this.rent = rent;
  }

  public double getMortgage() {
    return mortgage;
  }

  public void setMortgage(double mortgage) {
    this.mortgage = mortgage;
  }

  public double getAnnualIncome() {
    return annualIncome;
  }

  public void setAnnualIncome(double annualIncome) {
    this.annualIncome = annualIncome;
  }

  public double getMonthlyDeptPayment() {
    return monthlyDeptPayment;
  }

  public void setMonthlyDeptPayment(double monthlyDeptPayment) {
    this.monthlyDeptPayment = monthlyDeptPayment;
  }

  public double getMonthlyExpenses() {
    return monthlyExpenses;
  }

  public void setMonthlyExpenses(double monthlyExpenses) {
    this.monthlyExpenses = monthlyExpenses;
  }
}
