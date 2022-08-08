import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Budgeting Counseling.");
    System.out.println("What's your name?");
    String name = sc.nextLine();

    System.out.println("Hello, " + name);

    System.out.println("Are you an individual or a family? Type I for Individual, F for Family.");
  }
}