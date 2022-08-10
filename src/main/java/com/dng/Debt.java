package com.dng;

public class Debt {
  DebtType debtType;
  double amount;

  public Debt(DebtType debtType, double amount) {
    this.debtType = debtType;
    this.amount = amount;
  }

  public DebtType getDebtType() {
    return debtType;
  }

  public void setDebtType(DebtType debtType) {
    this.debtType = debtType;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}
