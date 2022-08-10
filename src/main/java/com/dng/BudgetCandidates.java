package com.dng;

public class BudgetCandidates {

  private boolean isEligibleforBudgeting = false;

  public static void executeBudgeting(UserInput userInput) {
    //Calculate Total amount available for budgeting each month.
    // Total available budget = annualIncome/12 - total debt - total monthly expense.

    Double totalAvailableBudget = BudgetCandidates.calculateAvailableBudget(userInput.isHomeOwner(),
        userInput.getAnnualIncome(), userInput.getTotalMonthlyDebtPayment(),
        userInput.getTotalMonthlyExpenses(), userInput.getMonthlyRent(), userInput.getMonthlyMortgage());

    giveBudgetAdvice(userInput.getAnnualIncome(), userInput.getTotalAvailableBudget());

  }

  private static void giveBudgetAdvice(Double annualIncome, Double totalAvailableBudget) {
    Double monthlyIncome = annualIncome/12;

    if(totalAvailableBudget <= 0) {
      //TO-DO
      System.out.println("Your expenses are more higher than your income. You will need to think hard on how to manage your money. \n"
      + "Find out how the state and federal government can support you financial situation. \n"
              + "Cut down on your non critical expenses. \n");
    }
    else if (totalAvailableBudget <= monthlyIncome * 0.20) {
      //TO-DO
      System.out.println("Your expenses are higher than your income,  \n"
          + "Issue a warning about overspending and maybe cutting down on miscellaneous expenses.\n"
          + "Also, give advise on getting an extra source of income to supplement their current income.");
    }
    else {
      System.out.println("You have good financial health. Be sure to keep your money in Savings for future");
    }
  }

  private static Double calculateAvailableBudget(boolean isHomeOwner, Double annualIncome,
      Double totalMonthlyDebtPayment, Double totalMonthlyExpenses, Double monthlyRent, Double monthlyMortgage) {

    Double totalAvailableBudget = 0.0;
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


