import java.util.Scanner;

public class App {

    public static void main (String args[]){
        int option = 0;
        String name, scn;
        int age, dependents;
        double income, contribution; 
        
        System.out.println("Please enter 1 - for Standard Tax Deducition and 2 - for Itemized Tax Deduction: ");
        option = readInt();
        
        if (option==1){

            System.out.println("Please inform legal name: ");
            name  = readString();

            System.out.println("Please inform social security number:" );
            scn = readString();

            System.out.println("Please inform total income: ");
            income = readDouble();

            System.out.println("Please inform total contibution: ");
            contribution = readDouble();

            Taxpayer t = new Taxpayer (name, scn, income, contribution); 

            System.out.println("====== Standard Tax Deduction ======");
            System.out.println(t.toString());
            System.out.println("Tax due is: R$ "+Taxpayer.standardTaxDeduction(t.getIncome(),t.getContribution()));
        }

        else if (option==2){

            System.out.println("Please inform legal name: ");
            name  = readString();

            System.out.println("Please inform social security number:" );
            scn = readString();

            System.out.println("Please inform age: ");
            age = readInt();

            System.out.println("Please inform number of dependents: ");
            dependents = readInt();

            System.out.println("Please inform total income: ");
            income = readDouble();

            System.out.println("Please inform total contibution: ");
            contribution = readDouble();

            Taxpayer t = new Taxpayer (name, scn, age, dependents, income, contribution); 
            System.out.println("====== Itemized Tax Deduction ======");
            System.out.println(t.toString());
            System.out.println("Tax due is: R$ "+Taxpayer.itemizedTaxDeduction(t.getIncome(),t.getContribution(),t.getAge(), t.getDependents()));
        }
        else {
            System.out.println("You didn't enter a valid option.");
        }


    }

    //This is a method for reading integer values 
    public static int readInt (){
    Scanner in = new Scanner(System.in);
   
    System.out.println("\n>>> Enter input: ");
    //Creates a loop while user tries to input values different than integers 
    while(!in.hasNextInt()){
        in.next();
        System.out.println("Invalid entry! Only integers allowed. Please try again: ");  
    }
    //Once the value meets the criteria, it is attributed to the variable input 
    int input = in.nextInt();
    in.nextLine();
    return input;
    }

    //This is a method for reading integer values 
    public static double readDouble (){
    Scanner in = new Scanner(System.in);
   
    System.out.println("\n>>> Enter input: ");
    //Creates a loop while user tries to input values different than integers 
    while(!in.hasNextDouble()){
        in.next();
        System.out.println("Invalid entry! Only doubles allowed. Please try again: ");  
    }
    //Once the value meets the criteria, it is attributed to the variable input 
    double input = in.nextDouble();
    in.nextLine();
    return input;
    }
    
    //This is a method for reading String values 
    public static String readString (){
        Scanner in = new Scanner(System.in);
        System.out.println("\n>>> Enter input: ");
        String s = in.nextLine(); 
        return s;
    }
    
}
