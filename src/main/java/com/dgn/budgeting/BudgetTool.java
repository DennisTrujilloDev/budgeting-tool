package com.dgn.budgeting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class BudgetTool {

//  private final String BUNDLE_NAME = "messages";
//  private BufferedReader buffer;
  //should be final?
//  private ResourceBundle bundle;
//should be final?

  String userName;
  //  String continueOrExit;
  int familySize;
  String rentOrOwn;
  String debtOrNo;

  double monthlySalary;
  double miscellaneous;
  double monthlyExpenses;
  double debtTotal;


  double carDebt;
  double studentDebt;
  double ccDebt;
  double medicalDebt;
  double amountForBudgeting;
  //if amountForBudgeting is less than 10% of user income
  //qualify for budgeting




  //option to keep using tool
  public BudgetTool() {
//    bundle = ResourceBundle.getBundle(BUNDLE_NAME);
//    buffer = new BufferedReader(new InputStreamReader(System.in));
//    String nameInput = bundle.getString(pleaseInputName);
//    System.out.printf(nameInput);
  }

  public BudgetTool(String name, int familySize, String rentOrOwn, String debtOrNo,
      double monthlySalary, double miscellaneous, double monthlyExpenses, double debtTotal) {
    if (name.length()>0) {
      this.userName = name;
    }
    if (familySize>0){
      this.familySize = familySize;
    }
    if (rentOrOwn.equalsIgnoreCase("R") || rentOrOwn.equalsIgnoreCase("O")) {
      this.rentOrOwn = rentOrOwn;
    }
    if (debtOrNo.equalsIgnoreCase("Y") || debtOrNo.equalsIgnoreCase("N")){
      this.debtOrNo = debtOrNo;
    }
    if (monthlySalary >0){
      this.monthlySalary = monthlySalary;
    }
    if(miscellaneous>0){
      this.miscellaneous = miscellaneous;
    }
    if(monthlyExpenses>0){
      this.monthlyExpenses = monthlyExpenses;
    }
    if(debtTotal!=0) {
      this.debtTotal = debtTotal;
    }
  }



}