package com.dng;

public enum ExpenseType {

//  ELECTRIC_BILL,
//  INTERNET_BILL,
//  WATER_BILL,
//  PHONE_BILL,
//  GROCERIES,
//  CAR_INSURANCE,
//  GAS,
//  MISCELLANEOUS // i.e. Shopping and Emergency expenses

  ELECTRIC_BILL            ("Electric Bill"),
  INTERNET_BILL            ("Internet Bill"),
  WATER_BILL               ("Water Bill"),
  PHONE_BILL               ("Phone Bill"),
  GROCERIES                ("Groceries"),
  CAR_INSURANCE            ("Car Insurance"),
  GAS                      ("Gas"),
  MISCELLANEOUS            ("Miscellaneous");                                      // i.e. Shopping and Emergency expenses
  String expenseName;
  ExpenseType(String expenseName) {
    this.expenseName = expenseName;
  }

  @Override
  public String toString() {
    return expenseName;
  }

}
