//reference: https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/

import java.util.*;
public class BuySellStock{
    /*
        Brute Force :  Run two loops <=(solved)
        optimized : slidding window technique. <=(solved)
    */

    private static int bruteForce(int[] prices) 
    {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;

        for(int i=0 ; i<n-1 ; i++)
        {
            for(int j=i+1 ; j<n ; j++)
            {
                int profit = prices[j] - prices[i];
                if(profit > maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }
        if(maxProfit<0)
        {
            return 0;
        }
        else
        {
            return maxProfit;
        }
    }

    private static int maxProfit(int[] prices)
    {
        int n = prices.length;

        int buyDay = 0;
        int sellDay = 1;
        int maxProfit = 0;

        while(sellDay < n)
        {
            
            if(prices[buyDay] > prices[sellDay])
            {
                buyDay = sellDay;
            }
            else
            {
                int profit = prices[sellDay] - prices[buyDay];
                maxProfit = Math.max(profit,maxProfit);
            }
            sellDay++;
        }

        return maxProfit;
    }  
    
    public static void main(String[] args) {
      int [] stockPrices = {7,1,5,3,6,4};

      System.out.println("Input : " + Arrays.toString(stockPrices));
      int ans = maxProfit(stockPrices);
      System.out.println("Output : " + ans); 
  }
}
