package com.budget.tool;

public class BudgetCandidates  {

  public static final double EMRGENCY_FUND_CONSTANT = 0.10;
  public static final double SAVINGS_CONSTANT = 0.15;
  public static final double MISCELLENAOUS_CONSTANT = 0.40;
  public static final double FOOD_CONSTANT = 0.25;

  //fields
  double income;
  double debt;
  double debtplusExpenses;
  double budgetAmount;

  public BudgetCandidates(double income, double debt) {
    this.income = income;
    this.debt = debt;
  }


  Debt debt = new Debt();
  public double getDebt() {
    return debt;
  }

  public void setDebt(double debt) {
    this.debtplusExpenses = debt;
  }

  public double budgetAmount() {
    budgetAmount = Math.abs(debtplusExpenses - income);
    return budgetAmount;
  }

  //Business Methods
  //Method to calculate recommended amount for emergency fund
  public Object calculateEmergencyFund(){
    double amount = budgetAmount() * EMRGENCY_FUND_CONSTANT;
    return amount;

  }
  //Method to calculate recommended amount for savings
  public Object calculateSavings(){
    double amount = budgetAmount() * SAVINGS_CONSTANT;
    return amount;
  }
  //Method to calculate recommended amount for miscellaneous
  public Object calculateMiscellanous(){
    double amount = budgetAmount() * MISCELLENAOUS_CONSTANT;
    return amount;
  }
  //Method to calculate recommended amount for food
  public Object calculateFoodBudget(){
    double amount = budgetAmount() * FOOD_CONSTANT;
    return amount;
  }


}


