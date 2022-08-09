package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

  private UserProfile userProfile;
  private boolean isHomeOwner;
  private Double monthlyMortgage = 0.0;
  private Double monthlyRent = 0.0;
  private Double annualIncome  = 0.0;
  private Double totalMonthlyDebtPayment = 0.0;
  private Double totalMonthlyExpenses = 0.0;
  private Double totalAvailableBudget = 0.0;
  private boolean isEligibleForBudgeting = false;
  private List<Debt> debts;
  private List<UserMonthlyExpenses> userMonthlyExpense;
  private BufferedReader reader;

  public UserInput() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    userMonthlyExpense = new ArrayList<>();
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.PHONE_BILL, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.GROCERIES, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.GAS, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.WATER_BILL, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.INTERNET_BILL, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.ELECTRIC_BILL, 0.00) );
    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.MISCELLANEOUS, 0.00) );

    userMonthlyExpense.add(new UserMonthlyExpenses(UserMonthlyExpensesType.CAR_INSURANCE, 0.00) );

    debts = new ArrayList<>();
    debts.add(new Debt(DebtType.CAR_LOAN, 0.0));
    debts.add(new Debt(DebtType.CREDIT_CARDS, 0.0));
    debts.add(new Debt(DebtType.MEDICAL_BILLS, 0.0));
    debts.add(new Debt(DebtType.STUDENT_LOAN,  0.0));
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
    askForAnnualIncome();

    //get user's  total debt including student loan, car loan, medical bills etc
    getTotalMonthlyDebt();

    //Get User's Monthly Expenses
    getMonthlyExpenses();
  }


  private void getMonthlyExpenses() throws IOException {
    for (int i = 0; i < userMonthlyExpense.size(); i++) {
      Double userMonthlyExpenses;
      while (true) {

        System.out.println("How much do you pay each month in expenses" + userMonthlyExpense.get(i).userMonthlyExpensesType + "?");
        String totalMonthlyExpensesStr = reader.readLine();
        try {
          totalMonthlyExpenses = Double.parseDouble(totalMonthlyExpensesStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Your Monthly Payment: " + totalMonthlyExpenses);
    }
  }

  public void getTotalMonthlyDebt() throws IOException {
    for (int i = 0; i < debts.size(); i++) {
      Double debt;
      while(true) {
        System.out.println("How much do you pay each month in " + debts.get(i).debtType + "?");
        String debtStr = reader.readLine();
        try {
          debt = Double.parseDouble(debtStr);
          debts.get(i).setAmount(debt);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println(String.format("Your %s debt: %s", debts.get(i).debtType, debt));
    }


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

  public Double getMonthlyMortgage() {
    return monthlyMortgage;
  }

  public void setMonthlyMortgage(Double monthlyMortgage) {
    this.monthlyMortgage = monthlyMortgage;
  }

  public Double getMonthlyRent() {
    return monthlyRent;
  }

  public void setMonthlyRent(Double monthlyRent) {
    this.monthlyRent = monthlyRent;
  }


  public Double getAnnualIncome() {
    return annualIncome;
  }
  public void setAnnualIncome(Double annualIncome) {
    this.annualIncome = annualIncome;
  }

  public void setTotalDebt(Double totalDebt) {
  }

  public Double getTotalMonthlyDebtPayment() {
    return totalMonthlyDebtPayment;
  }

  public void setTotalMonthlyDebtPayment(Double totalMonthlyDebtPayment) {
    this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
  }

  public Double getTotalMonthlyExpenses() {
    return totalMonthlyExpenses;
  }

  public void setTotalMonthlyExpenses(Double totalMonthlyExpenses) {
    this.totalMonthlyExpenses = totalMonthlyExpenses;
  }

  public Double getTotalAvailableBudget() {
    return totalAvailableBudget;
  }

  public void setTotalAvailableBudget(Double totalAvailableBudget) {
    this.totalAvailableBudget = totalAvailableBudget;
  }

  public boolean isEligibleForBudgeting() {
    return isEligibleForBudgeting;
  }

  public void setEligibleForBudgeting(boolean eligibleForBudgeting) {
    isEligibleForBudgeting = eligibleForBudgeting;
  }

  private void askForAnnualIncome() throws IOException {
    while (true) {
      System.out.println("What's your annual income?");
      String annualIncomeStr = reader.readLine();
      try {
        annualIncome = Double.parseDouble(annualIncomeStr);
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
          monthlyMortgage = Double.parseDouble(mortgageStr);
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
          monthlyRent = Double.parseDouble(rentStr);
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
