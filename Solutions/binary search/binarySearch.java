//import java.util.*;
public class binarySearch {

    static int search(int[]arr,int target)
    {
        int s = 0;
        int e = arr.length-1;

        while(s<=e)
        {
            int m = s + (e-s)/2;
            if(arr[m]==target)
            {
                return m;
            }
            if(arr[m] > target)
            {
                e = m-1;
            }
            else //arr[m] < target
            {
                s = m+1;
            }
        }
        return -1; //if target not found
    }
    public static void main(String[] args) {
        int [] arr = {1,5,7,8,12,19,23};

        int target = 19;
        int ans = search(arr,target);

        System.out.println(ans);
    }
}