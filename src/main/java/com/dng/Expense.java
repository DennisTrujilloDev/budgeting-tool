package com.dng;

public class Expense {
//
  //TODO Make field private
  ExpenseType expenseType;

  double totalExpense;

  public Expense(ExpenseType expenseType, double amount) {
    this.expenseType = expenseType;
    this.totalExpense = amount;
  }

  public ExpenseType getExpenseType() {

    return expenseType;
  }

  public void setExpenseType(ExpenseType expenseType) {
    this.expenseType = expenseType;
  }

  public double getAmount() {
    return totalExpense;
  }

  public void setAmount(double amount) {
    this.totalExpense = amount;
  }
}
