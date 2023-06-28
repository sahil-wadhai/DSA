import java.util.*;

//reference: https://takeuforward.org/data-structure/count-reverse-pairs/

public class ReversePairs 
{
    /*
        Brute Force : <=(solved)
        - initialize count = 0;
        - Compare each ith element with every jth element , where i<j
        - If arr[i] > 2*arr[j] increase count by 1 

        optimized : 
        - Apply merge sort on array
        - Before merging process , count reverse pairs . Then merge
        - See working of code using debugger to understand the algorithm.
    */

    static int reversePairs(int[] nums) 
    {
        int n = nums.length;
        int [] count = new int[1];
        count[0] = 0;

        mergeSort(nums,0,n-1,count);
        return count[0];
    }

    private static void mergeSort(int [] nums , int start , int end , int [] count)
    {
        if(start>=end)
        {
            return;
        }
        int mid = start + (end-start)/2;

        mergeSort(nums,start,mid,count);
        mergeSort(nums,mid+1,end,count);

        count(nums,start,mid,end,count);
        merge(nums,start,mid,end);
    }

    private static void count(int[]nums , int start , int mid , int end , int [] count)
    {
        int i = start;
        int j = mid+1;

        while(i<=mid && j<=end)
        {
            if((long)nums[i] > (long)2*nums[j]) // nums[i] > 2*nums[j]
            {   
                //if val at ith index is greater it means all values from i will be greater
                count[0] += mid-i+1;//all elements from i in the left array
                j++;
            }
            else
            {
                i++;
            }
        }
    } 
    private static void merge(int[]nums , int start , int mid , int end)
    {
        int left = start;
        int right = mid+1;
        int [] merged = new int[end-start+1];

        int k = 0;
        while(left<=mid && right<=end)
        {
            if( nums[left] <= nums[right] )
            {
                merged[k] = nums[left];
                left++;
            }
            else
            {
                merged[k] = nums[right];
                right++;
            }
            k++;
        }
        while(left<=mid)
        {
            merged[k]=nums[left];
            left++;
            k++;
        }
        while(right<=end)
        {
            merged[k]=nums[right];
            right++;
            k++;
        }

        k=0;
        for(int i = start ; i<=end ; i++)
        {
            nums[i] = merged[k];
            k++;
        }
    }

    public static void main(String[] args) 
    {
        int [] arr= {2,4,3,5,1}; // Given: majority element must exists
        
        System.out.println();

        System.out.println("Input: nums = "+ Arrays.toString(arr));  

        System.out.println("Output: "+ reversePairs(arr));
    }
}
