package com.dng;

/**
 * This class represents the different kinds of expenses a user has.
 */
public enum ExpenseType {

  ELECTRIC_BILL            ("Electric Bill"),
  INTERNET_BILL            ("Internet Bill"),
  WATER_BILL               ("Water Bill"),
  PHONE_BILL               ("Phone Bill"),
  GROCERIES                ("Groceries"),
  CAR_INSURANCE            ("Car Insurance"),
  GAS                      ("Gas"),
  MISCELLANEOUS            ("Miscellaneous");  // i.e. Shopping and Emergency expenses


  final String expenseName;
  /**
   * This constructor instantiates the enum constants.
   * @param expenseName the type of expense specified
   */
  ExpenseType(String expenseName) {
    this.expenseName = expenseName;
  }

  /**
   * This method overrides the toString method, modifying the way the enum constants can be displayed.
   */
  @Override
  public String toString() {
    return expenseName;
  }

}
