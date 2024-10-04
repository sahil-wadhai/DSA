import java.util.Arrays;

public class PeakInMountain {

    static int findPeak(int[] arr) 
    {
        int n = arr.length;
        int s = 0 , e = arr.length-1;
        while(s<e)
        {
            int m = s + (e-s)/2;
            
            if(m>0 && m<n-1 && arr[m]>arr[m-1] && arr[m]>arr[m+1])
            {
                return m;
            }
            if(m==0 && arr[m]>arr[m+1]) //means array is sorted in decreasing order
            {
                return m;
            }
            if(m==n-1 && arr[m]>arr[m-1]) //means array is sorted in increasing order
            {
                return m;
            }

            if(arr[m] < arr[m+1]) //m is in increasing part of array 
            {
                s = m+1;
            }
            else // arr[m] > arr[m+1] , m is in decreasing part of array
            {
                e = m-1;
            }
        }
        return s;
    }
    public static void main(String[] args) 
    {
        int [] arr = {3,4,5,6,1,2};
        System.out.println(Arrays.toString(arr));
        int ans = findPeak(arr);
        System.out.println("Peak Element = " + arr[ans]);
        System.out.println("Peak Index = " + ans);
    }
    
}