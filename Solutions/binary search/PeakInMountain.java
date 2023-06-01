import java.util.Arrays;

public class PeakInMountain {

    static int findPeak(int[] arr) 
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
                e = m-1;
            }
        }
        return s;
    }
    public static void main(String[] args) 
    {
        int [] arr = {1,3,5,3,2,0};
        System.out.println(Arrays.toString(arr));
        int ans = findPeak(arr);
        System.out.println("Peak Element = " + arr[ans]);
        System.out.println("Peak Index = " + ans);
    }
    
}