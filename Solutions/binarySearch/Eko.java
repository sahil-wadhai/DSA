/*
Lumberjack Mirko needs to chop down M metres of wood. 
It is an easy job for him since he has a nifty new woodcutting machine 
can take down forests like wildfire. However, 
Mirko is only allowed to cut a single row of trees.

Mirko‟s machine works as follows: 
Mirko sets a height parameter H (in metres), 
and the machine raises a giant sawblade to that height and 
cuts off all tree parts higher than H 
(of course, trees not higher than H meters remain intact). 
Mirko then takes the parts that were cut off. 

For example, if the tree row contains trees with heights of 20, 15, 10, and 17 metres, 
and Mirko raises his sawblade to 15 metres, the remaining tree heights after 
cutting will be 15, 15, 10, and 15 metres, respectively, 
while Mirko will take 5 metres off the first tree and 2 metres off the fourth tree 
(7 metres of wood in total).

Mirko is ecologically minded, so he doesn‟t want to cut off more wood than necessary. 
That‟s why he wants to set his sawblade as high as possible. 
Help Mirko find the maximum integer height of the sawblade that 
still allows him to cut off at least M metres of wood.

Input
The first line of input contains two space-separated positive integers, 
N (the number of trees, 1 ≤ N ≤ 1 000 000) and 
M (Mirko‟s required wood amount, 1 ≤ M ≤ 2 000 000 000).

The second line of input contains N space-separated positive integers 
less than 1 000 000 000, the heights of each tree (in metres). 
The sum of all heights will exceed M, thus Mirko will always be able to obtain 
the required amount of wood.

Output
The first and only line of output must contain the required height setting.
*/

import java.util.*;
class Eko
{
    static long obtained(long[] arr,long h)
    {
        long amount =0;
        for(long t : arr)
        {
          if(t>h)
          {
            amount += t-h;
          }
        }
        return amount;
    }
    static long eko(long[]arr,long requiredWood)
    {
        int n = arr.length;
        long low = 0;
        long high = 0;
        long ans = 0;
        for(long t:arr)
        {
          if(t>high)
          {
            high = t;
          }
        }
        
        while(high >= low)
        {
          long mid = (low+high)>>1;
          long amount = obtained(arr,mid);
          
          if(amount>=requiredWood)
          {
            ans = mid;
            low = mid+1;
          }
          else
          {
            high = mid-1;
          }
        }
        
        return ans;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
      Scanner sc= new Scanner(System.in);
      int n = sc.nextInt();
      long requiredWood = sc.nextLong();
      long [] trees = new long[n];
      for(int i=0 ; i<n ; i++)
      {
        trees[i]=sc.nextLong();
      }
      long h = eko(trees,requiredWood);
      System.out.println(h);
      sc.close();
    }
}