package torontobank.type;

import torontobank.mortgage.Mortgage;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String number, String name, double amount, double mortgageInterestRate,int term) {
        super(number, name, amount, mortgageInterestRate,term);
        this.term = term;
    }

    @Override
    public double getInterestRate(double interestRate){

        return interestRate/100+0.02;

    }
    @Override
    public double totalAmount(){

        double totalInterest = this.amount * getInterestRate(this.interestRate);
        return (this.amount + totalInterest)* this.term;


    }
}
