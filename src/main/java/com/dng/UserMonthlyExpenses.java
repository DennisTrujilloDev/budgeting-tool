package com.dng;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for holding the values that are recorded from the user's input,
 * inclusing
 */
public class UserMonthlyExpenses {

  private String name;
  private boolean homeOwner;
  private Double monthlyMortgage = 0.0;
  private Double monthlyRent = 0.0;
  private Double monthlyIncome = 0.0;
  private Double totalMonthlyDebtPayment = 0.0;
  private Double basicDebts=0.0;
  private Double totalMonthlyExpense= 0.0;
  private final List<Debt> debts = new ArrayList<>();
  private final List<Expense> expenses = new ArrayList<>();

  /**
   * This constructor is responsible for instantiation.
   */
  public UserMonthlyExpenses() {
  }

  /**
   * A getter accessor method holding the user's name
   * @return a string representation of the user's name
   */
  public String getName() {
    return name;
  }

  /**
   * A setter accessor method that saves the user's name
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * A getter accessor method holding information regarding whether a user is a homeowner
   * @return a boolean representing whether the user is a homeowner or not
   */
  public boolean isHomeOwner() {
    return homeOwner;
  }

  /**
   * A setter accessor method that saves the user's status as a renter or homeowner
   */
  public void setHomeOwner(boolean homeOwner) {
    this.homeOwner = homeOwner;
  }

  /**
   * A getter accessor method holding the value of a user's average monthly mortgage payment
   * @return a double which represents the amount a user spends every month on mortgage
   */
  public Double getMonthlyMortgage() {
    return monthlyMortgage;
  }

  /**
   * A setter accessor method that saves the user's mortgage payment amount
   */
  public void setMonthlyMortgage(Double monthlyMortgage) {
    this.monthlyMortgage = monthlyMortgage;
  }

  /**
   * A getter accessor method holding the value of a user's average monthly rent payment
   * @return a double which represents the amount a user spends every month on rent
   */
  public Double getMonthlyRent() {
    return monthlyRent;
  }

  /**
   * A setter accessor method that saves the user's rental payment amount
   */
  public void setMonthlyRent(Double monthlyRent) {
    this.monthlyRent = monthlyRent;
  }

  /**
   * A getter accessor method holding the value of a user's average monthly salary
   * @return a double representing the amount a user makes every month
   */
  public Double getMonthlyIncome() {
    return monthlyIncome;
  }

  /**
   * A setter accessor method that saves the user's average monthly salary
   */
  public void setMonthlyIncome(Double monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  /**
   * A getter accessor method holding the value of a user's average, total monthly debt payments
   * @return a double representing the average, total amount a user spends on paying back debt
   */
  public Double getTotalMonthlyDebtPayment() {
    return totalMonthlyDebtPayment;
  }

  /**
   * A setter accessor method that saves the user's average monthly debt payments
   */
  public void setTotalMonthlyDebtPayment(Double totalMonthlyDebtPayment) {
    this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
  }

  /**
   * A getter accessor method holding the  user's monthly debt payments in a list
   * @return a list representing said debt
   */
  public List<Debt> getDebts() {
    return debts;
  }

  /**
   * A setter accessor method that saves the user's expenses in a list
   */
  public List<Expense> getExpenses() {
    return expenses;
  }

  /**
   * A getter accessor method holding the total value of a user's monthly debt payments
   * @return a double representing the total monthly debt payments a user is responsible for
   */
  public Double getBasicDebts() {
    return basicDebts;
  }

  /**
   * A setter accessor method that saves the user's debt payments
   */
  public void setBasicDebts(Double basicDebts) {
    this.basicDebts = basicDebts;
  }

  /**
   * A getter accessor method holding the total value of a user's monthly debt payments
   * @return a double representing the total monthly debt payments a user is responsible for
   */
  public Double getTotalMonthlyExpense() {
    return totalMonthlyExpense;
  }

  /**
   * A setter accessor method that saves the user's total monthly expenses
   */
  public void setTotalMonthlyExpense(Double totalMonthlyExpense) {
    this.totalMonthlyExpense = totalMonthlyExpense;
  }

}
