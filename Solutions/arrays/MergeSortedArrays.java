import java.util.*;

//reference: https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
class MergeSortedArrays{
    /*
        Brute Force : Combine both array and then apply sort function
        optimized : use two pointers (preffered when new merged array is needed) <=(solved)
        best : use gap algorithm (preffered when previous arrays needed to be sorted according to sequence) <=(solved)
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

    //sort without extraspace : gap algorithm
    static void gapAlgo(int[] A , int[] B) 
    {
        int n1 = A.length;
        int n2 = B.length;
        int n = n1 + n2;
        int gap = (int)Math.ceil((float)n/2);

        while(gap>1)
        {
            for(int i = 0; i<=n-gap ; i++)
            {
                int j = i+gap-1;

                int secondi = -1;
                int secondj = -1;

                if(i>=n1) secondi = i-n1;
                if(j>=n1) secondj = j-n1;

                if(secondi<0 && secondj<0)
                {
                    if(A[i]>A[j])
                    {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                    }   
                }
                else
                {
                    if(secondi>=0)
                    {
                        if(B[secondi]>B[secondj])
                        {
                            int temp = B[secondi];
                            B[secondi] = B[secondj];
                            B[secondj] = temp;
                        }
                    }
                    else if(secondi<0 && secondj>=0)
                    {
                        if(A[i]>B[secondj])
                        {
                            int temp = A[i];
                            A[i] = B[secondj];
                            B[secondj] = temp;
                        }
                    }
                }
            }
            gap--;
        }
        return;
    }
    

    public static void main(String[] args) {

        int [] arr1= { 1, 4, 7, 8, 10 };
        int [] arr2 = {2,3,9};

        //merge with extra space
        //int [] ans = mergeSorted(arr1,arr2);

        // To merge without extra space..
        gapAlgo(arr1,arr2); //..existing arrays are converted

        System.out.println();
        System.out.println("Input: arrays= "+ Arrays.toString(arr1) +" "+Arrays.toString(arr2));
        // System.out.println("Output: "+ Arrays.toString(ans));

        System.out.println("\n Using Gap algorithm");
        System.out.println("Output :\nA = "+ Arrays.toString(arr1) +"\nB = "+Arrays.toString(arr2));

        
    }
}