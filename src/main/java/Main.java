import java.util.Scanner;

public class Main {

  private static UserProfile userProfile;
  private static boolean isHomeOwner;
  private static Integer monthlyMortgage;
  private static Integer monthlyRent;
  private static Integer annualIncome;
  private static Integer totalDebt;
  private static Integer totalMonthlyDebtPayment;
  private static Integer totalMonthlyExpenses;
  private static Integer totalAvailableBudget;
  private static boolean isEligibleForBudgeting;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //ask user's name and print welcome message.
    welcomeMessage(sc);

    //ask whether user is individual or family
    isUserIndividualOrFamily(sc);

    //ask whether user is a homeowner or a renter.
    isUserHomewonerOrRenter(sc);

    //collect total monthly mortgage or rent of the user depending on whether they are homeowner or
    // a renter.
    collectTotalMortgageOrRent(sc);

    // get the user's annual income
    getAnnualIncome(sc);

    //get user's  total debt including student loan, car loan, medical bills etc
    getTotalDebt(sc);

    //Get User's Monthly Debt Payment
    getMonthlyDebtPayment(sc);

    //Get User's Monthly Expenses
    getMonthlyExpenses(sc);

    //Calculate Total amount available for budgeting each month. Total available budget is
    // annualIncome/12 - total debt - total monthly expense.
    calculateAvailableBudget();

    //if the user is saving less than 20% of their income, they are eligible for budgeting
    determineBudgetingEligibility();
  }

  private static void determineBudgetingEligibility() {
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

  private static void calculateAvailableBudget() {
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

  private static void getMonthlyExpenses(Scanner sc) {
    while (true) {
      System.out.println("How much do you pay each month in expenses?");
      String totalExpensesStr = sc.nextLine();
      try {
        totalMonthlyExpenses = Integer.parseInt(totalExpensesStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your Monthly Payment: " + totalMonthlyExpenses);
  }

  private static void getMonthlyDebtPayment(Scanner sc) {
    while (true) {
      System.out.println("How much debt do you pay each month in total?");
      String totalPaymentStr = sc.nextLine();
      try {
        totalMonthlyDebtPayment = Integer.parseInt(totalPaymentStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your Monthly Payment: " + totalMonthlyDebtPayment);
  }

  private static void getTotalDebt(Scanner sc) {
    while (true) {
      System.out.println("How much debt do you have?");
      String debtStr = sc.nextLine();
      try {
        totalDebt = Integer.parseInt(debtStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your debt: " + totalDebt);
  }

  private static void getAnnualIncome(Scanner sc) {
    while (true) {
      System.out.println("What's your annual income?");
      String annualIncomeStr = sc.nextLine();
      try {
        annualIncome = Integer.parseInt(annualIncomeStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Annual Income: " + annualIncome);
  }

  private static void collectTotalMortgageOrRent(Scanner sc) {
    //If the user is a home owner, ask how much mortgage do they pay
    if (isHomeOwner) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = sc.nextLine();

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
        String rentStr = sc.nextLine();
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

  private static void isUserHomewonerOrRenter(Scanner sc) {
    while (true) {
      System.out.println("Are you a home owner? Y for Yes, N for No.");
      String homeOwner = sc.nextLine();
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

  private static void isUserIndividualOrFamily(Scanner sc) {
    while (true) {
      String individualOrFamily = sc.nextLine();
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

  private static void welcomeMessage(Scanner sc) {
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = sc.nextLine();

    System.out.println("Hello, " + name);

    System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
  }
}