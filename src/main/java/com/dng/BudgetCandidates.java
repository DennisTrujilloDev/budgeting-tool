package com.dng;

public class BudgetCandidates {

  private boolean isEligibleforBudgeting;
  //this field is not used

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

  public static void executeBudgeting(UserInput userInput) {
    //Calculate Total amount available for budgeting each month.
    // Total available budget = annualIncome/12 - total debt - total monthly expense.

    Double totalAvailableBudget = BudgetCandidates.calculateAvailableBudget(userInput.isHomeOwner(),
        userInput.getAnnualIncome(), userInput.getTotalMonthlyDebtPayment(),
        userInput.getTotalMonthlyExpenses(), userInput.getMonthlyRent(), userInput.getMonthlyMortgage());

    giveBudgetAdvice(userInput.getAnnualIncome(), userInput.getTotalAvailableBudget());

  }

  private static void giveBudgetAdvice(Double annualIncome, Double totalAvailableBudget) {
    double monthlyIncome = annualIncome/12;

    if(totalAvailableBudget <= 0) {
      //TO-DO
      System.out.println("You are at high risk of falling into debt; please see a financial advisor.");
    }
    else if (totalAvailableBudget <= monthlyIncome * 0.20) {
      //TO-DO
      System.out.println("You may need to cut down on your expenses. We recommend downloading an app to help keep track of — and minimize — your miscellaneous expenses.");
    }
    else {
      System.out.println("You are on the right track! Keep it up.");
    }
  }


//      private void leftoverMoneyAfterBudgeting() {
////      double leftovers = 100 - (
////          (EMERGENCY_FUND_CONSTANT + SAVINGS_CONSTANT + MISCELLANEOUS_CONSTANT + FOOD_CONSTANT)
////              * 100);
//      System.out.printf("We suggest investing the remaining %f%n in the stock market", leftovers);
//    }
}

