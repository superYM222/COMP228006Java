package gametester;

import employeetype.FullTime;
import employeetype.PartTime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of sides: ");
        String name = scanner.nextLine();
        System.out.println("Enter your status:(part-time or full-time)");
        String status = scanner.nextLine();
        GameTester gameTester;
        if(status.equals("full-time")) {
            gameTester = new FullTime(name);
          System.out.println("Name: "+gameTester.getName());
          System.out.println("Type: "+gameTester.isFullTime());
          System.out.println("Salary: "+ gameTester.salary());
        }
        else if(status.equals("part-time")) {

            System.out.println("Enter your working hours");
            double workingHours = scanner.nextDouble();
            gameTester = new PartTime(name,workingHours);
            System.out.println("Name: "+gameTester.getName());
            System.out.println("Type: "+gameTester.isFullTime());
            System.out.println("Salary: $"+ gameTester.salary());

        }

    }
}