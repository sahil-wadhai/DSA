//reference: https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

import java.util.*;
class SortColors
{
    /*
        Brute Force : Apply Merge Sort
        optimized : Apply Count sort
        best : use pointers <=
    */
    static void sort012(int[] nums) 
    {
        int n = nums.length;

        int s=0,m=0,e=n-1;
        /*
            here we are making pointers to point the colors
            s => 0
            m => 1
            e => 2

            if any pointer mismatches we swap color with the appropriate one
            note :
            s points the end of 0's
            m points the end of 1's
            e points the end of 2's
        */
        while(m<=e)
        {
            switch(nums[m])
            {
                case 0:
                    if(m==s)
                    {
                        s++;
                        m++;
                    }
                    else
                    {
                        swap(nums,s,m);
                        s++;
                    }
                    break;
                
                case 1:
                    m++;
                    break;
                
                case 2:
                    swap(nums,e,m);
                    e--;
                    break;

                default:
                    return;
            }
        }    
        /*
            After loop ends
            number from 0 to s-1 are 0's
            number from s to m-1 are 1's
            number from e+1 to n-1 are 2's
        */
    }
    static void swap(int [] nums , int i1 , int i2) //function to swap values of indices i1,i2
    {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size : ");
        int size = sc.nextInt();

        int [] arr = new int[size];
        System.out.println("Enter "+size+" integers : "); 
    
        for(int i = 0 ; i<size ; i++)
        {
            arr[i] = sc.nextInt();
        }

        sort012(arr);

        System.out.println();
        System.out.println("Before: nums = "+ Arrays.toString(arr));
        System.out.println("After: nums =  "+ Arrays.toString(arr));
        sc.close();
    }
}