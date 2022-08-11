package com.dng;

/**
 * This class is responsible for giving suggestions as to where to allocate any money available for
 * budgeting.
 */

public class BudgetItem {

  //TODO Create constants for Good standing as well as Closer to threshhold using 50/30/20
  public static final double EMRGENCY_FUND_CONSTANT = 0.10;
  public static final double SAVINGS_CONSTANT = 0.30;
  public static final double MISCELLENAOUS_CONSTANT = 0.10;
  public static final double FOOD_CONSTANT = 0.05;


  public static final double EMRGENCY_FUND_CONSTANT_GS = 0.10;
  public static final double SAVINGS_CONSTANT_GS = 0.10;
  public static final double MISCELLENAOUS_CONSTANT_GS = 0.30;
  public static final double FOOD_CONSTANT_GS = 0.05;


  //fields..
  double income;
  double debt;
  double debtplusExpenses;
  double budgetAmount;
  double beforeBudget;

  /**
   * This constructor initializes the instances of this class.
   *
   * @param income the user's monthly salary
   * @param debt   the user's total monthly expenses
   */

  public BudgetItem(double income, double debt) {
    this.income = income;
    this.debt = debt;
  }

  public BudgetItem() {

  }

  public double getBeforeBudget() {
    return beforeBudget;
  }

  public void setBeforeBudget(double beforeBudget) {
    this.beforeBudget = beforeBudget;
  }

  public double getDebt() {
    return debt;
  }

  public void setDebt(double debt) {
    this.debt = debt;
  }

  /**
   * This method calculates the amount the user has available for budgeting.
   */
  public double budgetAmount() {
    budgetAmount = (0.50*(income) - debt);
    return budgetAmount;
  }

  //Business Methods
  //Method to calculate recommended amount for emergency fund
  public Object calculateEmergencyFund() {
    return budgetAmount() * EMRGENCY_FUND_CONSTANT;

  }

  //Method to calculate recommended amount for savings
  public Object calculateSavings() {
    return budgetAmount() * SAVINGS_CONSTANT;
  }

  //Method to calculate recommended amount for miscellaneous
  public Object calculateMiscellanous() {
    return budgetAmount() * MISCELLENAOUS_CONSTANT;
  }

  //Method to calculate recommended amount for food
  public Object calculateFoodBudget() {
    return budgetAmount() * FOOD_CONSTANT;
  }


  public Object calculateEmergencyFundG() {
    return budgetAmount() * EMRGENCY_FUND_CONSTANT_GS;

  }

  //Method to calculate recommended amount for savings
  public Object calculateSavingsG() {
    return budgetAmount() * SAVINGS_CONSTANT_GS;
  }

  //Method to calculate recommended amount for miscellaneous
  public Object calculateMiscellanousG() {
    return budgetAmount() * MISCELLENAOUS_CONSTANT_GS;
  }

  //Method to calculate recommended amount for food
  public Object calculateFoodBudgetG() {
    return budgetAmount() * FOOD_CONSTANT_GS;
  }


}
