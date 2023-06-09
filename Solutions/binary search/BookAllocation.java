/*
Split Array Such that Maximum of Sum of Subarrays should be smallest return that sum..
note:
subarrays are continuous..
*/

import java.util.Arrays;
import java.lang.Math;

public class BookAllocation{

    static int findSplitArrayMinLargestSum(int [] arr , int M) //here, M is maximum splits allowed
    {
        //finding range in which ans lies
        int s=0; 
        int e=0;
        int n = arr.length; 

        for (int i = 0; i < n; i++) 
        {
            e = e+arr[i]; //e is sum of all elements in array ,here assuming M=1
            if(arr[i]>s)
            {
                s = arr[i]; //s is max element in array ,here assuming M=n;
            }
        }
        if(M == 1)
        {
            return e;
        }
        if(M == n)
        {
            return s;
        }

        int ans = e; //just assuming as ans is largest sum

        //Now Applying Binary Search in range [s,e]
        while(s<=e)
        {
            int mid = s + (e-s)/2; //possible ans
      
            if(isPossible(arr,M,mid)) //minimizing ans
            {
                ans = Math.min(ans,mid); //Minimum Largest sum
                e = mid-1;
            }
            else
            {
                //to decrease count
                //as number of 'splits Decreases' , value of 'ans Increases'
                s = mid+1; 
            }
        }
        return ans;
    }
    private static boolean isPossible(int [] arr , int M , int mid)
    {
        int count = 1; // number of subarrays
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) 
        {
            if(sum + arr[i] <= mid)
            {
                sum = sum + arr[i];
            }
            else
            {
                count++;
                sum = arr[i];
            }
        }
        if(count<=M) //here, count is splits made and M is maximum splits allowed
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Driver code
    public static void main(String[] args) 
    {
        int [] arr = {1,3,2,5,4};
        int M = 3; //M denotes number of sub arrays
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of Split arrays = " + M);
        int ans = findSplitArrayMinLargestSum(arr , M);
        System.out.println("Minimum Largest Sum of Split array = " + ans);
    }
}
