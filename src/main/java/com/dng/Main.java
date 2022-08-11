package com.dng;

import java.io.IOException;

/**
 * The Main class is the entry point of the application.
 */
public class Main {

  /**
   * This method creates a new instance of UserInput and invokes the  method that
   *calculates the total amount available for budgeting after all expenses have been paid.
   * @param args
   * @throws IOException
   */

  public static void main(String[] args) throws IOException {

    UserInput userInput = new UserInput();
    BudgetCandidates.adviseUser(userInput);
  }

}
