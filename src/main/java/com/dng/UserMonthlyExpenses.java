package com.dng;

import java.io.BufferedReader;
import java.util.List;


public class UserMonthlyExpenses {

  //UserProfile userProfile;
  boolean isHomeOwner;
  Double monthlyMortgage = 0.0;
  Double monthlyRent = 0.0;
  Double monthlyIncome = 0.0;
  Double totalMonthlyDebtPayment = 0.0;
  Double totalMonthlyExpenses = 0.0;

  Double basicDebts=0.0;
  Double totalAvailableBudget = 0.0;
  boolean isEligibleForBudgeting = false;
  List<Debt> debts;
  List<UserMonthlyExpenses> userMonthlyExpense;
  BufferedReader reader;

//


//  public UserProfile getUserProfile() {
//    return userProfile;
//  }
//
//  public void setUserProfile(UserProfile userProfile) {
//    this.userProfile = userProfile;
//  }

  public boolean isHomeOwner() {
    return isHomeOwner;
  }

  public void setHomeOwner(boolean homeOwner) {
    isHomeOwner = homeOwner;
  }

  public Double getMonthlyMortgage() {
    return monthlyMortgage;
  }

  public void setMonthlyMortgage(Double monthlyMortgage) {
    this.monthlyMortgage = monthlyMortgage;
  }

  public Double getMonthlyRent() {
    return monthlyRent;
  }

  public void setMonthlyRent(Double monthlyRent) {
    this.monthlyRent = monthlyRent;
  }

  public Double getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setMonthlyIncome(Double monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  public Double getTotalMonthlyDebtPayment() {
    return totalMonthlyDebtPayment;
  }

  public void setTotalMonthlyDebtPayment(Double totalMonthlyDebtPayment) {
    this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
  }

  public Double getTotalMonthlyExpenses() {
    return totalMonthlyExpenses;
  }

  public void setTotalMonthlyExpenses(Double totalMonthlyExpenses) {
    this.totalMonthlyExpenses = totalMonthlyExpenses;
  }

  public Double getTotalAvailableBudget() {
    return totalAvailableBudget;
  }

  public void setTotalAvailableBudget(Double totalAvailableBudget) {
    this.totalAvailableBudget = totalAvailableBudget;
  }

  public boolean isEligibleForBudgeting() {
    return isEligibleForBudgeting;
  }

  public void setEligibleForBudgeting(boolean eligibleForBudgeting) {
    isEligibleForBudgeting = eligibleForBudgeting;
  }

  public List<Debt> getDebts() {
    return debts;
  }

  public void setDebts(List<Debt> debts) {
    this.debts = debts;
  }

  public List<UserMonthlyExpenses> getUserMonthlyExpense() {
    return userMonthlyExpense;
  }

  public void setUserMonthlyExpense(List<UserMonthlyExpenses> userMonthlyExpense) {
    this.userMonthlyExpense = userMonthlyExpense;
  }

  public BufferedReader getReader() {
    return reader;
  }

  public void setReader(BufferedReader reader) {
    this.reader = reader;
  }

  public Double getBasicDebts() {
    return basicDebts;
  }

  public void setBasicDebts(Double basicDebts) {
    this.basicDebts = basicDebts;
  }

  //  public MonthlyExpensesType getUserMonthlyExpensesType() {
//    return userMonthlyExpensesType;
//  }
//
//  public void setUserMonthlyExpensesType(MonthlyExpensesType userMonthlyExpensesType) {
//    this.userMonthlyExpensesType = userMonthlyExpensesType;
//  }
//
//  MonthlyExpensesType userMonthlyExpensesType;
//  double amount;

  public UserMonthlyExpenses() {
  }

//  public UserMonthlyExpenses(MonthlyExpensesType userMonthlyExpensesType, double amount) {
//    this.userMonthlyExpensesType = userMonthlyExpensesType;
//    this.amount = amount;
//  }
//
//  public MonthlyExpensesType getUserMonthlyExpensesType() {
//    return userMonthlyExpensesType;
//  }

//  public void setDebtType(DebtType debtType) {
//    this.userMonthlyExpensesType = userMonthlyExpensesType;
//  }
//  public double getAmount() {
//    return amount;
//  }
//
//  public void setAmount(double amount) {
//    this.amount = amount;
//  }


}
