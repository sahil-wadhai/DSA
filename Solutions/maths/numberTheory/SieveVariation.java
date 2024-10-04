import java.util.*;
public class SieveVariation 
{
  static int N = (int)(1e7);

  static boolean [] isPrime = new boolean[N+1];
  static int [] hp = new int[N+1]; //Storing highest prime of each index 
  static int [] lp = new int[N+1]; //Storing lowest prime of each index 

  static void markAllTrue(boolean[]arr)
  {
    for(int i = 0 ; i<=N ; i++)
    {
      arr[i]=true;
    }
  }
  static void sieveVariation() //Precomputing Highest prime and lowest prime 
  {
    markAllTrue(isPrime);

    // 0 and 1 is neither prime nor composite
    isPrime[0]=isPrime[1]=false; 

    //We know that 2 is the first prime number.
    for(int i = 2 ; i<=N ; i++) 
    {
      if(isPrime[i])
      {
        lp[i]=hp[i]=i;//lowest prime and highest prime of a prime number is itself 
        for(int j = i*2 ; j<=N ; j+=i)
        {
          //if i is prime , then all multiples of i is not prime
          isPrime[j] = false;

          hp[j]=i; // storing/updating highest prime of jth index
          if(lp[j]<=0)
          {
            lp[j] = i; // storing lowest prime of jth index
          }
        }
      }
    }
  }

  static ArrayList<Integer> primeFactorization(int num) //num<=N
  {
    //prime factorization : all prime factors of a number
    ArrayList<Integer> list = new ArrayList<>();
    while(num>1)
    {
      int factor = lp[num];
      while( num%factor == 0 )
      {
        list.add(factor);
        num = num/factor;
      }
    }
    return list;
  }
  public static void main(String[] args) 
  {
    sieveVariation(); //precomputing highest and lowest prime
    /* 
    for (int i = 0; i <= N; i++) 
    {
      System.out.println(i + " -> " + lp[i]+" "+hp[i]);
    }
    */
    System.out.println(primeFactorization(90));
  }
}
