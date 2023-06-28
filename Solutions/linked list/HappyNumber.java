/*
  A number is called happy if it leads to 1 after a sequence of steps 
  wherein each step number is replaced by the sum of squares of its digit that is 
  if we start with Happy Number 
  and keep replacing it with digits square sum, we reach 1. 

  Examples : 

  Input: n = 19
  Output: True
  19 is Happy Number,
  1^2 + 9^2 = 82
  8^2 + 2^2 = 68
  6^2 + 8^2 = 100
  1^2 + 0^2 + 0^2 = 1
  As we reached to 1, 19 is a Happy Number.
*/
public class HappyNumber 
{
  static boolean isHappy(int num)
  {
    //using slow pointer and fast pointer concept
    //intuition: cycle detection problem
    int slow = num;
    int fast = num;
    do
    {
      if(slow==1 || fast==1)
      {
        return true;
      }
      slow = digitSquareSum(slow);
      fast = digitSquareSum(digitSquareSum(fast));
    }while(slow != fast);
    return false;
  }

  static private int digitSquareSum(int n)
  {
    int sum = 0;
    while(n != 0)
    {
      int digit = n%10;
      sum += digit*digit;
      n = n/10;
    }
    return sum;
  }
  //driver code
  public static void main(String[] args) 
  {
    int num = 23;
    boolean ans = isHappy(num);
    System.out.println("\nnum : "+num);
    System.out.println("is happy? : "+ans);
  }
}
