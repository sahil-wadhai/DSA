import java.util.Arrays;
/*
    Search in Rotated Sorted Array (all unique elements)
*/
public class RotatedSorted1 
{
    static int searchInRotated(int[] arr, int target) 
    {
        int pivotInd = findPivot(arr); //largest element index

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
    
    static int findPivot(int [] arr)
    {
        int s = 0,e = arr.length-1;
        
        if(arr[e] > arr[s]) // array is not rotated
        {
            return e;
        }

        while (s<e)
        {
            int m = s + (e-s)/2;
            
            if(arr[m] > arr[m+1] )
            {
                return m;
            }
            if(m>0 && arr[m] < arr[m-1])
            {
                return m-1;
            }
            
            if( arr[m] > arr[s])
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
    public static void main(String[] args) 
    {
        int [] arr = {4,5,6,7,0,1};
        int target = 5;
        int ind = searchInRotated(arr,target);
        System.out.println(Arrays.toString(arr));
        System.out.println("Index of Target : " + ind);
    }
    
}