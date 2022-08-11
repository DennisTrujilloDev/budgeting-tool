package com.dng;

public class BudgetCandidates {

  BudgetItem budget = new BudgetItem();

  /**
   * This method is used to calculate the total amount the user has available for budgeting every month by subtracting total expenses from income.
   * @param userInput
   */
  public static void adviseUser(UserInput userInput) {
    Double totalDebt = userInput.getProfile().getTotalMonthlyDebtPayment();
    Double income = userInput.getProfile().getMonthlyIncome();
    System.out.println("budget:" + (income- totalDebt));
  }
////
////  private static void giveBudgetAdvice(Double monthlyIncome, Double totalAvailableBudget) {
////
////
////    if(totalAvailableBudget <= 0) {
////      //TO-DO
////      System.out.println("Total Available Budget less than 0. You will need to think hard on how to manage your money.");
////    }
////    else if (totalAvailableBudget <= monthlyIncome * 0.20) {
////      System.out.println("f budget amount is less than a certain threshold,  \n"
////          + "Issue a warning about overspending and maybe cutting down on miscellaneous expenses.\n"
////          + "Also, give advise on getting an extra source of income to supplement their current income.");
////    }
////    else {
////      System.out.println("You are on the right track!");
////    }
////  }
////
////  private static Double calculateAvailableBudget(boolean isHomeOwner, Double monthlyIncome,
////      Double totalMonthlyDebtPayment, Double totalMonthlyExpenses, Double monthlyRent, Double monthlyMortgage) {
////
////    double totalAvailableBudget = 0.0;
////    if(isHomeOwner) {
////      totalAvailableBudget = (monthlyIncome - (totalMonthlyDebtPayment -
////          totalMonthlyExpenses - monthlyMortgage));
////    }
////    else {
////      totalAvailableBudget = (monthlyIncome - (totalMonthlyDebtPayment -
////          totalMonthlyExpenses - monthlyRent));
////    }
//////    System.out.println("Total Available Amount for Budgeting Each Month: " + totalAvailableBudget);
////
////    return totalAvailableBudget;
////  }
////
////  if(budgeta=<= 0) {
////    //TO-DO
////    System.out.println("You are at high risk of falling into debt; please see a financial advisor.");
////  }
////else if (totalAvailableBudget <= monthlyIncome * 0.20) {
////    //TO-DO
////    System.out.println("You may need to cut down on your expenses. We recommend downloading an app to help keep track of — and minimize — your miscellaneous expenses.");
////  }
////else {
////    System.out.println("You are on the right track! Keep it up.");
////  }
////
//
}

