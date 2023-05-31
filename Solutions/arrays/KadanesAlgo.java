//reference: https://www.javatpoint.com/largest-sum-contiguous-subarray

import java.util.*;
class KadanesAlgo
{
    /*
        Brute Force : find all subarrays[3 loops] (count sum of all and then print max among them.)
        optimized : Run two for loops (traverse all subarrays and update max if sum > max ) <=(solved)
        best : Kadane's algorithm <=(solved)
    */
    private static int twoLoops(int [] nums)
    {
        int N = nums.length;
        int max = nums[0];

        for(int i = 0; i<N ; i++)
        {
            int sum = 0;
            for(int j = i ; j<N ; j++) //traversing all subarrays and updating max if sum > max
            {
                sum += nums[j];
                if(sum>max)
                {
                    max = sum;
                }
            }
        }
        return max;
    }

    static int kadanesAlgo(int[] nums) 
    {
        int N = nums.length;

        int sum = 0;
        int max = nums[0];

        for(int i=0 ; i<N ; i++)
        {
            sum += nums[i]; // add num to running sum

            if(sum>max) // update max if sum > max
            {
                max = sum;
            } 

            if(sum<0) //ignore subarray if it gives negative sum (reset sum)
            {
                sum = 0; 
            }
        }
        return max;
    }
    

    public static void main(String[] args) {

        int [] arr= {-2, -3, 4, -1, -2, 1, 5, -3};  

        //int ans = twoLoops(arr);
        int ans = kadanesAlgo(arr);

        System.out.println();
        System.out.println("Input: nums = "+ Arrays.toString(arr));
        System.out.println("Output: "+ ans);
        
    }
}