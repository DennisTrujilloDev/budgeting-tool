package com.dng;

/**
 * This class is responsible for giving suggestions as to where to allocate any money available for budgeting.
 */
public class BudgetItem {

  private static final double EMERGENCY_FUND = 0.10;
  private static final double SAVINGS = 0.15;
  private static final double MISCELLANEOUS = 0.40;
  private static final double FOOD = 0.35;

  //fields..
  private final double income;
  private final double debt;
  private double amount;

//  double debtplusExpenses;

  /**
   * This constructor initializes the instances of this class.
   * @param income the user's monthly salary
   * @param totalExpenses the user's total monthly expenses
   */
  public BudgetItem(double income, double totalExpenses) {
    this.income = income;
    this.debt = totalExpenses;
  }

//  public BudgetItem() {
//
//  }

//  public double getDebt() {
//    return debt;
//  }
//  public void setDebt(double debt) {
//    this.debt = debt;
//  }

  /**
   * This method calculates the amount the user has available for budgeting.
   */
  public double budgetAmount() {
//    double budgetAmount = (income- debt);
//    return budgetAmount;
    return (income - debt);
  }

  /**
   * This method calculates the recommended amount to allocate towards an emergency fund.
   */
  public Object calculateEmergencyFund(){
    amount = budgetAmount() * EMERGENCY_FUND;
    return amount;

  }

  /**
   * This method calculates the recommended amount to allocate towards a savings account.
   */
  public Object calculateSavings(){
    amount = budgetAmount() * SAVINGS;
    return amount;
  }

  /**
   * This method calculates the recommended amount to allocate to miscellaneous expenses.
   */
  public Object calculateMiscellaneous(){
    amount = budgetAmount() * MISCELLANEOUS;
    return amount;
  }

  /**
   * This method calculates the recommended amount to allocate towards groceries.
   */
  public Object calculateFoodBudget(){
    amount = budgetAmount() * FOOD;
    return amount;
  }


}

