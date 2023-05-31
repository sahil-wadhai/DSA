//reference: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

import java.util.*;
class Missing_Repeating
{
    /*
        Brute Force : apply merge sort and run a for loop to check
        optimized : use count array or map <=
        best : bit operation using xor
    */
    static int[] missing_repating(int[] nums) 
    {
        int N = nums.length;

        //for storring nums[i] with times it occured
        HashMap<Integer,Integer> map = new HashMap<>();

        int [] ans = new int[2];// missing and repeating

        //as we know nums[i] ranges from 1 to N
        for(int i=1; i<=N ;i++)
        {
            map.put(i,0);
        }

        for(int i=0; i<N ; i++) //
        {
            int num = nums[i];
            
            int f = map.get(num);
            map.put(num,f+1);
            
        }

        for(int key:map.keySet())
        {
            int f = map.get(key);
            if(f==0) //means key has no occurences , num is missing
            {
                ans[0]=key;
            }
            else if(f>1) //means key has multiple occurences , num is repeated
            {
                ans[1]=key;
            }
        }
        return ans;
    }
    

    public static void main(String[] args) {

        int [] arr= { 1, 3, 4, 5, 1, 6, 2 };

        int [] ans = missing_repating(arr);

        System.out.println();
        System.out.println("Input: nums = "+ Arrays.toString(arr));
        System.out.println("Output: "+ Arrays.toString(ans));
        
    }
}