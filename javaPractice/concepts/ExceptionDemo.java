public class ExceptionDemo {
    public static void main(String[] args) {
        int a = 9;
        int b = 0;
        int res;

        //try,catch,finally Demo
        try{
            //critical code
            res = a/b; 
        }catch(ArithmeticException e){
            System.out.println("Exception occured but handled succesfully");
            res = a/1;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("finally block will execute in every condition");
        }

        //throw deom
        a = 0;
        b = 9;
        res = 0;
        try{
            //critical code
            res = a/b;
            if(res==0) throw new Exception(); //throwing exception explicitly
        }catch(Exception e){
            System.out.println("Exception occured but handled succesfully");
            res = a/1;
        }

        //custom exception demo
        try{
            throw new NavinException("custom exception message");
        }catch(NavinException e){
            System.out.println(e);
        }

        //throws demo
        //Ducking of exception, means caller will handle the exception
        try{
            func1();//throws exception
            func2(); //throws exception
        }catch(ArithmeticException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    //throws specify that these function might throw a exception
    //so the caller will have to handle it
    static int func1() throws ArithmeticException{
        return 123/0;
    }

    static void func2() throws Exception{
        throw new Exception();
    }
}

//Custom exception
class NavinException extends Exception{
    public NavinException(String msg){
        super(msg);
    }
}


/* 

 - With the help of exception handling we can detect and handle the exceptions gracefully 
 so that the normal flow of the program can be maintained.

- Major Reasons Why an Exception Occurs
Exceptions can occur due to several reasons, such as:
Invalid user input
Device failure
Loss of network connection
Physical limitations (out-of-disk memory)
Code errors
Out of bound
Null reference
Type mismatch
Opening an unavailable file
Database errors
Arithmetic errors

- Exceptions vs Errors
Errors represent irrecoverable conditions 
such as Java virtual machine (JVM) running out of memory, memory leaks, stack overflow errors, 
library incompatibility, infinite recursion, etc.
Errors are usually beyond the control of the programmer, and we should not try to handle errors.

- Types of Exception
1) Checked Exception : A checked exception is a type of exception in Java that is checked at compile-time
IOException
SQLException
FileNotFoundException
ParseException
ClassNotFoundException
InterruptedException

2) Unchecked Exception : 
An unchecked exception is a type of exception in Java that occurs at runtime and is not checked at compile-time, 
usually resulting from programming errors.

NullPointerException
ArrayIndexOutOfBoundsException
ArithmeticException
IllegalArgumentException
NumberFormatException

- Usage tips:
Unchecked exceptions can be avoided at the time of development by writing robust and error-free code. 
These exceptions usually result from programming mistakes, such as:
NullPointerException → Avoid by checking for null before accessing objects.
ArrayIndexOutOfBoundsException → Avoid by ensuring index values are within array bounds.
ArithmeticException → Avoid by checking for division by zero.
NumberFormatException → Avoid by validating input before parsing.
IllegalArgumentException → Avoid by validating method arguments before processing.

On the other hand, checked exceptions often depend on external factors 
(e.g., file not found, database connection issues) and must be handled properly using try-catch or throws.


- hierarchy of exception

java.lang.Throwable  
│  
├── java.lang.Exception  (Checked Exceptions)  
│   ├── IOException  
│   │   ├── FileNotFoundException  
│   │   ├── EOFException  
│   │   ├── InterruptedIOException  
│   │  
│   ├── SQLException  
│   │  
│   ├── ClassNotFoundException  
│   │  
│   ├── InterruptedException  
│   │  
│   ├── ReflectiveOperationException  
│   │   ├── InstantiationException  
│   │   ├── IllegalAccessException  
│   │   ├── NoSuchMethodException  
│   │   ├── InvocationTargetException  
│   │  
│   ├── ParseException  
│   │  
│   ├── CloneNotSupportedException  
│   │  
│   ├── MalformedURLException  
│   │  
│   ├── UnsupportedEncodingException  
│   │  
│   └── DataFormatException  
│  
└── java.lang.RuntimeException  (Unchecked Exceptions)  
    ├── NullPointerException  
    │  
    ├── ArithmeticException  
    │  
    ├── IndexOutOfBoundsException  
    │   ├── ArrayIndexOutOfBoundsException  
    │   ├── StringIndexOutOfBoundsException  
    │  
    ├── IllegalArgumentException  
    │   ├── NumberFormatException  
    │  
    ├── IllegalStateException  
    │  
    ├── ClassCastException  
    │  
    ├── UnsupportedOperationException  
    │  
    └── SecurityException  

- with multiple catch block, use subclasses first and top most class at last to handle exception precisely.

*/