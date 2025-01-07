// Different Ways of Method Overloading in Java
//  - Changing the Number of Parameters.
//  - Changing Data Types of the Arguments.
//  - Changing the Order of the Parameters of Methods

/* Method overloading in Java is also known as Compile-time 
Polymorphism, Static Polymorphism, or Early binding. In Method 
overloading compared to the parent argument, the child argument 
will get the highest priority. */

class MethodOverloadingDemo{
    static class Calculator{
        public int add(int n1,int n2, int n3){
            return n1+n2+n3;
        }
        public int add(int n1,int n2){
            return n1+n2;
        }
        public double add(double n1 , double n2){
            return n1+n2;
        }
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println( calc.add(10,22,30) );
        System.out.println( calc.add(10,22) );
        System.out.println( calc.add(10.0,20.0) );
        
    }
}
