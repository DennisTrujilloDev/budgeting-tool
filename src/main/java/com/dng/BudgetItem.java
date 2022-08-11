package com.dng;

public class BudgetItem {

  //TODO Create constants for Good standing as well as Closer to threshhold using 50/30/20
  public static final double EMRGENCY_FUND_CONSTANT = 0.10;
  public static final double SAVINGS_CONSTANT = 0.05;
  public static final double MISCELLENAOUS_CONSTANT = 0.10;
  public static final double FOOD_CONSTANT = 0.05;


  public static final double EMRGENCY_FUND_CONSTANT_GS = 0.10;
  public static final double SAVINGS_CONSTANT_GS = 0.10;
  public static final double MISCELLENAOUS_CONSTANT_GS = 0.30;
  public static final double FOOD_CONSTANT_GS= 0.05;


  //fields..
  double income;
  double debt;
  double debtplusExpenses;
  double budgetAmount;


  public BudgetItem(double income, double debt) {
    this.income = income;
    this.debt = debt;
  }

  public BudgetItem() {

  }

  public double getDebt() {
    return debt;
  }
  public void setDebt(double debt) {
    this.debt = debt;
  }

  public double budgetAmount() {
    budgetAmount = (income- debt);
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


  public Object calculateEmergencyFundG(){
    double amount = budgetAmount() * EMRGENCY_FUND_CONSTANT_GS;
    return amount;

  }
  //Method to calculate recommended amount for savings
  public Object calculateSavingsG(){
    double amount = budgetAmount() * SAVINGS_CONSTANT_GS;
    return amount;
  }
  //Method to calculate recommended amount for miscellaneous
  public Object calculateMiscellanousG(){
    double amount = budgetAmount() * MISCELLENAOUS_CONSTANT_GS;
    return amount;
  }
  //Method to calculate recommended amount for food
  public Object calculateFoodBudgetG(){
    double amount = budgetAmount() * FOOD_CONSTANT_GS;
    return amount;
  }



}
