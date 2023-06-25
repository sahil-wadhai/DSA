import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,7,5,2,3,1,8};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //Quick Sort works by placing pivot element at correct possition.. 
    static void sort(int[]arr, int low, int high)
    {
        if(low>=high)//it means there is only one element at working area of the arr
        {
            return;
        }

        int start = low;
        int end = high;
        int pivot = arr[(start+end)/2];//pivot will be mid element
        //note : you can take any pivot

        // This Loop will shift elements less than pivot at left side of the pivot..
        // And elements greater than pivot will be shifted to right side of the pivot..
        while(start<=end)
        {
            //first we have to place start and end at requirred possition to do shifting/swapping
            while(arr[start] < pivot)
            {
                start++;
            }
            while(arr[end] > pivot)
            {
                end--;
            }

            if(start<=end)
            {
                //here shifting of elements takes place
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
                end--;
            }
        }
        sort(arr,low,end); // sort left side of the pivot..
        sort(arr,start,high); //sort right side of the pivot..
    }
    /*
    -->
        loop which is doing shifting is of O(n) time complexity..
        that loop is running for every divided array (considering pivot is mid value element)..
        after every call, array is divided into two parts 
        log(n)/log2 times array can be divided

        Therfore,Time Complexity of Quick Sort = O(nlogn)

        but if pivot is always the largest element or smallest element
        then, array will be divided n times ...

        So, worst case time Complexity becomes = O(n*n)
    -->   
        as quicksort does not use extra array,it is space effecient
        mostly for sorting arrays quickSort is preffered(inplace sorting is being done)
        quickSort is not stable, as even if two elements are equal swapping will take place

    -->
        Imp fact:
        internal sorting function uses hybrid sorting techniques 
        which are way much efficient..

        example:
        tim sort : merge sort + insertion sort 
    */
}
