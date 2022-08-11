package com.dng;

/**
 * This class represents the debt, generally speaking, that a user may have.
 */
public class Debt {

  private final DebtType debtType;
  private final double amount;

  /**
   * This constructor initiates the instances of the class.
   * @param debtType the type of debt the user has
   * @param amount the dollar amount of the user's debt
   */
  public Debt(DebtType debtType, double amount) {
    this.debtType = debtType;
    this.amount = amount;
  }

//  public DebtType getDebtType() {
//    return debtType;
//  }
//
//  public void setDebtType(DebtType debtType) {
//    this.debtType = debtType;
//  }
//
//  public double getAmount() {
//    return amount;
//  }
//
//  public void setAmount(double amount) {
//    this.amount = amount;
//  }


}
