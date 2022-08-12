package com.dng;

/**
 * This class is used to represent the debt that a user may have. It works with the DebtType class
 * to hold the sets of values (debt type and amount) which organize and facilitate calculations.
 */

public class Debt {

  private final DebtType debtType;
  private final double amount;

  /**
   * This constructor initiates any instances of the class.
   *
   * @param debtType the type of debt the user has
   * @param amount   the dollar amount of the user's debt
   */
  public Debt(DebtType debtType, double amount) {
    this.debtType = debtType;
    this.amount = amount;
  }

}
