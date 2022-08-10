package com.dng;

public class UserMonthlyExpenses {
  UserMonthlyExpensesType userMonthlyExpensesType;
  double amount;

  public UserMonthlyExpenses(UserMonthlyExpensesType userMonthlyExpensesType, double amount) {
    this.userMonthlyExpensesType = userMonthlyExpensesType;
    this.amount = amount;
  }

  public UserMonthlyExpensesType getUserMonthlyExpensesType() {
    return userMonthlyExpensesType;
  }

  public void setDebtType(DebtType debtType) {
    this.userMonthlyExpensesType = userMonthlyExpensesType;
  }
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}
