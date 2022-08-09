import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

  private static UserProfile userProfile;
  private static boolean isHomeOwner;
  private static Integer mortgage;
  private static Integer rent;
  private static Integer annualIncome;
  private static Integer debt;
  private static double interestRate;


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = sc.nextLine();

    System.out.println("Hello, " + name);

    System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");

    while(true) {
      String individualOrFamily = sc.nextLine();
      if(individualOrFamily.equalsIgnoreCase("i")) {
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

    System.out.println("Are you a home owner? Y for Yes, N for No.");
    String homeOwner = sc.nextLine();

    while(true) {
      if(homeOwner.equalsIgnoreCase("y")) {
        isHomeOwner = true;
        break;
      } else if (homeOwner.equalsIgnoreCase("n")) {
        isHomeOwner = false;
        break;
      } else {
        System.out.println("Please input correct option. Y for Yes, N for No. Are you a home owner?");
      }
    }

    //If the user is a home owner, ask how much mortgage do they pay
    if(isHomeOwner) {
      while (true) {
        System.out.println("How much do you pay in mortgage each month?");
        String mortgageStr = sc.nextLine();

        try {
          mortgage = Integer.parseInt(mortgageStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Mortgage: " + mortgage);
    }

    //If the user is not a home owner (renter), ask how much rent do they pay
    if(!isHomeOwner) {
      while(true) {
        System.out.println("How much rent do yoy pay each month?");
        String rentStr = sc.nextLine();
        try {
          rent = Integer.parseInt(rentStr);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Incorrect Input. Please enter valid number.");
        }
      }
      System.out.println("Monthly Rent: " + rent);
    }

    // Ask user for their annual income
    while (true) {
      System.out.println("What's your annual income?");
      String annualIncomeStr = sc.nextLine();
      try {
        annualIncome = Integer.parseInt(annualIncomeStr);
        break;
      } catch (NumberFormatException e){
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Annual Income: " + annualIncome);

    //Collect user's debt

    while(true) {
      System.out.println("How much debt do you have?");
      String debtStr = sc.nextLine();
      try {
        debt = Integer.parseInt(debtStr);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Incorrect Input. Please enter valid number.");
      }
    }
    System.out.println("Your debt: " + debt);
  }
}