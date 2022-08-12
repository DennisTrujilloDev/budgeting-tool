package com.dng;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInput {

  Locale locale = new Locale("en", "US");
  NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

  Calendar calendar = Calendar.getInstance();
  Date date = calendar.getTime();


  private UserMonthlyExpenses profile = new UserMonthlyExpenses();

  private BufferedReader reader;


  public UserInput() throws IOException {

    reader = new BufferedReader(new InputStreamReader(System.in));

    //ask for user's name and print welcome message.
    welcomeMessage();

    // get the user's monthly income
    askForMonthlyIncome();

    //get user's  total debt including student loan, car loan, medical bills etc
    getMonthlyDebt();

    //Get User's Monthly Expenses
    getMonthlyExpenses();


    //Method to verify if user is a homeowner.

    isUserHomewonerOrRenter();

    //collect total monthly mortgage or rent of the user depending on whether they are homeowner or
    // a renter.
    collectTotalMortgageOrRent();

    Double totalDebt = profile.getTotalMonthlyDebtPayment();
    Double income = profile.getMonthlyIncome();
    double budgetAmount = income - totalDebt;



    if (budgetAmount < 0) {
      System.out.printf("%1$s , a budget can not be created for you at this time. "
              + "You are in debt. Please see a financial councillor as soon as possible.\n"
              + "Also consider the following options:\n"
              + "\t 1.\tEvaluate your fixed expenses and see if there’s any chance you can save money on them.\n"
              + "\t 2.\tIs there any opportunity to switch to a cheaper car insurance policy?\n"
              + "\t 3.\tCan you renegotiate your credit card interest to get a lower rate and pay off your debt faster?\n\n",
          profile.getName());
    } else if ( budgetAmount >0 && budgetAmount <= 0.65 * income) {

        System.out.printf(
            "%1$s, You are at high risk of falling into debt; please see a financial advisor.\n\n",profile.getName());
        displayBudgetBorderLine();
      }

      else  {
        System.out.printf("%s, You are on the right track! Keep it up.\n\n", profile.getName());
        displayBudgetGoodStanding();
      }

    System.out.printf("Thank you %1s for using the budgeting-tool\n", profile.getName());
  }

  public UserMonthlyExpenses getProfile() {
    return profile;
  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.\n");
    System.out.println("What is your name? :");
    String name = reader.readLine();
    profile.setName(name);
    System.out.println("Hello, " + profile.getName());
    String weekDay = new SimpleDateFormat("EEEE", Locale.US).format(date.getTime());
    System.out.println("Happy " + weekDay + "!!!  :) ");
    System.out.printf("%1$s,let us help you create a monthly budget.\n\n", profile.getName());

  }

  private void askForMonthlyIncome() throws IOException {
    while (true) {
      System.out.println("What is your monthly income after tax?");
      String monthlyIncomeStr = reader.readLine();
      try {
        profile.setMonthlyIncome(Double.parseDouble(monthlyIncomeStr));
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }

  }

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
        System.out.println("Please input correct option.");
      }
    }
  }


  public void getMonthlyDebt() throws IOException {

    //User prompt
    System.out.println(
        "\t\t\t.....MONTHLY DEBT PAYMENT.....\n"
            + "Monthly debt payments are any payments you make to "
            + "pay back a creditor or lender for money you borrowed.\n"
            + "Kindly enter '0' if debt category does not apply.\n");
    double sum = 0.0;
    for (DebtType type : DebtType.values()) {

      double debtx = 0.0;
      while (true) {
        System.out.println("Enter " + type + " Monthly payment");
        String debtStr = reader.readLine();

        try {
          debtx = Double.parseDouble(debtStr);
          profile.getDebts().add(new Debt(type, debtx));

          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }

      sum = sum + debtx;

    }
    profile.setBasicDebts(sum);
    System.out.printf("%1$s, your debt this month is: %2$s\n\n", profile.getName(), profile.getBasicDebts());


  }

  private void getMonthlyExpenses() throws IOException {

    System.out.println("\t\t\t.....MONTHLY EXPENSES......\nEnter '0' if expense does not apply\n");

    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
      double amount = 0;

      while (true) {

        System.out.println("Enter monthly amount spent on " + type );

        String totalMonthlyExpensesStr = reader.readLine();
        try {
          amount = Double.parseDouble(totalMonthlyExpensesStr);
          profile.getExpenses().add(new Expense(type, amount));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.\n");
        }
      }
      sum = sum + amount;
    }
    profile.setTotalMonthlyExpense(sum);
  }


  private void collectTotalMortgageOrRent() throws IOException {
    //If the user is a home owner, ask how much mortgage do they pay
    if (profile.homeOwner) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = reader.readLine();

        try {
          profile.monthlyMortgage = Double.parseDouble(mortgageStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Mortgage: \n" + fmt.format(profile.monthlyMortgage));

      profile.setMonthlyMortgage(profile.monthlyMortgage);
      //Calculates Total payment made in a month (expenses + basic debt + mortgage)


      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyMortgage()
              + profile.getTotalMonthlyExpense());

      // Get Total monthly payment and print out the amount
     // System.out.println(

    }

    //If the user is not a homeowner (renter), ask how much rent do they pay
    if (!profile.homeOwner) {
      while (true) {
        System.out.println("How much rent do you pay each month?");
        String rentStr = reader.readLine();
        try {
          profile.monthlyRent = Double.parseDouble(rentStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: \n" + fmt.format(profile.monthlyRent));
      profile.setMonthlyRent(profile.monthlyRent);

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyRent() + profile.getTotalMonthlyExpense());
     // System.out.println(
        //  "Monthly debt as a renter:  \n" + fmt.format(profile.getTotalMonthlyDebtPayment()));
    }


  }

  private void displayBudgetBorderLine() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(), profile.getTotalMonthlyDebtPayment());
    System.out.println("Amount available for budgeting:\t\t" + fmt.format(budget.budgetAmount()));
    System.out.printf("Recommended Savings: %2s\t\t\t%n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund:\t\t\t%2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food:\t\t\t%2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous:\t\t\t%2s%n",
        fmt.format(budget.calculateMiscellanous()));
  }

  private void displayBudgetGoodStanding() {
    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(), profile.getTotalMonthlyDebtPayment());
    System.out.println("Amount available for budgeting:\t\t" + fmt.format(budget.budgetAmount()));
    System.out.printf("Recommended Savings: %2s\t\t\t%n", fmt.format(budget.calculateSavingsG()));
    System.out.printf("Recommended EmergencyFund:\t\t\t%2s%n",
        fmt.format(budget.calculateEmergencyFundG()));
    System.out.printf("Recommended budget for Food:\t\t\t%2s%n",
        fmt.format(budget.calculateFoodBudgetG()));
    System.out.printf("Recommended Miscellaneous:\t\t\t%2s%n",
        fmt.format(budget.calculateMiscellanousG()));
  }


}
