package com.dng;

public class BudgetCandidates {

  private boolean isEligibleforBudgeting = false;

  public static void executeBudgeting(UserInput userInput) {
    //Calculate Total amount available for budgeting each month.
    // basic debts + monthly expense + monthly mortgage or rent

    Double totalAvailableBudget = BudgetCandidates.calculateAvailableBudget(userInput.debt.isHomeOwner(),
        userInput.debt.getMonthlyIncome(), userInput.debt.getTotalMonthlyDebtPayment(),
        userInput.debt.getTotalMonthlyExpenses(), userInput.debt.getMonthlyRent(), userInput.debt.getMonthlyMortgage());

    giveBudgetAdvice(userInput.debt.getMonthlyIncome(), userInput.debt.getTotalAvailableBudget());

  }

  private static void giveBudgetAdvice(Double annualIncome, Double totalAvailableBudget) {
    Double monthlyIncome = annualIncome/12;

    if(totalAvailableBudget <= 0) {
      //TO-DO
      System.out.println("Total Available Budget less than 0. You will need to think hard on how to manage your money.");
    }
    else if (totalAvailableBudget <= UserInput.debt.getMonthlyIncome() * 0.20) {
      //TO-DO
      System.out.println("f budget amount is less than a certain threshold,  \n"
          + "Issue a warning about overspending and maybe cutting down on miscellaneous expenses.\n"
          + "Also, give advise on getting an extra source of income to supplement their current income.");
    }
    else {
      System.out.println("You are on the right track!");
    }
  }

  private static Double calculateAvailableBudget(boolean isHomeOwner, Double annualIncome,
      Double totalMonthlyDebtPayment, Double totalMonthlyExpenses, Double monthlyRent, Double monthlyMortgage) {

    double totalAvailableBudget = 0.0;
    if(isHomeOwner) {
      totalAvailableBudget = (annualIncome/12) - totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyMortgage;
    }
    else {
      totalAvailableBudget = (annualIncome/12) - totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyRent;
    }
    System.out.println("Total Available Amount for Budgeting Each Month: " + totalAvailableBudget);

    return totalAvailableBudget;
  }


}
