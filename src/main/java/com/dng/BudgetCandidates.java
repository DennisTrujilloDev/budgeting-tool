package com.dng;

public class BudgetCandidates {

//  BudgetItem ab = new BudgetItem();

BudgetItem budget = new BudgetItem();


  private boolean isEligibleforBudgeting = false;

  public static void executeBudgeting(UserInput userInput) {
    //Calculate Total amount available for budgeting each month.
    // basic debts + monthly expense + monthly mortgage or rent

    Double totalAvailableBudget = BudgetCandidates.calculateAvailableBudget(userInput.getProfile().isHomeOwner(),
        userInput.getProfile().getMonthlyIncome(), userInput.getProfile().getTotalMonthlyDebtPayment(),
        userInput.getProfile().getTotalMonthlyExpenses(), userInput.getProfile().getMonthlyRent(), userInput.getProfile().getMonthlyMortgage());

    giveBudgetAdvice(userInput.getProfile().getMonthlyIncome(), userInput.getProfile().getTotalAvailableBudget());

  }

  private static void giveBudgetAdvice(Double monthlyIncome, Double totalAvailableBudget) {


    if(totalAvailableBudget <= 0) {
      //TO-DO
      System.out.println("Total Available Budget less than 0. You will need to think hard on how to manage your money.");
    }
    else if (totalAvailableBudget <= monthlyIncome * 0.20) {
      //TODO
      System.out.println("f budget amount is less than a certain threshold,  \n"
          + "Issue a warning about overspending and maybe cutting down on miscellaneous expenses.\n"
          + "Also, give advise on getting an extra source of income to supplement their current income.");
    }
    else {
      System.out.println("You are on the right track!");
    }
  }

  private static Double calculateAvailableBudget(boolean isHomeOwner, Double monthlyIncome,
      Double totalMonthlyDebtPayment, Double totalMonthlyExpenses, Double monthlyRent, Double monthlyMortgage) {

    double totalAvailableBudget = 0.0;
    if(isHomeOwner) {
      totalAvailableBudget = (monthlyIncome - (totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyMortgage));
    }
    else {
      totalAvailableBudget = (monthlyIncome - (totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyRent));
    }
//    System.out.println("Total Available Amount for Budgeting Each Month: " + totalAvailableBudget);

    return totalAvailableBudget;
  }


}
