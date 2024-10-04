package q2;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class Solution{

    static class Employee{
        private int employeeId;
        private String employeeName;
        private int age ;
        private char gender;
        private double salary;
        
        Employee(){}
        
        Employee(int id,String name,int age,char gender, double salary){
            this.employeeId = id;
            this.employeeName = name;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
        }
        void setEmloyeeId(int employeeId){
            this.employeeId = employeeId;
        }
        void setEmployeeName(String employeeName){
            this.employeeName = employeeName;
        }
        void setAge(int age){
            this.age = age;
        }
        void setGender(char gender){
            this.gender=gender;
        }
        void setSalary(double salary){
            this.salary = salary;
        }
        
        int getEmployeeId(){
            return this.employeeId;
        }
        String getEmployeeName(){
            return this.employeeName;
        }
        int getAge(){
            return this.age;
        }
        char getGender(){
            return this.gender;
        }
        double getSalary(){
            return this.salary;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee [] empArr = new Employee[n];
        for(int i = 0 ; i<n ; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            char d = sc.next().charAt(0);sc.nextLine();
            double e = sc.nextDouble();sc.nextLine();
            empArr[i] = new Employee(a,b,c,d,e);
        }
        int age = sc.nextInt();
        Employee ans1 = getEmployeeWithSecondLowestSalary(empArr);
        int ans2 = countEmployeesBasedOnAge(empArr, age);
        if(ans1==null){
            System.out.println("Null");
        }
        else{
            System.out.println(ans1.getEmployeeId()+"#"+ans1.getEmployeeName());
        }
        if(ans2==0){
            System.out.println("No employee found for the given age");
        }
        else{
            System.out.println(ans2);
        }
        sc.close();
    }
    public static Employee getEmployeeWithSecondLowestSalary(Employee [] empArr){
        
        if(empArr.length==0) return null;
        
        double low = Double.MAX_VALUE;
        double second = Double.MAX_VALUE;
        Employee l =empArr[0];
        Employee s = empArr[0];
        for(Employee emp : empArr){
            if(emp.getSalary()<low){
                s = l;
                second = low;
                low = emp.getSalary();
                l = emp;
            }
            else if(emp.getSalary()<second && emp.getSalary()!=low){
                second = emp.getSalary();
                s = emp;
            }
        }
        if(second==0) return null;
        return s;
    }
    public static int countEmployeesBasedOnAge(Employee[] empArr, int age){
        int count = 0;
        for(Employee emp:empArr){
            if(emp.getAge()==age){
                count++;
            }
        }
        return count;
    }
}
