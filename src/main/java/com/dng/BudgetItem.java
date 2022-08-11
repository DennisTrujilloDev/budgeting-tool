package com.dng;

/**
 * This class is responsible for giving suggestions as to where to allocate any money available for budgeting.
 */
public class BudgetItem {

  private static final double EMERGENCY_FUND = 0.10;
  private static final double SAVINGS = 0.15;
  private static final double MISCELLANEOUS = 0.40;
  private static final double FOOD = 0.35;
  private final double income;
  private final double debt;

  /**
   * This constructor initializes the instances of this class.
   * @param income the user's monthly salary
   * @param totalExpenses the user's total monthly expenses
   */
  public BudgetItem(double income, double totalExpenses) {
    this.income = income;
    this.debt = totalExpenses;
  }

  /**
   * This method calculates the amount the user has available for budgeting.
   * @return the calculation as a double
   */
  public double budgetAmount() {
    return (income - debt);
  }

  /**
   * This method calculates the recommended amount to allocate towards an emergency fund.
   * @return an object representation of the calculation.
   */
  public Object calculateEmergencyFund(){
    return budgetAmount() * EMERGENCY_FUND;
  }

  /**
   * This method calculates the recommended amount to allocate towards a savings account.
   *@return an object representation of the calculation.
   */
  public Object calculateSavings(){
    return budgetAmount() * SAVINGS;
  }

  /**
   * This method calculates the recommended amount to allocate to miscellaneous expenses.
   * @return an object representation of the calculation.
   */
  public Object calculateMiscellaneous(){
    return budgetAmount() * MISCELLANEOUS;
  }

  /**
   * This method calculates the recommended amount to allocate towards groceries.
   * @return an object representation of the calculation
   */
  public Object calculateFoodBudget(){
    return budgetAmount() * FOOD;
  }

}

