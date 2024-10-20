
package torontobank.mortgage;

import torontobank.mortgageconstants.MortgageConstants;

public abstract class Mortgage implements MortgageConstants {

    String number;
    String name;
    public double amount;
    public double interestRate;
    public int term;

    public Mortgage(String number, String name, double amount, double interestRate, int term) {
        this.number = number;
        this.name = name;
        this.amount = amount;
        this.interestRate = interestRate;
        if (term != shortTerm && term != mediumTerm && term != longTerm) {
            this.term = shortTerm;
        } else {
            this.term = term;
        }
    }

    public double amount() {
        return amount;
    }

    public int term() {
        return term;
    }

    public double interestRate() {
        return interestRate;
    }

    public abstract double totalAmount();

    public abstract double getInterestRate(double interestRate);

    public double setAmount(double inputAmount) {
        if (limitAmount < inputAmount) {
            throw new IllegalArgumentException("The amount is exceed than the limit amount");
        } else {
            return inputAmount;
        }

    }



    public int setTerm(int inputTerm) {
        switch (inputTerm) {
            case 1:
                return shortTerm;
            case 2:
                return mediumTerm;
            case 3:
                return longTerm;
            default:
                System.out.println("Invalid term input. Defaulting to short term.");
                return shortTerm;
        }
    }

    public String getMortgageInfo() {
        return "Bank Name: " + bankName + '\n' + "Customer Name: " + name + '\n' + "amount: " + this.amount + '\n' + "InterestRate: %" + this.interestRate + '\n' + "Term: " +this.term +" years" + '\n';
    }

}
