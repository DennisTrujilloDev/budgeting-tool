package com.dgn.budgeting;

import java.util.ResourceBundle;

public class Presentation {
  private final String beginningMsg;
  private final String welcomeMsg;
  private final String questions;
  private final String familySizeQuestion;
  private final String rentOrOwnQuestion;
  private final String haveDebtQuestion;
  private final String salaryQuestion;

  private final String miscBillsQuestion;
  private final String totalDebtQuestion;
  private final String haveDebtNumericValue;


  public Presentation(ResourceBundle bundle){
    beginningMsg = bundle.getString(Keys.FIRST_MSG_INPUT_NAME);
    welcomeMsg = bundle.getString(Keys.WELCOME_MSG_WITH_NAME);
    questions = bundle.getString(Keys.QUESTIONS_PROMPT);
    familySizeQuestion = bundle.getString(Keys.WHATS_YOUR_FAMILY_SIZE);
    rentOrOwnQuestion = bundle.getString(Keys.DO_YOU_RENT_OR_OWN);
    haveDebtQuestion = bundle.getString(Keys.DO_YOU_HAVE_DEBT);
    salaryQuestion = bundle.getString(Keys.WHATS_YOUR_SALARY);
    miscBillsQuestion = bundle.getString(Keys.WHATRE_YOUR_MISC_BILLS);
    totalDebtQuestion = bundle.getString(Keys.WHATS_YOUR_TOTAL_DEBT);
    haveDebtNumericValue = bundle.getString(Keys.WHATS_YOUR_TOTAL_DEBT);

  }
}


