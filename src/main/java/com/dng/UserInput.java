package com.dng;

import com.dng.view.UserProfile;
import com.dng.view.UserProfileType;
import java.text.NumberFormat;
import java.util.Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class UserInput {

  //private UserProfile userProfile;
//  private boolean isHomeOwner;
//  private Double monthlyMortgage = 0.0;
//  private Double monthlyRent = 0.0;
//  private Double annualIncome  = 0.0;
//  private Double totalMonthlyDebtPayment = 0.0;
//  private Double totalMonthlyExpenses = 0.0;
//  private Double totalAvailableBudget = 0.0;
//  private boolean isEligibleForBudgeting = false;


  Locale locale = new Locale("en", "US");
  NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
//System.out.println(fmt.format(120.00));

  private List<Debt> debts;
  //private List<UserProfile> userProfile;

 static UserMonthlyExpenses debt = new UserMonthlyExpenses();

 private List<UserMonthlyExpenses> userMonthlyExpense;
//  private BufferedReader reader;

  public UserInput() throws IOException {

    debt.reader = new BufferedReader(new InputStreamReader(System.in));



    debts = new ArrayList<>();
    debts.add(new Debt(DebtType.CAR_LOAN, 0.0));
    debts.add(new Debt(DebtType.CREDIT_CARDS, 0.0));
    debts.add(new Debt(DebtType.MEDICAL_BILLS, 0.0));
    debts.add(new Debt(DebtType.STUDENT_LOAN, 0.0));


    debt.userMonthlyExpense = new ArrayList<>();

    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.PHONE_BILL, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.GROCERIES, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.GAS, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.WATER_BILL, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.INTERNET_BILL, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.ELECTRIC_BILL, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.MISCELLANEOUS, 0.00));
    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.CAR_INSURANCE, 0.00));

    //ask for user's name and print welcome message.
    welcomeMessage();

    // get the user's monthly income
    askForMonthlyIncome();

    //get user's  total debt including student loan, car loan, medical bills etc
    getMonthlyDebt();
    //ask whether user is a homeowner or a renter.

    isUserHomewonerOrRenter();

    //Get User's Monthly Expenses
    getMonthlyExpenses();

    //collect total monthly mortgage or rent of the user depending on whether they are homeowner or
    // a renter.
    collectTotalMortgageOrRent();



    BudgetItem budget = new BudgetItem(debt.getMonthlyIncome(), debt.totalMonthlyDebtPayment);

    System.out.println("Amount available for budgeting:" + fmt.format(budget.budgetAmount()));
    System.out.printf("Recommended Savings: %2s %n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget.calculateMiscellanous()));

  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = debt.reader.readLine();

    System.out.println("Hello, " + name);

    //System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
  }

  private void askForMonthlyIncome() throws IOException {
    while (true) {
      System.out.println("What is your monthly income?");
      String monthlyIncomeStr = debt.reader.readLine();
      try {
        debt.monthlyIncome = Double.parseDouble(monthlyIncomeStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Annual Income: " + debt.monthlyIncome);
  }

  private void isUserHomewonerOrRenter() throws IOException {
    while (true) {
      System.out.println("Are you a home owner? Y for Yes, N for No.");
      String homeOwner = debt.reader.readLine();
      if (homeOwner.equalsIgnoreCase("y")) {
        debt.isHomeOwner = true;
        break;
      } else if (homeOwner.equalsIgnoreCase("n")) {
        debt.isHomeOwner = false;
        break;
      } else {
        System.out.println("Please input correct option.");
      }
    }
  }


  public void getMonthlyDebt() throws IOException {

    //User prompt
    System.out.println("     {{DEBTS}}\nEnter '0' if debt category does not apply ");
    double sum = 0.0;
    for (int i = 0; i < debts.size(); i++) {

      double debtx = 0.0;
      while (true) {
        System.out.println("Enter " + debts.get(i).debtType + " Monthly payment");
        String debtStr = debt.reader.readLine();

        try {
          debtx = Double.parseDouble(debtStr);
          debts.get(i).setAmount(debtx);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }

      System.out.println(String.format("Your %s debt: %s", debts.get(i).debtType, debtx));
      sum = sum + debtx;

    }
    System.out.println("basic debt total: " + sum);
    debt.setBasicDebts(sum);


  }

  private void getMonthlyExpenses() throws IOException {

    System.out.println("     {{EXPENSES}}\nEnter '0' if expense does not apply ");

    double sum = 0.0;
    for (int i = 0; i < debt.userMonthlyExpense.size(); i++) {

      while (true) {

        System.out.println("Enter monthly amount spent on " + debt.userMonthlyExpense.get(i).userMonthlyExpensesType+ "?");
        String totalMonthlyExpensesStr = debt.reader.readLine();
        try {
          debt.totalMonthlyExpenses = Double.parseDouble(totalMonthlyExpensesStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Your Monthly Payment: " + debt.totalMonthlyExpenses);
      sum = sum + debt.totalMonthlyExpenses;
    }
    System.out.println("basic expense total: " + fmt.format(sum));
    debt.setTotalMonthlyExpense(sum);
  }


  private void collectTotalMortgageOrRent() throws IOException {
    //If the user is a home owner, ask how much mortgage do they pay
    if (debt.isHomeOwner) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = debt.reader.readLine();

        try {
          debt.monthlyMortgage = Double.parseDouble(mortgageStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Mortgage: " + fmt.format(debt.monthlyMortgage));

      debt.setMonthlyMortgage(debt.monthlyMortgage);
      //Calculates Total payment made in a month (expenses + basic debt + mortgage)

      //TODO add miscellaneous expenses

      debt.setTotalMonthlyDebtPayment(debt.getBasicDebts() + debt.getMonthlyMortgage()+ debt.getTotalMonthlyExpense());

      // Get Total monthly payment and print out the amount
      System.out.println("Monthly debt homeowner:: " + fmt.format(debt.getTotalMonthlyDebtPayment()));
    }

    //If the user is not a homeowner (renter), ask how much rent do they pay
    if (!debt.isHomeOwner) {
      while (true) {
        System.out.println("How much rent do you pay each month?");
        String rentStr = debt.reader.readLine();
        try {
          debt.monthlyRent = Double.parseDouble(rentStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: " + fmt.format(debt.monthlyRent));
      debt.setMonthlyRent(debt.monthlyRent);

      debt.setTotalMonthlyDebtPayment(debt.getBasicDebts() + debt.getMonthlyRent()+ debt.getTotalMonthlyExpense());
      System.out.println("Monthly debt as a renter:  " + fmt.format(debt.getTotalMonthlyDebtPayment()));
    }

  }





}
