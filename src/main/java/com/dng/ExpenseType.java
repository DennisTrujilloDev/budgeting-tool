package com.dng;

/**
 * This class represents the different kinds of expenses a user has.
 */
public enum ExpenseType {

  ELECTRIC_BILL            ("electric bill"),
  INTERNET_BILL            ("internet bill"),
  WATER_BILL               ("water bill"),
  PHONE_BILL               ("phone bill"),
  GROCERIES                ("groceries"),
  CAR_INSURANCE            ("car insurance"),
  GAS                      ("gas"),
  MISCELLANEOUS            ("miscellaneous");
  private final String expenseName;
  /**
   * This constructor instantiates the enum constants.
   * @param expenseName the type of expense specified
   */
  ExpenseType(String expenseName) {
    this.expenseName = expenseName;
  }

  /**
   * This method overrides the toString method, modifying the way the enum constants can be displayed.
   * @return a readable string representation of the types of expenses a user may have.
   */
  @Override
  public String toString() {
    return expenseName;
  }

}
