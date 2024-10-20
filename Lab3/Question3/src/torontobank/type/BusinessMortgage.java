package torontobank.type;

import torontobank.mortgage.Mortgage;


public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(String number, String name, double amount,double mortgageInterestRate, int term) {
        super(number, name, amount,mortgageInterestRate,term);
        this.term = setTerm(term);
    }
@Override
    public double getInterestRate(double interestRate){

       return interestRate/100+0.01;

    }
    @Override
    public double totalAmount(){

        double totalInterest = this.amount * getInterestRate(this.interestRate);
        return (this.amount + totalInterest)* this.term;


    }


}


