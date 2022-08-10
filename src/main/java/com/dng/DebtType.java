package com.dng;

public enum DebtType {
  CAR_LOAN               ("Car Loan"),
  MEDICAL_BILLS          ("Medical Bills"),
  STUDENT_LOAN           ("Student Loans"),
  CREDIT_CARDS           ("Credit Cards");

 String debtName;

 DebtType(String debtName) {
   this.debtName = debtName;

 }

  @Override
  public String toString() {
    return debtName;
  }
}





