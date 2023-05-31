//reference: https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/

import java.util.*;
class MergeSortedArrays{
    /*
        Brute Force : Combine both array and then apply sort function
        optimized : use two pointers (preffered when new merged array is needed) <=(solved)
        best : use gap algorithm (preffered when previous arrays needed to be sorted according to sequence)
    */

    //new merged array
    static int[] mergeSorted(int[] A , int[] B) 
    {
        int n1 = A.length;
        int n2 = B.length;
        int i = 0;
        int j = 0;

        int[] merged = new int[n1+n2];
        int k = 0;

        while(i<n1 && j<n2)
        {
            if(A[i]<=B[j])
            {
                merged[k] = A[i];
                i++;
            }
            else
            {
                merged[k]=B[j];
                j++;
            }
            k++;
        }

        while(i<n1)
        {
            merged[k] = A[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            merged[k] = B[j];
            j++;
            k++;
        }
        return merged;
    }

    //sort without extraspace
    static void gapAlgo(int[] A , int[] B) 
    {

        return;
    }
    

    public static void main(String[] args) {

        int [] arr1= { 1, 4, 7, 8, 10 };
        int [] arr2 = {2,3,9};

        int [] ans = mergeSorted(arr1,arr2);

        // To merge without extra space..
        gapAlgo(arr1,arr2); //..existing arrays are converted

        System.out.println();
        System.out.println("Input: arrays= "+ Arrays.toString(arr1) +" "+Arrays.toString(arr2));
        System.out.println("Output: "+ Arrays.toString(ans));

        System.out.println("\n Using Gap algorithm");
        System.out.println("Output :\nA = "+ Arrays.toString(arr1) +"\nB = "+Arrays.toString(arr2));

        
    }
}