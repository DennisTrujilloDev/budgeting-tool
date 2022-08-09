package com.dgn.budgeting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ResourceBundle;

public class Main {
  private static final String BUNDLE_NAME = "messages";
//add todos
  public static void main(String[] args) throws IOException {
    ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    try (
        Reader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input)
    ) {
      String nameInput = BUNDLE.getString(Keys.FIRST_MSG_INPUT_NAME);
      System.out.printf("%s", nameInput);

      String welcomeWithName = BUNDLE.getString(Keys.WELCOME_MSG_WITH_NAME);
      System.out.printf("%s", welcomeWithName);


    } catch (IOException ignore){
      System.out.println("error here");
    }
    BudgetTool tool = new BudgetTool();
//    (args.length>0) ? args[0] : "unknown user")
    new BudgetTool("dennis", 3, "r", "n", 5000, 1000, 3000, 500);

  }

}
