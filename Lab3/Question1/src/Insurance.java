public abstract class Insurance {
    String typeofInsurance;
    double monthlyCost;
    public Insurance(String typeofInsurance) {
        this.typeofInsurance = typeofInsurance;
    }
    public String getTypeofInsurance() {

        return typeofInsurance;
    }
    public double getMonthlyCost() {
        return monthlyCost;
    }
    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
    abstract void setInsuranceCost(double monthlyCost);
    abstract void displayInfo();
}
