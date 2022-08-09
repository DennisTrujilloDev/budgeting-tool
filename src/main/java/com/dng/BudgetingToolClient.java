package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BudgetingToolClient {

  public BudgetingToolClient() {
  }

  public void userInputOne() throws IOException {

    int income = 0;
    int debt = 0;
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter your income: ");
      income = Integer.parseInt(reader.readLine());
      System.out.println("Enter your debt: ");
      debt = Integer.parseInt(reader.readLine());
    } catch (NumberFormatException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    BudgetCandidates ab = new BudgetCandidates(income, debt);
  }

  public void userInputTwo() throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter monthly Car payement: ");
    int carpayment = Integer.parseInt(reader.readLine());
    System.out.println("Enter medical bills: ");
    int medicalBills = Integer.parseInt(reader.readLine());
    BudgetCandidates ab = new BudgetCandidates(carpayment, medicalBills);
  }
}
