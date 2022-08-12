package com.dng;

/**
 * This class is responsible for giving suggestions as to where to allocate any money available for
 * budgeting.
 */

public class BudgetItem {

  private static final double EMERGENCY_FUND_CONSTANT = 0.2;
  private static final double SAVINGS_CONSTANT = 0.5;
  private static final double MISCELLANEOUS_CONSTANT = 0.2;
  private static final double FOOD_CONSTANT = 0.1;


  private static final double EMERGENCY_FUND_CONSTANT_GS = 0.2;
  private static final double SAVINGS_CONSTANT_GS = 0.2;
  private static final double MISCELLANEOUS_CONSTANT_GS = 0.5;
  private static final double FOOD_CONSTANT_GS = 0.1;

  private final double income;
  private final double debt;

  /**
   * This constructor initializes the instances of this class.
   *
   * @param income the user's monthly salary
   * @param totalExpenses the user's total monthly expenses
   */

  public BudgetItem(double income, double totalExpenses) {
    this.income = income;
    this.debt = totalExpenses;
  }

  /**
   * This method calculates the amount the user has available for budgeting.
   *
   * @return the calculation as a double
   */
  public double budgetAmount() {
    return income - debt;
  }

  /**
   * This method calculates the recommended amount for your average user to allocate towards an emergency fund.
   *
   * @return an object representation of the calculation.
   */
  public Object calculateEmergencyFund() {
    return budgetAmount() * EMERGENCY_FUND_CONSTANT;

  }

  /**
   * This method calculates the recommended amount for your average user to allocate towards a savings account.
   *
   * @return an object representation of the calculation.
   */
  public Object calculateSavings() {
    return budgetAmount() * SAVINGS_CONSTANT;
  }

  /**
   * This method calculates the recommended amount for your average user to allocate to miscellaneous expenses.
   *
   * @return an object representation of the calculation.
   */
  public Object calculateMiscellaneous() {
    return budgetAmount() * MISCELLANEOUS_CONSTANT;
  }

  /**
   * This method calculates the recommended amount for your average user to allocate towards groceries.
   *
   * @return an object representation of the calculation
   */
  public Object calculateFoodBudget() {
    return budgetAmount() * FOOD_CONSTANT;
  }

  /**
   * This method calculates the recommended amount to allocate towards an emergency fund (for users in good financial standing).
   *
   * @return an object representation of the calculation.
   */
  public Object calculateEmergencyFundG() {
    return budgetAmount() * EMERGENCY_FUND_CONSTANT_GS;

  }

  /**
   * This method calculates the recommended amount to allocate towards a savings account (for users in good financial standing).
   *
   * @return an object representation of the calculation.
   */
  public Object calculateSavingsG() {
    return budgetAmount() * SAVINGS_CONSTANT_GS;
  }

  /**
   * This method calculates the recommended amount to allocate to miscellaneous expenses(for users in good financial standing).
   *
   * @return an object representation of the calculation.
   */
  public Object calculateMiscellaneousG() {
    return budgetAmount() * MISCELLANEOUS_CONSTANT_GS;
  }

  /**
   * This method calculates the recommended amount to allocate towards groceries (for users in good financial standing).
   *
   * @return an object representation of the calculation
   */
  public Object calculateFoodBudgetG() {
    return budgetAmount() * FOOD_CONSTANT_GS;
  }


}
