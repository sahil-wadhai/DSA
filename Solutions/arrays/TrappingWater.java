import java.util.*;

class TrappingWater
{  
    /*
        Brute Force : 
        - count water trapped at each index by count left max and right max, for each index
        - water trapped at each index = Math.min(rightMax,leftMax) - height[i]  

        optimized : <=(solved)
        - Precount rightMax and LeftMax values for each index
        - water trapped at each index = Math.min(right[i],left[i]) - height[i]  

        best : Two pointer approach
    */
    static int trap(int[] height) 
    {
        int n = height.length;
        int [] left = new int[n]; //max till i from left
        int [] right = new int[n]; //max till i from right

        int maxH = height[0];
        for(int i = 0 ; i<n ; i++)
        {
            maxH = Math.max(height[i],maxH);
            left[i] = maxH;
        }

        maxH = height[n-1];
        for(int i = n-1 ; i>=0 ; i--)
        {
            maxH = Math.max(height[i],maxH);
            right[i] = maxH;
        }


        int water = 0;
        for(int i = 0; i<n; i++)
        {
            // counting water trapped at each index , 
            // i.e (Math.min(left[i],right[i]) - height[i])

            water += Math.min(left[i],right[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {

      int [] arr= {4,2,0,3,2,5}; // Given: majority element must exists
      
      System.out.println();

      System.out.println("Input: nums = "+ Arrays.toString(arr));  
      
      int ans = trap(arr);

      System.out.println("Output: "+ ans);
      
    }
}