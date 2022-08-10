package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteraction {

  private void welcomeMessage() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What is your name?");
    String name = reader.readLine();
    System.out.println("Hello, " + name);
    System.out.println("Are you an individual or a family? Type I for Individual, F for Family and press Enter.");
  }


}
