package com.dng;

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

  private List<Debt> debts;
  private List <UserMonthlyExpenses> expense;
  static UserMonthlyExpenses debt = new UserMonthlyExpenses();

//  private List<UserMonthlyExpenses> userMonthlyExpense;
//  private BufferedReader reader;

  public UserInput() throws IOException {


 debt.reader = new BufferedReader(new InputStreamReader(System.in));
//    debt.userMonthlyExpense = new ArrayList<>();
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.PHONE_BILL, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.GROCERIES, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.GAS, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.WATER_BILL, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.INTERNET_BILL, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.ELECTRIC_BILL, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.MISCELLANEOUS, 0.00) );
//    debt.userMonthlyExpense.add(new UserMonthlyExpenses(MonthlyExpensesType.CAR_INSURANCE, 0.00) );

    debts = new ArrayList<>();
    debts.add(new Debt(DebtType.CAR_LOAN, 0.0));
    debts.add(new Debt(DebtType.CREDIT_CARDS, 0.0));
    debts.add(new Debt(DebtType.MEDICAL_BILLS, 0.0));
    debts.add(new Debt(DebtType.STUDENT_LOAN,  0.0));


    //ask user's name and print welcome message.
    welcomeMessage();

    //ask whether user is individual or family
    //isUserIndividualOrFamily();

    // get the user's monthly income
    askForMonthlyIncome();





    //get user's  total debt including student loan, car loan, medical bills etc
    getMonthlyDebt();

    //ask whether user is a homeowner or a renter.
    isUserHomewonerOrRenter();


    //collect total monthly mortgage or rent of the user depending on whether they are homeowner or
    // a renter.
    collectTotalMortgageOrRent();
    //Get User's Monthly Expenses
    //getMonthlyExpenses();
    BudgetItem budget = new BudgetItem(debt.getMonthlyIncome(), debt.totalMonthlyDebtPayment);
//    budget.budgetAmount();
    System.out.println("Amount available for budgeting: " + budget.budgetAmount());
    System.out.println("Recommended Savings : " + budget.calculateSavings());
    System.out.println("Recommended EmergencyFund: " + budget.calculateEmergencyFund());
    System.out.println("Recommended budget for Food : " + budget.calculateFoodBudget());
    System.out.println("Recommended Miscellaneous: " + budget.calculateMiscellanous());

  }

  private void welcomeMessage() throws IOException {
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = debt.reader.readLine();

    System.out.println("Hello, " + name);

    //System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
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


  private void askForMonthlyIncome() throws IOException {
    while (true) {
      System.out.println("What's your annual income?");
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





  public void getMonthlyDebt() throws IOException {
    double sum =0.0;
    for (int i = 0; i < debts.size(); i++) {

      double debtx=0.0;
      while(true) {
        System.out.println("Enter "+ debts.get(i).debtType + " Monthly payment");
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
      System.out.println("Monthly Mortgage: " + debt.monthlyMortgage);

      debt.setMonthlyMortgage(debt.monthlyMortgage);
      debt.setTotalMonthlyDebtPayment(debt.getBasicDebts() + debt.getMonthlyMortgage());

      System.out.println("Monthly debt:: "+ debt.getTotalMonthlyDebtPayment());
    }

    //If the user is not a home owner (renter), ask how much rent do they pay
    if (!debt.isHomeOwner) {
      while (true) {
        System.out.println("How much rent do yoy pay each month?");
        String rentStr = debt.reader.readLine();
        try {
          debt.monthlyRent = Double.parseDouble(rentStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: " + debt.monthlyRent);
      debt.setMonthlyRent(debt.monthlyRent);

      debt.setTotalMonthlyDebtPayment(debt.getBasicDebts() + debt.getMonthlyRent());
      System.out.println("Monthly debt as a renter:  "+debt.getTotalMonthlyDebtPayment());
    }

  }


//  private void getMonthlyExpenses() throws IOException {
//    for (int i = 0; i < debt.userMonthlyExpense.size(); i++) {
//      Double userMonthlyExpenses;
//      while (true) {
//
//        System.out.println("Enter monthly amount spent on " + debt.userMonthlyExpense.get(i).userMonthlyExpensesType + "?");
//        String totalMonthlyExpensesStr = debt.reader.readLine();
//        try {
//          debt.totalMonthlyExpenses = Double.parseDouble(totalMonthlyExpensesStr);
//          break;
//        } catch (NumberFormatException e) {
//          System.out.println("Incorrect Input. Please enter valid number.");
//        }
//      }
//      System.out.println("Your Monthly Payment: " + debt.totalMonthlyExpenses);
//    }
//  }



//  private void isUserIndividualOrFamily() throws IOException {
//    while (true) {
//      String individualOrFamily = debt.reader.readLine();
//      if (individualOrFamily.equalsIgnoreCase("i")) {
//        debt.userProfile = UserProfile.INDIVIDUAL;
//        break;
//      } else if (individualOrFamily.equalsIgnoreCase("f")) {
//        debt.userProfile = UserProfile.FAMILY;
//        break;
//      } else {
//        System.out.println("Please input correct option. I for Individual, F for Family.");
//      }
//    }
//    System.out.println("User Profile: " + debt.userProfile);
//  }





//  public UserProfile getUserProfile() {
//    return userProfile;
//  }
//
//  public void setUserProfile(UserProfile userProfile) {
//    this.userProfile = userProfile;
//  }
//
//  public boolean isHomeOwner() {
//    return isHomeOwner;
//  }
//
//  public void setHomeOwner(boolean homeOwner) {
//    isHomeOwner = homeOwner;
//  }
//
//  public Double getMonthlyMortgage() {
//    return monthlyMortgage;
//  }
//
//  public void setMonthlyMortgage(Double monthlyMortgage) {
//    this.monthlyMortgage = monthlyMortgage;
//  }
//
//  public Double getMonthlyRent() {
//    return monthlyRent;
//  }
//
//  public void setMonthlyRent(Double monthlyRent) {
//    this.monthlyRent = monthlyRent;
//  }
//
//
//  public Double getAnnualIncome() {
//    return annualIncome;
//  }
//  public void setAnnualIncome(Double annualIncome) {
//    this.annualIncome = annualIncome;
//  }
//
//  public void setTotalDebt(Double totalDebt) {
//  }
//
//  public Double getTotalMonthlyDebtPayment() {
//    return totalMonthlyDebtPayment;
//  }
//
//  public void setTotalMonthlyDebtPayment(Double totalMonthlyDebtPayment) {
//    this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
//  }
//
//  public Double getTotalMonthlyExpenses() {
//    return totalMonthlyExpenses;
//  }
//
//  public void setTotalMonthlyExpenses(Double totalMonthlyExpenses) {
//    this.totalMonthlyExpenses = totalMonthlyExpenses;
//  }
//
//  public Double getTotalAvailableBudget() {
//    return totalAvailableBudget;
//  }
//
//  public void setTotalAvailableBudget(Double totalAvailableBudget) {
//    this.totalAvailableBudget = totalAvailableBudget;
//  }
//
//  public boolean isEligibleForBudgeting() {
//    return isEligibleForBudgeting;
//  }
//
//  public void setEligibleForBudgeting(boolean eligibleForBudgeting) {
//    isEligibleForBudgeting = eligibleForBudgeting;
//  }


}
