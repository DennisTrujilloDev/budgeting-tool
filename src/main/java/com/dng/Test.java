package com.dng;

import java.io.BufferedReader;
import java.util.List;

public class Test {

  //UserProfile userProfile;
   boolean isHomeOwner;
  Double monthlyMortgage = 0.0;
   Double monthlyRent = 0.0;
  Double annualIncome  = 0.0;
   Double totalMonthlyDebtPayment = 0.0;
   Double totalMonthlyExpenses = 0.0;
  Double totalAvailableBudget = 0.0;
  boolean isEligibleForBudgeting = false;
  List<Debt> debts;
  List<UserMonthlyExpenses> userMonthlyExpense;
  BufferedReader reader;


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

  public Double getAnnualIncome() {
    return annualIncome;
  }

  public void setAnnualIncome(Double annualIncome) {
    this.annualIncome = annualIncome;
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
}
