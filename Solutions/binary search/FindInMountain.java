import java.util.Arrays;

public class FindInMountain{
    public static void main(String[] args) {
        int [] arr = {3,5,3,2,0};
        int peak = findPeak(arr);
        int target = 2;
        int ind = searchInMountain(arr,peak,target);
        System.out.println(Arrays.toString(arr));
        System.out.println(target +" => "+ind);
    }
    static int findPeak(int [] arr) 
    {
        int s = 0 , e = arr.length-1;
        while(s<e)
        {
            int m = s + (e-s)/2;
            
            if(m>0 && m<=e)
            {
                if(arr[m] > arr[m-1] && arr[m] > arr[m+1] )
                {
                    return m;
                }
            }
            if(arr[m] < arr[m+1])
            {
                s = m+1;
            }
            else // arr[m] > arr[m+1]
            {
                e =m-1;
            }
        }
        return s;
    }
    static int searchInMountain(int [] arr,int peak,int target)
    {
        if(arr[peak]==target)
        {
            return peak;
        }
        int ans = -1;
        ans = binarySearch(arr,0,peak-1,target);
        if(ans == -1)
        {
            ans = binarySearch(arr, peak+1, arr.length-1 , target);
        }
        return ans;
    }
    
    //Order Agnostic Binary Search..
    static int binarySearch(int [] arr,int start,int end,int target)
    {
        if(arr[start] < arr[end])
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
        }
        else
        {
            while(start<=end)
            {
                int mid = start + (end-start)/2;
                if(arr[mid]==target)
                {
                    return mid;
                }
                else if(arr[mid]>target)
                {
                    start=mid+1;
                }
                else // arr[mid] < target
                {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
