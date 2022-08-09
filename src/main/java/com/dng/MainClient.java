package com.dng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainClient {

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //Creates new instance of Debts class.
    Debts debtCategory = new Debts();

    //User prompts that help accept input related to debt; from user
    System.out.println("{{DEBTS}}\nEnter '0' if debt category does not apply ");
    System.out.println("Enter monthly car payemnt: ");
    int carPay = Integer.parseInt(reader.readLine());
    System.out.println("Enter monthly credit card payment: ");
    int creditCardPay = Integer.parseInt(reader.readLine());
    System.out.println("Enter Student loan monthly payment: ");
    int studentLoanPay = Integer.parseInt(reader.readLine());
    System.out.println("Enter monthly car payemnt: ");
    int medBillsPay = Integer.parseInt(reader.readLine());

    //Uses inputs from users to set all debtCategories.
    debtCategory.setCarPayment(carPay);
    debtCategory.setCreditCardPayment(creditCardPay);
    debtCategory.setStudentLoan(studentLoanPay);
    debtCategory.setMedicalBill(medBillsPay);

    // local varibales
    double A = debtCategory.getCarPayment();
    double B = debtCategory.getMedicalBill();
    double C = debtCategory.getCreditCardPayment();
    double D = debtCategory.getStudentLoan();

    //Gets the user input from the setters
    System.out.println(A);
    System.out.println(B);
    System.out.println(C);
    System.out.println(D);

    double debtTotal;
    debtTotal = (A + B + C + D);

    debtCategory.setTotalDebts(debtTotal);
    System.out.println(debtCategory.getTotalDebts());

    System.out.println("Enter your income: ");
    int income = Integer.parseInt(reader.readLine());
    System.out.println("Enter your debt: ");
    int debt = Integer.parseInt(reader.readLine());
    BudgetCandidates ab = new BudgetCandidates(income, debt);

    System.out.println("Recommended Savings : " + ab.calculateSavings());
    System.out.println("Recommended EmergencyFund: " + ab.calculateEmergencyFund());
    System.out.println("Recommended budget for Food : " + ab.calculateFoodBudget());
    System.out.println("Recommended Miscellaneous: " + ab.calculateMiscellanous());

  }


}
