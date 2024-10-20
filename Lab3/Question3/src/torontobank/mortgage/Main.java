package torontobank.mortgage;

import torontobank.type.BusinessMortgage;
import torontobank.type.PersonalMortgage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mortgage[] mortgage = new Mortgage[2];

        System.out.println("Enter a account number: ");
        String accountNumber = sc.nextLine();
        System.out.println("Enter account name: ");
        String accountName = sc.nextLine();
        System.out.println("Enter amount to mortgage: ");
        double amount = sc.nextDouble();
        System.out.println("Enter mortgage interest rate: ");
        double mortgageInterestRate = sc.nextDouble();
        System.out.println("Enter term (1 for short term, 2 for medium term, 3 for long term): ");
        int term = sc.nextInt();
        sc.nextLine();  // 남은 개행 문자 처리
        System.out.println("Enter type (business/personal): ");
        String type = sc.nextLine();


    for(int i = 0; i < mortgage.length; i++) {

        switch (type)
        {
            case "business":
                mortgage[0] = new BusinessMortgage(accountNumber, accountName, amount,mortgageInterestRate,term);
                mortgage[0].setAmount(amount);
                mortgage[0].setTerm(term);
                mortgage[0].getInterestRate(mortgageInterestRate);
                mortgage[0].totalAmount();
                break;


            case "personal":
                mortgage[1] = new PersonalMortgage(accountNumber, accountName, amount,mortgageInterestRate,term);
                mortgage[1].setAmount(amount);
                mortgage[1].getInterestRate(mortgageInterestRate);
                 break;
            default:
                System.out.println("Invalid type entered.");
                return;

        }
    }

    for(Mortgage mortgage1 : mortgage){
        System.out.println(mortgage1.getMortgageInfo());
        System.out.println("Total amount of mortgage: $"+mortgage1.totalAmount());
    }

    }
}