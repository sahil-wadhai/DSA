//reference: https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/

import java.util.*;
class InversionCount
{
    /*
        Brute Force : <=(solved)
        - initialize count = 0;
        - Compare each ith element with every jth element , where i<j
        - If arr[i] < arr[j] increase count by 1 

        optimized : 
        - Apply merge sort on array
        - During merging process , count inversions when (arr[i]>arr[j])
        - See working of code using debugger to understand the algorithm.
    */
    
    private static long bruteForce(long [] arr)
    {
        int N = arr.length;
        long count = 0L;
        for(int i=0; i<N-1 ; i++)
        {
            for(int j = i+1 ; j<N ; j++)
            {
                if(arr[i]>arr[j])
                {
                    count++;   
                }
            }
        }
        return count;
  
    }

    static long countInversions(long arr[])
    {
        int n = arr.length;
        
        long[]count = new long[1];
        mergeSort(arr,0,n-1,count);

        return count[0];
    } 
    private static void mergeSort(long [] arr , int start , int end , long [] count)
    {
        if(start>=end)
        {
            return;
        }
        
        int mid = (start+end)/2;
        
        mergeSort(arr,start,mid,count);
        mergeSort(arr,mid+1,end,count);
        
        merge(arr,start,mid,end,count);
    }
    private static void merge(long [] arr , int start , int mid , int end ,long [] count)
    {
        long [] merged = new long[end-start+1];
        
        int i = start; //start of left sorted array
        int j = mid+1; //start of right sorted array array
        
        int k = 0;
        
        while(i<=mid && j<=end)
        {
            if(arr[i]<=arr[j])
            {
                merged[k] = arr[i];
                i++;
            }
            else
            {
                merged[k] = arr[j];
                j++;

                //Here , every element from i to mid is greater than j
                //so jth element form inversions with all elements from i to mid
                count[0]+= mid-i+1;
            }
            k++;
        }
        
        while(i<=mid)
        {
            merged[k] = arr[i];
            i++;
            k++;
        }
        while(j<=end)
        {
            merged[k] = arr[j];
            j++;
            k++;
        }
        
        for(int a=start,b=0; a<=end ; a++,b++)
        {
            arr[a] = merged[b];
        }
    }

    public static void main(String[] args) {

        long [] arr= {2,4,1,3,5};  

        
        System.out.println();

        System.out.println("Input: nums = "+ Arrays.toString(arr));  

        //long ans = bruteForce(arr);
        long ans = countInversions(arr); 

        System.out.println("Output: "+ ans);
        
    }
}