import java.util.*;
public class Solution {

    static class AutonomousCar{
        private int id;
        private String brand;
        private int noOfTestConducted;
        private int noOfTestPasssed;
        private String environment;
        private String grade;

        AutonomousCar(){
            this.grade = "";
        }
        AutonomousCar(int id , String brand, int noOfTestConducted, int noOfTestPasssed, String environment){
            this.id = id;
            this.brand = brand;
            this.noOfTestConducted = noOfTestConducted;
            this.noOfTestPasssed = noOfTestPasssed;
            this.environment = environment;

            int rating = (noOfTestPasssed*100)/noOfTestConducted;
            this.grade = rating>=80 ? "A1" : "B2";
        }

        void setId(int id){
            this.id = id;
        }
        void setBrand(String brand){
            this.brand = brand;
        }
        void setNoOfTestConducted(int noOfTestConducted){
            this.noOfTestConducted = noOfTestConducted;
        }
        void setNoOfTestPassed(int noOfTestPasssed){
            this.noOfTestPasssed = noOfTestPasssed;
        }
        void setEnvironment(String environment){
            this.environment = environment;
        }

        int getId(){
            return this.id;
        }
        String getBrand(){
            return this.brand;
        }
        int getNoOfTestConducted(){
            return this.noOfTestConducted;
        }
        int getNoOfTestPassed(){
            return this.noOfTestPasssed;
        }
        String getEnvironment(){
            return this.environment;
        }
        String getGrade(){
            return this.grade;
        }
    }

    static int findTestPassedByEnv( AutonomousCar [] cars, String env){
        int sum = 0;
        for(AutonomousCar car: cars){
            if(car.getEnvironment().equalsIgnoreCase(env)){
                sum += car.getNoOfTestPassed();
            }
        }
        return sum;
    }

    static AutonomousCar updateCarGrade(String brand, AutonomousCar [] cars){
       
        for(AutonomousCar car: cars){
            if(car.getBrand().equalsIgnoreCase(brand)){
                return car;
            }
        }
        return null;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        AutonomousCar [] cars = new AutonomousCar[n];
        for(int i=0; i<4 ; i++){
            int a =sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            cars[i] = new AutonomousCar(a,b,c,d,e);
        }

        String env = sc.nextLine();
        int res1 = findTestPassedByEnv(cars, env);
        String brand = sc.nextLine();
        AutonomousCar res2 = updateCarGrade(brand, cars);

        if(res1==0) System.out.println("There are no tests passed for particular environment");
        else System.out.println(res1);

        if(res2==null) System.out.println("No Car is available with the specified brand");
        else System.out.println(res2.getBrand()+"::"+res2.getGrade());

        sc.close();
    }
}
