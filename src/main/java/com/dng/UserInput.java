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

  Locale locale = new Locale("en", "US");
  NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

  private final UserMonthlyExpenses profile = new UserMonthlyExpenses();

  private final BufferedReader reader;

  /**
   * The UserInput constructor instantiates any instances of the class.
   * @throws IOException
   */
  //ADD THE INVOCATIONS BELOW TO THE JAVADOCS
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

  /**
   * This accessor method returns the value of the private variable profile.
   *
   * @return
   */
  public UserMonthlyExpenses getProfile() {
    return profile;
  }

  /**
   * This method asks the user their name then greets them accordingly.
   * @throws IOException
   */
  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling!");
    System.out.println("What's your name?");
    String name = reader.readLine();
    profile.setName(name);
    System.out.println("Hi, " + profile.getName() + "!");

  }

  /**
   * This method asks for then saves the user's monthly income.
   */
  private void askForMonthlyIncome() throws IOException {

    while (true) {
      System.out.println("What is your monthly income?");
      String monthlyIncomeStr = reader.readLine();
      try {
        if (Double.parseDouble(monthlyIncomeStr) < 1) {
          System.out.println("Please enter a value larger than or equal to 1.");
          continue;
        }
        profile.setMonthlyIncome(Double.parseDouble(monthlyIncomeStr));
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }

    }

//    System.out.println("Annual Income: " + profile.getMonthlyIncome());
  }

  /**
   * This method asks the user if they own a home or rent and saves their response.
   *
   * @throws IOException
   */
  private void isUserHomeOwnerOrRenter() throws IOException {
    while (true) {
      System.out.println("Are you a home owner? Y for Yes, N for No.");
      String homeOwner = reader.readLine();
      if (homeOwner.equalsIgnoreCase("y")) {
        profile.setHomeOwner(true);
        break;
      } else if (homeOwner.equalsIgnoreCase("n")) {
        profile.setHomeOwner(false);
        break;
      } else {
        System.out.println("Please input correct option.");
      }
    }
  }


  /**
   * This method asks the user about recurring debt payments, then records the amount they allocate
   * towards these payments.
   *
   * @throws IOException
   */
  public void getMonthlyDebt() throws IOException {
    System.out.println(
        "\t\t\t~Debt Payments~\n"
            + "Debt payments are any payments you make on a monthly basis to a creditor or lender for any money you owe.\nNote: Enter '0' if debt category does not apply.");
    double sum = 0.0;
    for (DebtType type : DebtType.values()) {
      double debtX;
      while (true) {
        System.out.println("Enter " + type + " monthly payment:");
        String debtStr = reader.readLine();
        try {
          if (Double.parseDouble(debtStr) < 0) {
            System.out.println("Please enter a value larger than or equal to 0.");
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
    System.out.printf("%1$s, your total debt payments equal: %2$s \n", profile.getName(), sum);
    profile.setBasicDebts(sum);
  }

  /**
   * This method calculates and saves the user's monthly expenses.
   *
   * @throws IOException
   */
  private void getMonthlyExpenses() throws IOException {

    System.out.println("\t\t\t~Basic Living Expenses~\nEnter '0' if expense does not apply ");

    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
      double amount;
      while (true) {
        System.out.println("Total amount spent (monthly) " + type + ":");
        String totalMonthlyExpensesStr = reader.readLine();
        try {
          if (Double.parseDouble(totalMonthlyExpensesStr) < 0) {
            System.out.println("Please enter a value larger than or equal to 0.");
            continue;
          }
          amount = Double.parseDouble(totalMonthlyExpensesStr);
          profile.getExpenses().add(new Expense(type, amount));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }

      }
//      System.out.println("your monthly payment: " + amount);
      sum += amount;
    }
    System.out.println("Basic monthly expense total: " + fmt.format(sum));
    profile.setTotalMonthlyExpense(sum);
  }


  /**
   * This method asks users that are homeowners how much their mortgage is (if any), and the those
   * that are renters how much they allocate towards rent. The responses are then saved.
   *
   * @throws IOException
   */
  private void collectTotalMortgageOrRent() throws IOException {
    if (profile.isHomeOwner()) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = reader.readLine();
        try {
          if (Double.parseDouble(mortgageStr) < 0){
            System.out.println("Please enter a value larger than or equal to 0.");
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
      //Calculates Total payment made in a month (expenses + basic debt + mortgage)


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
          if (Double.parseDouble(rentStr) < 0){
            System.out.println("Please enter a value larger than or equal to 0.");
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

}
