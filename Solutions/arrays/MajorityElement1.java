//reference: https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/

import java.util.*;
class MajorityElement1
{
    /*
        Brute Force : <=(solved)
        - using map

        optimized : <=(solved)
        - Moore voting algorithm , majority element should must exist , otherwise algo not works
    */
    
    private static int majorityElement(int[] nums) //moore algorithm
    {
        int n = nums.length;
        int ele = 0;
        int count = 0;

        for(int i=0 ; i<n ; i++)
        {
            if(count==0)
            {
                ele = nums[i];
                count=1;
            }
            else if(ele == nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return ele;
    }
    
    private static int bruteForce(int [] nums)
    {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<n ; i++)
        {
            if(map.containsKey(nums[i]))
            {
                int f = map.get(nums[i])+1;
                map.put(nums[i],f);
            }
            else
            {
                map.put(nums[i],1);
            }
        }

        for(int key : map.keySet())
        {
            if(map.get(key)>n/2)
            {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int [] arr= {2,2,1,1,1,2,2}; // Given: majority element should exist
        
        System.out.println();

        System.out.println("Input: nums = "+ Arrays.toString(arr));  

        int ans = majorityElement(arr); 

        System.out.println("Output: "+ ans);
        
    }
}