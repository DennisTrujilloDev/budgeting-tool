package com.dng;

public class Debt {
  double carPayment;
  double  medicalBill;
  double  studentLoan;
  double  creditCardPayment;

  //Accessor methods
  public double  getCarPayment() {
    return carPayment;
  }

  public void setCarPayment(double carPayment) {
    this.carPayment = carPayment;
  }

  public double  getMedicalBill() {
    return medicalBill;
  }

  public void setMedicalBill(double  medicalBill) {
    this.medicalBill = medicalBill;
  }

  public double  getStudentLoan() {
    return studentLoan;
  }

  public void setStudentLoan(int studentLoan) {
    this.studentLoan = studentLoan;
  }

  public double getCreditCardPayment() {
    return creditCardPayment;
  }

  public void setCreditCardPayment(int creditCardPayment) {
    this.creditCardPayment = creditCardPayment;
  }
}
