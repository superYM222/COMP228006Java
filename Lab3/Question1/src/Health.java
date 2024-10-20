public class Health extends Insurance{

   public Health(){
       super("health");
   }
   @Override
    public void setInsuranceCost(double cost){
       setMonthlyCost(cost);
    }


    public void displayInfo(){
        System.out.println( getTypeofInsurance()+ "Insurance Cost: " +getMonthlyCost());

    }
}
