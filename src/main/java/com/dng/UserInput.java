package com.dng;

import java.text.NumberFormat;
import java.util.Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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

//  private List<Debt> debts;
  //private List<UserProfile> userProfile;

 private UserMonthlyExpenses profile = new UserMonthlyExpenses();

 private BufferedReader reader;


//  private BufferedReader reader;

  public UserInput() throws IOException {

    reader = new BufferedReader(new InputStreamReader(System.in));



//    debts = new ArrayList<>();
//    debts.add(new Debt(DebtType.CAR_LOAN, 0.0));
//    debts.add(new Debt(DebtType.CREDIT_CARDS, 0.0));
//    debts.add(new Debt(DebtType.MEDICAL_BILLS, 0.0));
//    debts.add(new Debt(DebtType.STUDENT_LOAN, 0.0));


//    debt.expenses = new ArrayList<>();
//
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.PHONE_BILL, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.GROCERIES, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.GAS, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.WATER_BILL, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.INTERNET_BILL, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.ELECTRIC_BILL, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.MISCELLANEOUS, 0.00));
//    debt.expenses.add(new UserMonthlyExpenses(ExpenseType.CAR_INSURANCE, 0.00));

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



    BudgetItem budget = new BudgetItem(profile.getMonthlyIncome(), profile.totalMonthlyDebtPayment);

    System.out.println("Amount available for budgeting:" + fmt.format(budget.budgetAmount()));
    System.out.printf("Recommended Savings: %2s %n", fmt.format(budget.calculateSavings()));
    System.out.printf("Recommended EmergencyFund: %2s%n",
        fmt.format(budget.calculateEmergencyFund()));
    System.out.printf("Recommended budget for Food: %2s%n",
        fmt.format(budget.calculateFoodBudget()));
    System.out.printf("Recommended Miscellaneous: %2s%n",
        fmt.format(budget.calculateMiscellanous()));

  }

  public UserMonthlyExpenses getProfile() {
    return profile;
  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = reader.readLine();

    System.out.println("Hello, " + name);

    //System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
  }

  private void askForMonthlyIncome() throws IOException {
    while (true) {
      System.out.println("What is your monthly income?");
      String monthlyIncomeStr = reader.readLine();
      try {
        profile.setMonthlyIncome(Double.parseDouble(monthlyIncomeStr));
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Annual Income: " + profile.monthlyIncome);
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
    System.out.println("     {{DEBTS}}\nEnter '0' if debt category does not apply ");
    double sum = 0.0;
    for (DebtType type: DebtType.values()) {
//      for (int i = 0; i < debts.size(); i++) {

      double debtx = 0.0;
      while (true) {
        System.out.println("Enter " + type + " Monthly payment");
        String debtStr = reader.readLine();

        try {
          debtx = Double.parseDouble(debtStr);
          profile.getDebts().add(new Debt(type,debtx));

          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }

      System.out.println(String.format("Your %s debt: %s", type, debtx));
      sum = sum + debtx;

    }
    System.out.println("basic debt total: " + sum);
    profile.setBasicDebts(sum);


  }

  private void getMonthlyExpenses() throws IOException {

    System.out.println("     {{EXPENSES}}\nEnter '0' if expense does not apply ");

    double sum = 0.0;
    for (ExpenseType type : ExpenseType.values()) {
//     for (int i = 0; i < debt.userMonthlyExpense.size(); i++) {
      double amount = 0;

      while (true) {

        System.out.println("Enter monthly amount spent on " + type + "?");
        //System.out.println("Enter monthly amount spent on " + debt.userMonthlyExpense.get(i).expensesType + "?");

        String totalMonthlyExpensesStr = reader.readLine();
        try {
          amount = Double.parseDouble(totalMonthlyExpensesStr);
          profile.getExpenses().add(new Expense(type, amount));
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Your Monthly Payment: " + amount);
      sum = sum + amount;
    }
    System.out.println("basic expense total: " + fmt.format(sum));
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
      System.out.println("Monthly Mortgage: " + fmt.format(profile.monthlyMortgage));

      profile.setMonthlyMortgage(profile.monthlyMortgage);
      //Calculates Total payment made in a month (expenses + basic debt + mortgage)

      //TODO add miscellaneous expenses

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyMortgage()+ profile.getTotalMonthlyExpense());

      // Get Total monthly payment and print out the amount
      System.out.println("Monthly debt homeowner:: " + fmt.format(profile.getTotalMonthlyDebtPayment()));
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
      System.out.println("Monthly Rent: " + fmt.format(profile.monthlyRent));
      profile.setMonthlyRent(profile.monthlyRent);

      profile.setTotalMonthlyDebtPayment(
          profile.getBasicDebts() + profile.getMonthlyRent()+ profile.getTotalMonthlyExpense());
      System.out.println("Monthly debt as a renter:  " + fmt.format(profile.getTotalMonthlyDebtPayment()));
    }

  }





}
