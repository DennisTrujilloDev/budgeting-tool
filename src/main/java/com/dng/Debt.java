package com.dng;

/**
 * This class represents the debt, generally speaking, that a user may have.
 */
public class Debt {

  private final DebtType debtType;
  private final double amount;

  /**
   * This constructor initiates any instances of the class.
   * @param debtType the type of debt the user has
   * @param amount the dollar amount of the user's debt
   */
  public Debt(DebtType debtType, double amount) {
    this.debtType = debtType;
    this.amount = amount;
  }

}
