/*
maximize the minimum distance among cows...
*/

import java.util.Arrays;
import java.lang.Math;

public class AggressiveCows{

    static int maximumDistance(int [] arr , int M) //here, M is maximum splits allowed
    {
        Arrays.sort(arr);
        int n = arr.length;

        if(M>n)
        {
            return -1;
        }

        int minAns = 1;
        int maxAns = arr[n-1]-arr[0];
        int ans = 1;

        int start = minAns;
        int end = maxAns;

        //Now Applying Binary Search in range [start,end]
        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(isPossible(arr,M,mid)) //maximizing ans
            {
                ans = Math.max(ans,mid);
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr , int M , int mid)//M represent cows need to be placed
    {
        int n = arr.length;
        int previous = arr[0]; //previous cow location
        int count = 1;
        for(int i=1; i<n ; i++)
        {
            if(arr[i]-previous >= mid)
            {
                count++;
                previous=arr[i];
            }
        }
        if(count>=M)
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
        //arr represent x co-ordinates of stalls
        int [] arr = {1,2,4,9,8};

        int M = 3; //M denotes number of cows needs to be placed

        System.out.println(Arrays.toString(arr));
        System.out.println("Number of cows = " + M);
        int ans = maximumDistance(arr , M);
        System.out.println("Output = " + ans);
    }
}
