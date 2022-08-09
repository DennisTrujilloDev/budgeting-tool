package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {

  private UserProfile userProfile;
  private boolean isHomeOwner;
  private Integer monthlyMortgage;
  private Integer monthlyRent;
  private Integer annualIncome;
  private Integer totalDebt;
  private Integer totalMonthlyDebtPayment;
  private Integer totalMonthlyExpenses;
  private Integer totalAvailableBudget;
  private boolean isEligibleForBudgeting;
  private BufferedReader reader;

  public UserInput() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));

    //ask user's name and print welcome message.
    welcomeMessage();

    //ask whether user is individual or family
    isUserIndividualOrFamily();

    //ask whether user is a homeowner or a renter.
    isUserHomewonerOrRenter();

    //collect total monthly mortgage or rent of the user depending on whether they are homeowner or
    // a renter.
    collectTotalMortgageOrRent();

    // get the user's annual income
    getAnnualIncome();

    //get user's  total debt including student loan, car loan, medical bills etc
    getTotalDebt();

    //Get User's Monthly Debt Payment
    getMonthlyDebtPayment();

    //Get User's Monthly Expenses
    getMonthlyExpenses();

    //Calculate Total amount available for budgeting each month. Total available budget is
    // annualIncome/12 - total debt - total monthly expense.
    calculateAvailableBudget();

    //if the user is saving less than 20% of their income, they are eligible for budgeting
    determineBudgetingEligibility();
  }

   private void determineBudgetingEligibility() {
    Integer monthlyIncome = annualIncome/12;
    Double maxLimitForBudgeting = monthlyIncome * 0.20;

    if(totalAvailableBudget > maxLimitForBudgeting) {
      isEligibleForBudgeting = false;
      System.out.println("Your financial situation is in good standard.");
    }
    else {
      isEligibleForBudgeting = true;
      System.out.println("You require budgeting.");
    }

  }

  private void calculateAvailableBudget() {
    if(isHomeOwner) {
      totalAvailableBudget = (annualIncome/12) - totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyMortgage;
    }
    else {
      totalAvailableBudget = (annualIncome/12) - totalMonthlyDebtPayment -
          totalMonthlyExpenses - monthlyRent;
    }
    System.out.println("Total Available Amount for Budgeting Each Month: " + totalAvailableBudget);
  }

  private void getMonthlyExpenses() throws IOException {
    while (true) {
      System.out.println("How much do you pay each month in expenses?");
      String totalExpensesStr = reader.readLine();
      try {
        totalMonthlyExpenses = Integer.parseInt(totalExpensesStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your Monthly Payment: " + totalMonthlyExpenses);
  }

  private void getMonthlyDebtPayment() throws IOException {
    while (true) {
      System.out.println("How much debt do you pay each month in total?");
      String totalPaymentStr = reader.readLine();
      try {
        totalMonthlyDebtPayment = Integer.parseInt(totalPaymentStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your Monthly Payment: " + totalMonthlyDebtPayment);
  }

  private void getTotalDebt() throws IOException {
    while (true) {
      System.out.println("How much debt do you have?");
      String debtStr = reader.readLine();
      try {
        totalDebt = Integer.parseInt(debtStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your debt: " + totalDebt);
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  public boolean isHomeOwner() {
    return isHomeOwner;
  }

  public void setHomeOwner(boolean homeOwner) {
    isHomeOwner = homeOwner;
  }

  public Integer getMonthlyMortgage() {
    return monthlyMortgage;
  }

  public void setMonthlyMortgage(Integer monthlyMortgage) {
    this.monthlyMortgage = monthlyMortgage;
  }

  public Integer getMonthlyRent() {
    return monthlyRent;
  }

  public void setMonthlyRent(Integer monthlyRent) {
    this.monthlyRent = monthlyRent;
  }

  public void setAnnualIncome(Integer annualIncome) {
    this.annualIncome = annualIncome;
  }

  public void setTotalDebt(Integer totalDebt) {
    this.totalDebt = totalDebt;
  }

  public Integer getTotalMonthlyDebtPayment() {
    return totalMonthlyDebtPayment;
  }

  public void setTotalMonthlyDebtPayment(Integer totalMonthlyDebtPayment) {
    this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
  }

  public Integer getTotalMonthlyExpenses() {
    return totalMonthlyExpenses;
  }

  public void setTotalMonthlyExpenses(Integer totalMonthlyExpenses) {
    this.totalMonthlyExpenses = totalMonthlyExpenses;
  }

  public Integer getTotalAvailableBudget() {
    return totalAvailableBudget;
  }

  public void setTotalAvailableBudget(Integer totalAvailableBudget) {
    this.totalAvailableBudget = totalAvailableBudget;
  }

  public boolean isEligibleForBudgeting() {
    return isEligibleForBudgeting;
  }

  public void setEligibleForBudgeting(boolean eligibleForBudgeting) {
    isEligibleForBudgeting = eligibleForBudgeting;
  }

  private void getAnnualIncome() throws IOException {
    while (true) {
      System.out.println("What's your annual income?");
      String annualIncomeStr = reader.readLine();
      try {
        annualIncome = Integer.parseInt(annualIncomeStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Annual Income: " + annualIncome);
  }

  private void collectTotalMortgageOrRent() throws IOException {
    //If the user is a home owner, ask how much mortgage do they pay
    if (isHomeOwner) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = reader.readLine();

        try {
          monthlyMortgage = Integer.parseInt(mortgageStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Mortgage: " + monthlyMortgage);
    }

    //If the user is not a home owner (renter), ask how much rent do they pay
    if (!isHomeOwner) {
      while (true) {
        System.out.println("How much rent do yoy pay each month?");
        String rentStr = reader.readLine();
        try {
          monthlyRent = Integer.parseInt(rentStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: " + monthlyRent);
    }
  }

  private void isUserHomewonerOrRenter() throws IOException {
    while (true) {
      System.out.println("Are you a home owner? Y for Yes, N for No.");
      String homeOwner = reader.readLine();
      if (homeOwner.equalsIgnoreCase("y")) {
        isHomeOwner = true;
        break;
      } else if (homeOwner.equalsIgnoreCase("n")) {
        isHomeOwner = false;
        break;
      } else {
        System.out.println("Please input correct option.");
      }
    }
  }

  private void isUserIndividualOrFamily() throws IOException {
    while (true) {
      String individualOrFamily = reader.readLine();
      if (individualOrFamily.equalsIgnoreCase("i")) {
        userProfile = UserProfile.INDIVIDUAL;
        break;
      } else if (individualOrFamily.equalsIgnoreCase("f")) {
        userProfile = UserProfile.FAMILY;
        break;
      } else {
        System.out.println("Please input correct option. I for Individual, F for Family.");
      }
    }
    System.out.println("User Profile: " + userProfile);
  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = reader.readLine();

    System.out.println("Hello, " + name);

    System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
  }

}
