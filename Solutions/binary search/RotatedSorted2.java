/*
    Search in Rotated Sorted array (not necessarily distinct elements)
*/
import java.util.Arrays;
public class RotatedSorted2 {
    public static void main(String[] args) 
    {
        int [] arr = {1,0,1,1,1} ;
        int target = 0;
        int ind = searchInRotated(arr,target);
        System.out.println(Arrays.toString(arr));
        System.out.println("Index of Target : " + ind);
    }

    static int searchInRotated(int[] arr, int target) 
    {
        int pivotInd = findPivotInDuplicates(arr); //largest element index

        if(target == arr[pivotInd])
        {
            return pivotInd;
        }
        
        if(arr[0]==target)
        {
            return 0;
        }
        
        if(target > arr[0] && target < arr[pivotInd])
        {
            return binarySearch(arr, 0 , pivotInd-1, target);
        }
        else // (target < arr[0])
        {
            return binarySearch(arr, pivotInd+1 , arr.length-1, target);
        }
    }

    static int findPivotInDuplicates(int [] arr)
    {
        int s = 0,e = arr.length-1;
        
        /*
        if(arr[e] > arr[s]) // array is not rotated
        {
            return e;
        }
        */
        while (s<e)
        {
            int m = s + (e-s)/2;
            
            //To Detect Only Decreasing Part of Array
            if(arr[m] > arr[m+1] )
            {
                return m;
            }
            if(m>0 && arr[m] < arr[m-1])
            {
                return m-1;
            }
            
            //Condition to deal with duplicates
            if(arr[m] == arr[s] && arr[m] == arr[e])
            {     
                //skip start when it is not pivot
                if(arr[s] > arr[s+1])
                {
                    return s;
                }
                else
                {
                    s++;
                }
                
                //skip end when it is not pivot
                if(arr[e] < arr[e-1])
                {
                    return e-1;
                } 
                else
                {
                    e--;
                }
            }
            else if( arr[m] >= arr[s])
            {
                s = m+1;
            }
            else //arr[m] < arr[s]
            {
                e = m-1;
            }
        }
        return s;
    }
    
    static int binarySearch(int [] arr,int start,int end,int target)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]<target)
            {
                start=mid+1;
            }
            else // arr[mid] > target
            {
                end = mid-1;
            }
        }
        return -1;
    }
}