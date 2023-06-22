public class PrimeNumbers {
  static boolean checkPrime(int num)
  {
    /* 
    for(int i = 2; i<num ; i++)
    {
      if(num%i==0)
      {
        return false;
      }
    }
    */
    for(int i = 2; i*i<=num ; i++)
    {
      if(num%i==0)
      {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) 
  {
    int num = 61;
    boolean isPrime = checkPrime(num);
    System.out.println("Input : "+num);
    System.out.println("Is prime? : "+isPrime);
  }
}
