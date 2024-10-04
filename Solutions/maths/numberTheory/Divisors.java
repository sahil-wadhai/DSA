import java.util.*;
public class Divisors {

  static ArrayList<Integer> getDivisors(int num)
  {
    ArrayList<Integer> divs = new ArrayList<>();
    /* divisors lies in range of 1 to n
    for(int i = 1 ; i<=num ; i++)
    {
      if(num%i==0)
      {
        divs.add(i);
      }
    }    
    */

    for(int i = 1 ; i*i<=num ; i++) // i <= sqtr(num)
    {
      if(num%i==0)
      {
        divs.add(i);
        if(num/i != i) //to avoid duplication
        {
          divs.add(num/i);
        }
      }
    } 
    return divs;
  }

  //Driver Code
  public static void main(String[] args) 
  {
    int num = 36;
    ArrayList<Integer> ans = getDivisors(num);
    System.out.println("\nInput : "+num);
    System.out.println("Divisors : "+ans);
  }
}
