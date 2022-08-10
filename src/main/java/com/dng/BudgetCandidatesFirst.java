package com.dng;


//I think in the business methods below we can get rid of "Object"
//and write the method's return type instead

public class BudgetCandidatesFirst {

  public static final double EMERGENCY_FUND_CONSTANT = 0.10;
  public static final double SAVINGS_CONSTANT = 0.15;
  public static final double MISCELLANEOUS_CONSTANT = 0.40;
  public static final double FOOD_CONSTANT = 0.25;

  //fields
  double income;
//  Debt debt;
  double debtplusExpenses;
  double budgetAmount;

//  public BudgetCandidates(double income, Debt debt) {
//    this.income = income;
//    this.debt = debt;
//  }

//  public Debt getDebt() {
//    return debt;
//  }

  public void setDebt(double debt) {
    this.debtplusExpenses = debt;
  }

  public double budgetAmount() {
    budgetAmount = Math.abs(debtplusExpenses - income);
    return budgetAmount;
  }

  //Business Methods
  //Method to calculate recommended amount for emergency fund
  public Object calculateEmergencyFund() {
    double amount = budgetAmount() * EMERGENCY_FUND_CONSTANT;
    return amount;

  }

  //Method to calculate recommended amount for savings
  public Object calculateSavings() {
    double amount = budgetAmount() * SAVINGS_CONSTANT;
    return amount;
  }

  //Method to calculate recommended amount for miscellaneous
  public Object calculateMiscellanous() {
    double amount = budgetAmount() * MISCELLANEOUS_CONSTANT;
    return amount;
  }

  //Method to calculate recommended amount for food
  public Object calculateFoodBudget() {
    double amount = budgetAmount() * FOOD_CONSTANT;
    return amount;
  }


  void availableBudgetNotification() {

//    if (UserInput.getTotalAvailableBudget() < 0) {
//      //proly have to add class name before the property name
//      System.out.println("You are at risk of falling into debt; please see a financial advisor.");
//    } else if (totalAvailableBudget < 1000) {
//      System.out.println(
//          "You may need to cut down on your expenses. We recommend downloading an app to help keep track of — and minimize — your miscellaneous expenses.");
//    } else {
//      System.out.println("Great job budgeting! Keep it up!");
//    }
//  }

//    private void leftoverMoneyAfterBudgeting(EMERGENCY_FUND_CONSTANT, SAVINGS_CONSTANT, MISCELLANEOUS_CONSTANT, FOOD_CONSTANT) {
//      double leftovers = 100 - (
//          (EMERGENCY_FUND_CONSTANT + SAVINGS_CONSTANT + MISCELLANEOUS_CONSTANT + FOOD_CONSTANT)
//              * 100);
//      System.out.printf("We suggest investing the remaining %f%n in the stock market", leftovers);
//    }

  }
}

