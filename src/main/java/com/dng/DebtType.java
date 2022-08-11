package com.dng;

/**
 * This class represents the types of debt a user may have.
 */
public enum DebtType {
  CAR_LOAN               ("car loan"),
  MEDICAL_BILLS          ("medical bills"),
  STUDENT_LOAN           ("student loans"),
  CREDIT_CARDS           ("credit cards");
  private final String debtName;

  /**
   * This constructor instantiates the enum constants.
   * @param debtName the type of debt specified
   */
  DebtType(String debtName) {
    this.debtName = debtName;
  }

  /**
   * This method overrides the toString method, modifying the way the enum constants can be displayed.
   * @return a readable string representation of the types of debt.
   */
  @Override
  public String toString() {
    return debtName;
  }
}



