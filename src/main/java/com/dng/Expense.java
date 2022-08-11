package com.dng;
/**
 * This class represents the general expenses that a user has.
 */
public class Expense {

  private final ExpenseType expenseType;
  private final double totalExpense;

  /**
   * This constructor initiates any instances of the class.
   * @param expenseType the type of expense the user has
   * @param amount the dollar amount of the user's expenses
   */
  public Expense(ExpenseType expenseType, double amount) {
    this.expenseType = expenseType;
    this.totalExpense = amount;
  }

//  public ExpenseType getExpenseType() {
//    return expenseType;
//  }
//
//  public void setExpenseType(ExpenseType expenseType) {
//    this.expenseType = expenseType;
//  }
//
//  public double getAmount() {
//    return totalExpense;
//  }
//
//  public void setAmount(double amount) {
//    this.totalExpense = amount;
//  }
}
