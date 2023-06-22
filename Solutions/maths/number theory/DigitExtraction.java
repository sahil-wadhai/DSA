/**
  - Count Digits
  - Sum Of Digits in a 
  - Reverse of number
  - Armstrong number
*/
public class DigitExtraction{

  static int countDigits(int num)
  {
    int count = 0;
    while(num!=0)
    {
      count++;
      num = num/10;
    }
    return count;
  }

  static long sumOfDigits(int num)
  {
    long sum = 0;
    while(num!=0)
    {
      int digit = num % 10;
      sum += digit;
      num = num/10;
    }
    return sum;
  }
  static int reverse(int num)
  {
    int reverseNum = 0;
    while(num != 0)
    {
      int digit = num%10;
      reverseNum = (reverseNum*10)+digit;
      num = num/10;
    }
    return reverseNum;
  }
  static boolean isArmstrong(int num)
  {
    int count = countDigits(num);

    long sum = 0;
    int temp = num;
    while(temp!=0)
    {
      int digit = temp%10;
      sum += Math.pow(digit,count);
      temp = temp/10;
    }
    if(sum==num) return true;
    else return false;
  }

  
  //Driver Code
  public static void main(String[] args) {
    int num = 371;
    int count = countDigits(num);
    long sum = sumOfDigits(num);
    int reverseNum = reverse(num);
    boolean armstrong = isArmstrong(num);

    System.out.println("\nInput : "+num);
    System.out.println("Number of Digits : "+count);
    System.out.println("Sum of Digits : "+sum);
    System.out.println("Reverse : "+reverseNum);
    System.out.println("Is Armstrong? : "+armstrong);
  }
}