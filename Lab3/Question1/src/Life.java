public class Life extends Insurance{
    public Life(){
        super("life");
    }
    @Override
    public void setInsuranceCost(double monthlyCost){
        setMonthlyCost(monthlyCost);
    }


    public void displayInfo(){
        System.out.println( getTypeofInsurance()+ "Insurance Cost: " +getMonthlyCost());

    }

}
