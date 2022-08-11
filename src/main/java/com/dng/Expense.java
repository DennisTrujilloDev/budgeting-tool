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

}
