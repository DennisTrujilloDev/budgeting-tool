package com.dng;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class UserMonthlyExpenses {

  public String userMonthlyExpensesType;

  String name;

  boolean homeOwner;
  Double monthlyMortgage = 0.0;
  Double monthlyRent = 0.0;
  Double monthlyIncome = 0.0;
  Double totalMonthlyDebtPayment = 0.0;
  Double totalMonthlyExpenses = 0.0;

  Double basicDebts=0.0;
  Double totalAvailableBudget = 0.0;

  Double totalMonthlyExpense=0.0;
  boolean isEligibleForBudgeting = false;
  List<Debt> debts = new ArrayList<>();
  List<Expense> expenses = new ArrayList<>();


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isHomeOwner() {
    return homeOwner;
  }

  public void setHomeOwner(boolean homeOwner) {
    this.homeOwner = homeOwner;
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

  public List<Expense> getExpenses() {
    return expenses;
  }

  public Double getBasicDebts() {
    return basicDebts;
  }

  public void setBasicDebts(Double basicDebts) {
    this.basicDebts = basicDebts;
  }

  public Double getTotalMonthlyExpense() {
    return totalMonthlyExpense;
  }

  public void setTotalMonthlyExpense(Double totalMonthlyExpense) {
    this.totalMonthlyExpense = totalMonthlyExpense;
  }


  public UserMonthlyExpenses() {
  }


}
