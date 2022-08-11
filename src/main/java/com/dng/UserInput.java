package com.dng;

import java.text.NumberFormat;
import java.util.Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is responsible for asking the user the information needed for the application to run
 * adequately.
 */
public class UserInput {

  private final Locale locale = new Locale("en", "US");
  private final NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
  private final UserMonthlyExpenses profile = new UserMonthlyExpenses();
  private final BufferedReader reader;

  /**
   * The UserInput constructor instantiates any instances of the class and invokes the methods listed in this class
   * @throws IOException Signals a failed input/output operation
   */
  public UserInput() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    welcomeMessage();
    askForMonthlyIncome();
    getMonthlyDebt();
    isUserHomeOwnerOrRenter();
    getMonthlyExpenses();
    collectTotalMortgageOrRent();
    displayBudget();
  }


  /**
   * This is an accessor method for the user's expenses profile.
   * @return returns an instance of the class responsible for the monthly expenses
   */
  public UserMonthlyExpenses getProfile() {
    return profile;
  }

  /**
   * This method asks the user their name then greets them accordingly.
   * @throws IOException Signals a failed input/output operation
   */
  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling!");
    System.out.println("What's your name?");
    String name = reader.readLine();
    profile.setName(name);
    System.out.println("Hi, " + profile.getName() + "!");

  }

  /**
   * This method asks for and saves the user's monthly income.
   * @throws IOException signals a failed input/output operation
   */
  private void askForMonthlyIncome() throws IOException {

    while (true) {
      StringBuilder str = new StringBuilder();
      str.append("What is your monthly income?");
      System.out.println(str);
      String monthlyIncomeStr = reader.readLine();
      try {
        if (Double.parseDouble(monthlyIncomeStr) < 1 || Double.parseDouble(monthlyIncomeStr) > 1_000_000) {
          StringBuilder strThree = new StringBuilder();
          strThree.append("Monthly income must be between 1 and 1,000,000 to qualify for this service.");
          System.out.println(strThree);
          continue;
        }
        profile.setMonthlyIncome(Double.parseDouble(monthlyIncomeStr));
        break;
      } catch (NumberFormatException e) {
        StringBuilder strTwo = new StringBuilder();
        strTwo.append("Incorrect Input. Please enter valid number.");
        System.out.println(strTwo);
      }

    }

  }

  /**
   * This method asks the user if they own a home or rent and saves their response.
   * @throws IOException signals a failed input/output operation
   */
  private void isUserHomeOwnerOrRenter() throws IOException {
    while (true) {
      StringBuilder str = new StringBuilder();
      str.append("Are you a home owner? Y for Yes, N for No.");
      System.out.println(str);
      String homeOwner = reader.readLine();
      if (homeOwner.equalsIgnoreCase("y")) {
        profile.setHomeOwner(true);
        break;
      } else if (homeOwner.equalsIgnoreCase("n")) {
        profile.setHomeOwner(false);
        break;
      } else {
        StringBuilder strTwo = new StringBuilder();
        strTwo.append("Please input correct option.");
        System.out.println(strTwo);
      }
    }
  }


  /**
   * This method asks the user about recurring debt payments, then records the amount they allocate
   * towards these payments.
   * @throws IOException signals a failed input/output operation
   */
  public void getMonthlyDebt() throws IOException {
    StringBuilder str = new StringBuilder();
    str.append("\t\t\t~Debt Payments~\n");
    str.append("Debt payments are any payments you make on a monthly basis to a creditor or lender for any money you owe.\nNote: Enter '0' if debt category does not apply.");
    System.out.println(str);
    double sum = 0.0;
    for (DebtType type : DebtType.values()) {
      double debtX;
      while (true) {
        StringBuilder strTwo = new StringBuilder();
        strTwo.append("Enter the total monthly amount you put towards ");
        strTwo.append(type);
        System.out.println(strTwo);
        String debtStr = reader.readLine();
        try {
          if (Double.parseDouble(debtStr) < 0 || Double.parseDouble(debtStr) > 500000) {
            System.out.println("The value entered must be between 1 and 500,000 to qualify for this service.");
            continue;
          }
          debtX = Double.parseDouble(debtStr);
          profile.getDebts().add(new Debt(type, debtX));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      sum += debtX;
      if (sum >= profile.getMonthlyIncome()) {
        System.out.println(
            "You owe more than you make. Please seek advice from a professional financial advisor.");
      }
    }
    StringBuilder strThree = new StringBuilder();
    strThree.append(profile.getName());
    strThree.append(", your total debt payments equal: ");
    strThree.append(sum);
    System.out.println(strThree);
    profile.setBasicDebts(sum);
  }

  /**
   * This method calculates and saves the user's monthly expenses.
   * @throws IOException signals a failed input/output operation
   */
  private void getMonthlyExpenses() throws IOException {
    System.out.println("\t\t\t~Basic Living Expenses~\nEnter '0' if expense does not apply ");
    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
      double amount;
      while (true) {
        StringBuilder strThree = new StringBuilder();
        strThree.append("Total amount spent (monthly) on ");
        strThree.append(type);
        strThree.append(":");
        System.out.println(strThree);
        String totalMonthlyExpensesStr = reader.readLine();
        try {
          if (Double.parseDouble(totalMonthlyExpensesStr) < 0 || Double.parseDouble(totalMonthlyExpensesStr) > 500000) {
            System.out.println("The value provided must be between 1 and 500,000 to qualify for this service.");
            continue;
          }
          amount = Double.parseDouble(totalMonthlyExpensesStr);
          profile.getExpenses().add(new Expense(type, amount));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }

      }
      sum += amount;
    }
    StringBuilder str = new StringBuilder();
    str.append("Basic monthly expense total: ");
    str.append(fmt.format(sum));
    System.out.println(str);
    profile.setTotalMonthlyExpense(sum);
  }


  /**
   * This method asks users that are homeowners how much their mortgage is (if any), and the those
   * that are renters how much they allocate towards rent. The responses are then saved.
   * @throws IOException signals a failed input/output operation
   */
  private void collectTotalMortgageOrRent() throws IOException {
    if (profile.isHomeOwner()) {
      while (true) {
        System.out.println("What is your monthly mortgage payment?");
        String mortgageStr = reader.readLine();
        try {
          if (Double.parseDouble(mortgageStr) < 0 || Double.parseDouble(mortgageStr) > 500000){
            System.out.println("The value provided must be between 1 and 500,000 to qualify for this service.");
            continue;
          }
          profile.setMonthlyMortgage(Double.parseDouble(mortgageStr));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Mortgage: " + fmt.format(profile.getMonthlyMortgage()));
      profile.setMonthlyMortgage(profile.getMonthlyMortgage());
      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyMortgage()
              + profile.getTotalMonthlyExpense() );
      System.out.println(
          "Total expenses: " + fmt.format(profile.getTotalMonthlyDebtPayment()));
    }

    if (!profile.isHomeOwner()) {
      while (true) {
        System.out.println("How much rent do you pay each month?");
        String rentStr = reader.readLine();
        try {
          if (Double.parseDouble(rentStr) < 0 || Double.parseDouble(rentStr) > 500000){
            System.out.println("The value provided must be between 1 and 500,000 to qualify for this service.");
            continue;
          }
          profile.setMonthlyRent(Double.parseDouble(rentStr));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input. Please enter valid number.");
        }
      }
      System.out.println("Monthly rent: " + fmt.format(profile.getMonthlyRent()) + "\n");
      profile.setMonthlyRent(profile.getMonthlyRent());

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyRent() + profile.getTotalMonthlyExpense());
      System.out.println(
          "Total expenses:  " + fmt.format(profile.getTotalMonthlyDebtPayment()));
    }
  }

  /**
   * This method displays the amount the user has available for budgeting (after expenses). It then
   * displays some recommendations for specific amounts the user should allocate towards specific
   * areas according to the user's personal finances.
   */
  private void displayBudget() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());
    System.out.println(
        "------------------------------------\nAmount available for budgeting:" + fmt.format(
            budget.budgetAmount()) + "\n------------------------------------");
    System.out.printf("Recommended Savings: %2s %n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget.calculateMiscellaneous()) + "\n------------------------------------");
  }

}
