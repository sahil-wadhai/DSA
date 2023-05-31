//reference: https://www.geeksforgeeks.org/next-permutation/

import java.util.*;
public class NextPermutation{
      /*
          Brute Force : 
          - Sort array
          - generate all possible permutation
          - return permutation just occuring after given.

          optimized : 
          - find pivot : first increasing pair from "right" , arr[i]<arr[i+1] ,here i is pivot
          - traverse from right find first index having num greater than arr[pivot]
          - swap values of pivot-index and just-greater index.
          - reverse array from pivot+1 upto last
      */
      static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1)
        {
            return;
        }

        int pivot = pivotIndex(nums); //step 1.

        if(pivot==-1)
        {
            reverse(nums,0,n-1);
            return;
        }

        int justGreater = greaterFromRight(nums,nums[pivot]); //step 2.
        
        swap(nums,pivot,justGreater); //step 3.
        reverse(nums, pivot+1, n-1); //step 4.
    }

    private static int pivotIndex(int [] nums)
    {
        int n = nums.length;
        for(int i=n-2 ; i>=0 ; i--)
        {
            if(nums[i]<nums[i+1])
            {
                return i;
            }
        }
        return -1;
    }
    private static int greaterFromRight(int [] nums,int p)
    {
        int n = nums.length;
        for(int i=n-1 ; i>=0 ; i--)
        {
            if(nums[i]>p)
            {
                return i;
            }
        }
        return -1;
    }
    private static void swap(int [] nums , int i1 , int i2)
    {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    private static void reverse(int[] nums , int start , int end) //start , end both inclusive
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
      int [] arr = {1, 2, 3};

      System.out.println("Input : " + Arrays.toString(arr));
      nextPermutation(arr);
      System.out.println("Output : " + Arrays.toString(arr)); 
  }
}
