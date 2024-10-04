package JavaPractice.concepts;

import java.util.*;

/* 

# https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/

    Comparator:
    It is a Functional Interface.
    it contains method : int compare(T e1, Te2);
    It Compares two element. 
    if method compare returns 1 : swaps
    if method compare returns -1 : no swap

    Comparator c = new Comparator<Integer>{
        @Override
        public int compare(Integer e1, Integer e2){
            if( e1>e2 ) return 1;
            else return -1;
        }
    }

    Comparable:
    It is a Interface.
    it contains method : int compareTo(T o);
    It Compares itself and other. 
    if method compare returns 1 : swaps
    if method compare returns -1 : no swap

    class Employee implements Comparable<Employee>{
        int age;
        @Override
        public int compareTo(Employee other){
            if( this.age>other.age ){
                return 1; //swap
            }
            else return -1; //no swap
        }
    }
*/

class Employee implements Comparable<Employee>{
    int id;
    String name;
    int age;
    
    Employee(){}
    Employee(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee other){
        if( this.age>other.age ){
            return 1; //swap
        }
        else return -1; //no swap
    }
    
    @Override
    public String toString(){
        return "\n" + this.id +" "+ this.name + " " + this.age;
    }
}

class ComparatorComparableDemo{
    
    public static void main(String[] args) {
        
        //Creating a List of Employee
        List<Employee> emps = getEmployees(5);
        printEmployees(emps);
        
        System.out.println("\nAfter Sorting Using Comaparator");

        //sort according to age in increasing order
        Collections.sort(emps , new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2){
                if(e1.age>e2.age){
                    return 1; //swap
                }
                else{
                    return -1; //do not swap
                }
            }
        });
        
        //Comparator Using lambda Expression
        Collections.sort(emps, (Employee e1, Employee e2)->{
            if(e1.age>e2.age){
                return 1; //swap
            }
            else{
                return -1; //do not swap
            }
        });

        //Using Comparable , it will use compareTo method to compare and sort
        Collections.sort(emps);
        
        printEmployees(emps);
    }

    static List<Employee> getEmployees(int n){
        List<Employee> emps = new ArrayList<>();
        for(int i=0; i<n; i++){
            emps.add(new Employee(i,"Employee"+i, 
            20+(int)(Math.random()*31)));
        }
        return emps;
    }
    static void printEmployees(List<Employee> emps){
        for(Employee e:emps){
            System.out.println(e.toString());
        }
    }
}
