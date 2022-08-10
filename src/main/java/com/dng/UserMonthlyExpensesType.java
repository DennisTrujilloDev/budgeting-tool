package com.dng;

public enum UserMonthlyExpensesType {

  ELECTRIC_BILL            ("Electric Bill"),
  INTERNET_BILL            ("Internet Bill"),
  WATER_BILL               ("Water Bill"),
  PHONE_BILL               ("Phone Bill"),
  GROCERIES                ("Groceries"),
  CAR_INSURANCE            ("Car Insurance"),
  GAS                      ("Gas"),
  MISCELLANEOUS            ("Miscellaneous");                                      // i.e. Shopping and Emergency expenses

  String expenseName;

  UserMonthlyExpensesType(String debtName) {
    this.expenseName = expenseName;

  }

  @Override
  public String toString() {
    return expenseName;
  }
  }



