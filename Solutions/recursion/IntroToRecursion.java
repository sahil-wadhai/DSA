/*
  Why use Recursion :
  -> To solve bigger Complex Problem easy way
  -> note: you can convert every recursion solution into iteration solution for better optimization,
     as recursion takes extra space for calling function 
     but solving complex problems using iterations is hard so try to use recursion first then optimize it..
  
  Approach to Solve Recursion Problem :
  1) Identify if you can break down problem with smaller problems
  2) Write the Recurrence relation if needed
  3) Draw the recursive tree
  4) Figure out About the tree:
  -> See the flow of functions how they are getting in stack
  -> observe flow of left tree calls and right tree calls
     (note : left tree call executes first then right tree calls are executed)
  5) See how and what type of value are returned in each level of tree, figure out at which point(base condition) 
     call stack should start getting empty
  6) Tip : 
     Figure out which variable should be placed where   
     Variables Involved in Recursion:
         1) Variables in Argument
         2) Variables in Return Type
         3) Variables in body of the function
*/
public class IntroToRecursion {

    static void printBackward(int n)
    {
        if(n < 0)
        {
            return;
        }

        System.out.println(n);
        printBackward(n-1);   
    }

    static void printForward(int n)
    {
        if(n < 0) //base condition, a condition when hit 'call stack starts getting empty'
        {
            return;
        }

        printForward(n-1); // Recursion : function calling itself while altering the argument
        System.out.println(n);
    }
    
    static int fibo(int n)
    {
        // fibonacci series :  0 1 1 2 3 5 8 13 21 . . . . .
        if(n<2)
        {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    static int sumOfDigits(int n)
    {
        if(n==0)
        {
            return 0;
        }
        return (n%10) + sumOfDigits(n/10); 
        //similarly, we can find product of digits
    }

    //When additional Variable is Requirred in the Argument then use another function
    static int reverseNumber(int n)
    {
        return reverseFunc(n,0);
    }
    static int reverseFunc(int n , int reverseNum)
    {
        if(n==0)
        {
            return reverseNum;
        }
        reverseNum = (reverseNum*10) + (n%10);
        return reverseFunc(n/10,reverseNum);  
    }

    static boolean isPalindrome(int n)
    {
        if(n == reverseNumber(n))
        {
            return true;
        }
        else{
            return false;
        }
    }

    static int numberOfZeros(int n)
    {
        return countZeros(n,0);
    }
    static int countZeros(int n , int count)
    {
        if(n==0)
        {
            return count;
        }
        if(n%10 == 0)
        {
            count++;
        }
        return countZeros(n/10, count);
    }
    public static void main(String[] args) 
    {   
        printForward(5); //print upto n in forward manner
        System.out.println();
        printBackward(5); //print from n in backward manner

        int fiboNum = fibo(5); //find nth fibonacci number
        System.out.println("Requirred Fibonacci number : " + fiboNum);

        int num = 1234;
        System.out.println("Number : "+num+"\tReverse : "+reverseNumber(num)); 
    } 
}