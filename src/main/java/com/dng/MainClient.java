package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainClient {

  public static void main(String[] args) throws IOException {

    // Accept income and debt from users.

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter your income: ");
    int income = Integer.parseInt(reader.readLine());
    System.out.println("Enter your debt: ");
    int debt = Integer.parseInt(reader.readLine());
    BudgetCandidates ab = new BudgetCandidates(income, debt);


    System.out.println("Recommended Savings : " + ab.calculateSavings());
    System.out.println("Recommended EmergencyFund: " + ab.calculateEmergencyFund());
    System.out.println("Recommended budget for Food : " + ab.calculateFoodBudget());
    System.out.println("Recommended Miscellaneous: " + ab.calculateMiscellanous());



  }

}
