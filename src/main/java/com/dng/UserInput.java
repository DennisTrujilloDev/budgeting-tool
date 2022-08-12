package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This class is responsible for asking for the user's personal and financial information.
 */

public class UserInput {

  private final UserMonthlyExpenses profile = new UserMonthlyExpenses();
  private BufferedReader reader;
  private final Locale locale = new Locale("en", "US");
  private final NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
  private final Calendar calendar = Calendar.getInstance();
  private final Date date = calendar.getTime();


  /**
   * The UserInput constructor instantiates any instances of the class and invokes the methods listed in this class.
   * Additionally, it determines whether the user is at risk of falling into debt.
   * @throws IOException Signals a failed input/output operation
   */

  public UserInput() throws IOException {

    reader = new BufferedReader(new InputStreamReader(System.in));

    welcomeMessage();
    askForMonthlyIncome();
    getMonthlyDebt();
    getMonthlyExpenses();
    isUserHomeownerOrRenter();
    collectTotalMortgageOrRent();

    final Double totalDebt = profile.getTotalMonthlyDebtPayment();
    final Double income = profile.getMonthlyIncome();
    final double budgetAmount = income - totalDebt;

    if (budgetAmount <= 0.45 * profile.getMonthlyIncome()) {
      System.out.println(
          "------------------------------------\nMonthly Income: " + fmt.format(
              profile.getMonthlyIncome()) + "\n");
      System.out.println(
          "Total Expense: " + fmt.format(
              profile.getTotalMonthlyDebtPayment()) + "\n------------------------------------\n");
      System.out.printf(
          "Sorry %1$s , a budget can not be created for you at this time.\n"
              + "Your expense is more than your income\n"
              + "You are in debt. "
              + "Please see a financial advisor as soon as possible.\n\n"
              + "Also consider the following options:\n"
              + "1.Evaluate your fixed expenses and see if there is any chance you can"
              + " save money on them.\n"
              + "2.Research inexpensive car insurance policies.\n"
              + "3.Renegotiate your credit card interest to get a lower rate.\n"
              + "___________________________________________________________________\n\n",
          profile.getName());
    }
    else if (budgetAmount > 0.45 * profile.getMonthlyIncome()
        && budgetAmount <= 0.55 * profile.getMonthlyIncome()) {
      System.out.printf(
          "%1$s, you are at risk of falling into debt.\n",
          profile.getName());
      displayBudgetBorderLine();
    }
    else {
      System.out.printf("%s, You are on the right track! Keep it up.\n", profile.getName());
      displayBudgetGoodStanding();
    }
    System.out.printf("Thank you for using the Budget Counselling app, %1s\n", profile.getName());
  }

  /**
   * This method asks the user their name then greets them accordingly.
   * @throws IOException Signals a failed input/output operation
   */
  private void welcomeMessage() throws IOException {
    System.out.println("\t\t\t~Welcome to Budgeting Counseling~");
    System.out.println("What is your name?");
    String name = reader.readLine();
    profile.setName(name);
    String weekDay = new SimpleDateFormat("EEEE", Locale.US).format(date.getTime());
    System.out.println("Hi, " + profile.getName() + "! Happy " + weekDay + " :)");
    System.out.printf("%1$s, allow us to assist you in managing your finances...\n", profile.getName());

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
   *
   * @throws IOException signals a failed input/output operation
   */
  private void isUserHomeownerOrRenter() throws IOException {
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
    System.out.println(
        "\t\t\t~Debt Payments~\n"
            + "Monthly debt payments are any payments you make to pay back\n a creditor or lender for any money you've borrowed.\n"
            + "Enter '0' if debt category does not apply.\n");
    double sum = 0.0;
    for (DebtType type : DebtType.values()) {

      double debtX;
      while (true) {
        StringBuilder strTwo = new StringBuilder();
        strTwo.append("Enter the total monthly amount you put towards (your) ");
        strTwo.append(type);
        System.out.println(strTwo);
        String debtStr = reader.readLine();
        try {
          if (Double.parseDouble(debtStr) < 0 || Double.parseDouble(debtStr) > 500000) {
            StringBuilder strThree = new StringBuilder();
            strThree.append("The value entered must be between 1 and 500,000 to qualify for this service.");
            System.out.println(strThree);

            continue;
          }
          debtX = Double.parseDouble(debtStr);
          profile.getDebts().add(new Debt(type, debtX));
          break;
        } catch (NumberFormatException e) {
          StringBuilder strFour = new StringBuilder();
          strFour.append("Incorrect Input. Please enter valid number.");
          System.out.println(strFour);
        }
      }
      sum += debtX;
    }
    profile.setBasicDebts(sum);
    System.out.printf("%1$s, your debt this month is: %2$s\n\n", profile.getName(),
        profile.getBasicDebts());
  }

  /**
     * This method calculates and saves the user's monthly expenses.
      * @throws IOException signals a failed input/output operation
   */
  private void getMonthlyExpenses() throws IOException {

    System.out.println("\t\t\t~Basic Living Expenses~\nEnter '0' if expense does not apply");

    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
      double amount = 0;

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
   *
   * @throws IOException signals a failed input/output operation
   */
  private void collectTotalMortgageOrRent() throws IOException {

    if (profile.isHomeOwner()) {
      while (true) {
        System.out.println("What is your monthly mortgage payment?");
        String mortgageStr = reader.readLine();
        try {
          if (Double.parseDouble(mortgageStr) < 0 || Double.parseDouble(mortgageStr) > 50000) {
            System.out.println("The value provided must be between 1 and 50,000.");
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

      //Calculates total payment made in a month (expenses + basic debt + mortgage)
      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyMortgage()
              + profile.getTotalMonthlyExpense());
      System.out.println(
          "Total expenses: " + fmt.format(profile.getTotalMonthlyDebtPayment()));

    }

    if (!profile.isHomeOwner()) {
      while (true) {
        System.out.println("How much do you spend monthly on rent?");
        String rentStr = reader.readLine();
        try {
          if (Double.parseDouble(rentStr) < 0  || Double.parseDouble(rentStr) > 50000) {
            System.out.println("The value provided must be between 1 and 50,000 .");
            continue;
          }
          profile.setMonthlyRent(Double.parseDouble(rentStr));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: " + fmt.format(profile.getMonthlyRent()) + "\n");
      profile.setMonthlyRent(profile.getMonthlyRent());

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyRent() + profile.getTotalMonthlyExpense());
      System.out.println("Total expenses:  " + fmt.format(profile.getTotalMonthlyDebtPayment()));
    }

  }

  /**
   * This method displays the amount your avergae user has available for budgeting (after expenses). It then
   * displays some recommendations for specific amounts the user should allocate towards specific
   * areas according to the user's personal finances.
   */
  private void displayBudgetBorderLine() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());

    System.out.println(
        "------------------------------------\nMonthly Income: " + fmt.format(
            profile.getMonthlyIncome()) + "\n");

    System.out.println(
        "Total Expense: " + fmt.format(
            profile.getTotalMonthlyDebtPayment()) );

    System.out.println(
        "------------------------------------\nAmount available for budgeting: " + fmt.format(
            budget.budgetAmount()) + "\n------------------------------------");
    System.out.printf("Recommended Savings: %2s%n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget.calculateMiscellaneous()) + "\n____________________________________");
  }

  /**
   * This method displays the amount a user in good financial standing has available for budgeting (after expenses). It then
   * displays some recommendations for specific amounts the user should allocate towards specific
   * areas according to the user's personal finances.
   */
  private void displayBudgetGoodStanding() {
    System.out.println(
        "------------------------------------\nMonthly Income: " + fmt.format(
            profile.getMonthlyIncome()) + "\n");

    System.out.println(
        "Total Expense: " + fmt.format(
            profile.getTotalMonthlyDebtPayment()));

    BudgetItem budget1 = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());

    System.out.println(
        "------------------------------------\nAmount available for budgeting:" + fmt.format(
            budget1.budgetAmount()) + "\n-----------------------------------------");
    System.out.printf("Recommended Savings: %2s\t\t\t%n", fmt.format(budget1.calculateSavingsG()));

    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget1.calculateEmergencyFundG()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget1.calculateFoodBudgetG()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget1.calculateMiscellaneousG()) + "\n____________________________________");

  }


}
