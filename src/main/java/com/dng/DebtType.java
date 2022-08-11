
package com.dng;
public enum DebtType {
  CAR_LOAN               ("car loan"),
  MEDICAL_BILLS          ("medical bills"),
  STUDENT_LOAN           ("student loans"),
  CREDIT_CARDS           ("credit cards");
  private final String debtName;

  DebtType(String debtName) {
    this.debtName = debtName;
  }

  @Override
  public String toString() {
    return debtName;
  }
}



