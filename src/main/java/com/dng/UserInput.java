package com.dng;

import com.dng.model.DebtType;
import com.dng.model.Expense;
import com.dng.model.ExpenseType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This class is responsible for asking the user the information needed for the application to run
 * adequately.
 */

public class UserInput {

  Locale locale = new Locale("en", "US");
//  NumberFormat fmt = NumberFormat.getCurrencyInstance();
  NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
  Calendar calendar = Calendar.getInstance();
  Date date = calendar.getTime();


  private UserMonthlyExpenses profile = new UserMonthlyExpenses();

  private BufferedReader reader;

  /**
   * The UserInput constructor instantiates any instances of the class.
   *
   * @throws IOException
   */

  public UserInput() throws IOException {

    reader = new BufferedReader(new InputStreamReader(System.in));

    welcomeMessage();
    askForMonthlyIncome();
    getMonthlyDebt();
    getMonthlyExpenses();
    isUserHomewonerOrRenter();
    collectTotalMortgageOrRent();

    Double totalDebt = profile.getTotalMonthlyDebtPayment();
    Double income = profile.getMonthlyIncome();
    double budgetAmount = income - totalDebt;

    if (budgetAmount < 0.45 * profile.getMonthlyIncome()) {

      System.out.println(
          "------------------------------------\nMonthly Income: " + fmt.format(
              profile.getMonthlyIncome()) + "\n");

      System.out.println(
          "Total Expense: " + fmt.format(
              profile.getTotalMonthlyDebtPayment()) + "\n------------------------------------\n");

      System.out.printf(
          "Sorry %1$s , a budget can not be created for you at this time.\n"
              + "Your expense is more than your income\n"
              + "You are in debt. Please see a financial advisor as soon as possible.\n\n"
              + "Also consider the following options:\n"
              + "1.Evaluate your fixed expenses and see if there is any chance you can"
              + " save money on them.\n"
              + "2.Search for options to switch to a cheaper car insurance policy.\n"
              + "3.Renegotiate your credit card interest to get a lower rate and "
              + "pay off your debt faster.\n"
              + "___________________________________________________________________\n\n",
          profile.getName());
    } else if (budgetAmount > 0.45 * profile.getMonthlyIncome()
        && budgetAmount <= 0.55 * profile.getMonthlyIncome()) {

      System.out.printf(
          "%1$s, you are at high risk of falling into debt.\n\n",
          profile.getName());
      displayBudgetBorderLine();
    } else {
      System.out.printf("%s, You are on the right track! Keep it up.\n\n", profile.getName());
      displayBudgetGoodStanding();
    }

    System.out.printf("Thank you %1s, for using the Budget Counselling app\n", profile.getName());
  }

  public UserMonthlyExpenses getProfile() {
    return profile;
  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.\n");
    System.out.println("What is your name ?\n");
    String name = reader.readLine();
    profile.setName(name);
    System.out.println("Hi, " + profile.getName() + "!");
    String weekDay = new SimpleDateFormat("EEEE", Locale.US).format(date.getTime());
    System.out.println("Happy " + weekDay + "!!!  :) ");
    System.out.printf("%1$s,let us help you create a monthly budget.\n\n", profile.getName());

  }

  private void askForMonthlyIncome() throws IOException {
    while (true) {
      System.out.println("What is your monthly income after tax ?\n");
      String monthlyIncomeStr = reader.readLine();
      try {
        if (Double.parseDouble(monthlyIncomeStr) < 1) {
          System.out.println("Please enter a value larger than or equal to 1.\n");
          continue;
        }
        profile.setMonthlyIncome(Double.parseDouble(monthlyIncomeStr));
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.\n");
      }

    }

  }

  /**
   * This method asks the user if they own a home or rent and saves their response.
   *
   * @throws IOException
   */
  private void isUserHomewonerOrRenter() throws IOException {
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
        System.out.println("Please input correct option.\n");
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
            + "Monthly debt payments are any payments you make to "
            + "pay back a creditor or lender for money you borrowed.\n\n"
            + "Enter '0' if debt category does not apply.\n");
    double sum = 0.0;
    for (DebtType type : DebtType.values()) {

      double debtX;
      while (true) {
        System.out.println("Enter " + type + " (Monthly)");
        String debtStr = reader.readLine();
        try {
          if (Double.parseDouble(debtStr) < 0) {
            System.out.println(" Please enter a value larger than or equal to 0.");
            continue;
          }
          debtX = Double.parseDouble(debtStr);
          profile.getDebts().add(new Debt(type, debtX));
          break;
        } catch (NumberFormatException e) {
          System.out.println(" Incorrect Input. Please enter valid number.");
        }
      }
      sum = sum + debtX;
    }
    profile.setBasicDebts(sum);
    System.out.printf("%1$s, your debt this month is: %2$s\n\n", profile.getName(),
        profile.getBasicDebts());
  }

  /**
   * This method calculates and saves the user's monthly expenses.
   *
   * @throws IOException
   */

  private void getMonthlyExpenses() throws IOException {

    System.out.println("\t\t\t~Basic Living Expenses~\nEnter '0' if expense does not apply\n");

    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
      double amount = 0;

      while (true) {
        System.out.println("Enter " + type + " ( Monthly )");
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
      sum = sum + amount;
    }
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
          if (Double.parseDouble(mortgageStr) < 0) {
            System.out.println("Please enter a value larger than or equal to 0.");
            continue;
          }
          profile.setMonthlyMortgage(Double.parseDouble(mortgageStr));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }

      profile.setMonthlyMortgage(profile.monthlyMortgage);

      //Calculates Total payment made in a month (expenses + basic debt + mortgage)
      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyMortgage()
              + profile.getTotalMonthlyExpense());

    }

    //If the user is not a homeowner (renter), ask how much rent do they pay
    if (!profile.isHomeOwner()) {
      while (true) {
        System.out.println("How much rent do you pay each month?");
        String rentStr = reader.readLine();
        try {
          if (Double.parseDouble(rentStr) < 0) {
            System.out.println("Please enter a value larger than or equal to 0.");
            continue;
          }
          profile.setMonthlyRent(Double.parseDouble(rentStr));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: \n" + fmt.format(profile.monthlyRent));
      profile.setMonthlyRent(profile.monthlyRent);

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyRent() + profile.getTotalMonthlyExpense());

    }

  }

  /**
   * This method displays the amount the user has available for budgeting (after expenses) if th
   * euser is at borderline debt.
   */
  private void displayBudgetBorderLine() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());

    System.out.println(
        "------------------------------------\nMonthly Income: " + fmt.format(
            profile.getMonthlyIncome()) + "\n");

    System.out.println(
        "Total Expense: " + fmt.format(
            profile.getTotalMonthlyDebtPayment()) + "\n------------------------------------\n");

    System.out.println(
        "------------------------------------\nAmount available for budgeting: " + fmt.format(
            budget.budgetAmount()) + "\n------------------------------------");
    System.out.printf("Recommended Savings: %2s%n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget.calculateMiscellanous()) + "\n____________________________________");

    double x = ((0.5*profile.getMonthlyIncome()) - profile.getTotalMonthlyExpense());

    System.out.println("Recommended Investment Amount:" + fmt.format(x)+ "\n");

  }

  /**
   * This method displays the amount the user has available for budgeting (after expenses) if the
   * user is in good standing.
   */
  private void displayBudgetGoodStanding() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());

    System.out.println(
        "------------------------------------\nMonthly Income: " + fmt.format(
            profile.getMonthlyIncome()) + "\n");

    System.out.println(
        "Total Expense: " + fmt.format(
            profile.getTotalMonthlyDebtPayment()) + "\n------------------------------------");

    BudgetItem budget1 = new BudgetItem(profile.getMonthlyIncome(),
        profile.getTotalMonthlyDebtPayment());

    System.out.println(
        "------------------------------------\nAmount available for budgeting:" + fmt.format(
            budget1.budgetAmount()) + "\n-----------------------------------------");
    System.out.printf("Recommended Savings: %2s\t\t\t%n", fmt.format(budget.calculateSavingsG()));

    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget1.calculateEmergencyFundG()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget1.calculateFoodBudgetG()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget1.calculateMiscellanousG()) + "\n____________________________________");

    double x = ((0.5*profile.getMonthlyIncome()) - profile.getTotalMonthlyExpense());

    System.out.println("Recommended Investment Amount: " + fmt.format(x)+ "\n");

  }


}
