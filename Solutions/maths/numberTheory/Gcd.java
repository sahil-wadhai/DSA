public class Gcd 
{
  static int gcdBrute(int a , int b)
  {
    int hcf = 0;
    for (int i = 1; i <= Math.min(a,b); i++) 
    {
      if( (a%i)==0 && (b%i)==0)
      {
        hcf = i;
      }
    }
    return hcf;
  }
  static int gcdOptimized(int a , int b)
  {
    for (int i = Math.min(a,b); i >=1 ; i--) 
    {
      if( (a%i)==0 && (b%i)==0)
      {
        return i;
      }
    }
    return 1;
  }

  static int gcdEuclidean(int a , int b)
  {
    //Theorem : gcd(a,b) = gcd(a-b,b) , where a>b
    //Optimization of theorem : gcd(a,b) = gcd(a%b,b) , where a>b  
    // -> note : a%b is always smaller than b
    while(a>0 && b>0)
    {
      if(a>b) a = a%b;
      else b = b%a ;
    }
    if(a==0) return b;
    else return a;
  }
  static int gcd(int a , int b) //Euclidean recursive approach
  {
    if(a==0)
    {
      return b;
    }
    return gcd(b%a, a);
  }

  static int lcm(int a,int b) //lowest common multiple
  {
    //note: hcf(a,b)*lcm(a,b) = a*b
    int hcf = gcd(a,b);
    return (a*b)/hcf ;
  }
  public static void main(String[] args) {
    int a = 15;
    int b = 20;
    int hcf = gcdEuclidean(a,b);
    System.out.println("GCD : "+hcf);
  }
}
