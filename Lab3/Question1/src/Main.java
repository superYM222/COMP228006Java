import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

         Insurance[] insurance = new Insurance[2];

         for(int i =0; i < insurance.length; i++){
             System.out.println("What type of insurance are u looking? ");
             String type = scanner.nextLine().trim().toLowerCase();
             System.out.println("Enter a monthly fee: ");
             double monthlyFee = scanner.nextDouble();
             scanner.nextLine();
             if(type.equals("health")) {

                 insurance[i] = new Health();
             }
             else if(type.equals("life")) {
                 insurance[i] = new Life();
             }
             insurance[i].setInsuranceCost(monthlyFee);


         }
           for(Insurance insurances : insurance){
             insurances.displayInfo();
               System.out.println();
           }
        scanner.close();

    }
}