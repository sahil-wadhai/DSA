/*
    First and last index of an element in an array
*/
import java.util.Arrays;

public class FirstLastInd {

    public static void main(String[] args) {
        int [] arr = {5,5,6,7,7,7,7,8,9};
        int target = 7 ;

        int [] ans = searchRange(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] arr, int target) 
    {
        int [] ans = {-1,-1};
        
        ans[0] = firstInd(arr,target);
        ans[1] = lastInd(arr,target);
        
        return ans;    
    }

    static int firstInd(int [] arr ,int target)
    {
        int n = arr.length;
        int s = 0,e = n-1;
        int m , ans = -1;
        while(s<=e)
        {
            m = s + (e-s)/2;
            
            if(target<arr[s]|| target>arr[e])
            {
                break;
            }
            if(arr[m]==target)
            {
                ans = m;
                e = m-1;
            }
            else if(arr[m]<target)
            {
                s = m+1;   
            }
            else // arr[m] > target
            {
                e = m-1 ; 
            }
        }
        return ans;
    }
    
    static int lastInd(int [] arr ,int target)
    {
        int n = arr.length;
        int s = 0 , e = n-1;
        int m , ans = -1;
        while(s<=e)
        {
            m = s + (e-s)/2;
            
            if(arr[s]>target || arr[e]<target)
            {
                break;
            }
            if(arr[m]==target)
            {
                ans = m;
                s = m+1;
            }
            else if(arr[m]<target)
            {
                s = m+1;   
            }
            else
            {
                e = m-1 ; 
            }
        }
        return ans;
    }

}