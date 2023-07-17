import java.util.*;
/*
    brute-force : 
    - at each index claculate next smallest at right and next smallest at left
    - (right-left+1) => number of elements in range 
    - so total area considering current index 'i' = (no. of elements)*heights[i]
    - update max if 'current area' > max

    optimized : 
    - same as brute force algorithm but,
    - precompute smallest elements at right for all indexes
    - as well as smallest elements at left for all indexes
    - using stack we can achieve it
    - so total area considering current index 'i' = (no. of elements)*heights[i]
    - update max if 'current area' > max
*/

public class LargestRectangle{
    static int bruteForce(int[] heights) 
    {
        int n = heights.length;
        int max = 0;
        for(int i = 0 ; i<n ; i++)
        {
            int sum = heights[i];
            sum += calcLeft(heights,i);
            sum += calcRight(heights,i);

            if(sum>max)
            {
                max = sum;
            }
        }
        return max;
    }
    static private int calcLeft(int[]heights , int ind)
    {
        if(ind<=0)
        {
            return 0;
        }
        int h = heights[ind];
        int sum = 0;
        for(int i = ind-1 ; i>=0 ; i--)
        {
            if( heights[i]<h )
            {
                break;
            }
            else //heights[i]>h
            {
                sum+=h;
            }
        }
        return sum;
    }
    static private int calcRight(int[]heights , int ind)
    {
        int n = heights.length;
        if(ind>=n-1)
        {
            return 0;
        }
        
        int h = heights[ind];
        int sum = 0;
        for(int i = ind+1 ; i<n ; i++)
        {
            if( heights[i]<h )
            {
                break;
            }
            else //heights[i]>h
            {
                sum+=h;
            }
        }
        return sum;
    }


    //Optimized solution
    static int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;
        int [] right = nseRight(heights);
        int [] left = nseLeft(heights);

        int max = 0;
        for(int i = 0 ; i<n ; i++)
        {
            int leftRange = left[i]+1;
            int rightRange = right[i]-1;

            int calc = (rightRange-leftRange + 1)*heights[i];
            if(calc>max)
            {
                max = calc;
            }
        }
        return max;
    }
    private static int[] nseRight(int [] heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int [] nse = new int[n];

        int i = n-1;
        while(i>=0)
        {
            if(st.isEmpty())
            {
                nse[i] = n; //next smallest doesnot exist at right side
            }
            else
            {
                int curr = heights[i];
                while(!st.isEmpty() && curr <= heights[st.peek()])
                {
                    st.pop();
                }
                if(st.isEmpty()) 
                {
                    nse[i] = n; //next smallest doesnot exist at right side
                }
                else
                {
                    nse[i] = st.peek();
                }
            }
            st.push(i);
            i--;
        }
        return nse;
    }
    private static int[] nseLeft(int [] heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int [] nse = new int[n];

        int i = 0;
        while(i<n)
        {
            if(st.isEmpty())
            {
                nse[i] = -1; //next smallest doesnot exist at left side
            }
            else
            {
                int curr = heights[i];
                while(!st.isEmpty() && curr <= heights[st.peek()])
                {
                    st.pop();
                }
                if(st.isEmpty()) 
                {
                    nse[i] = -1; //next smallest doesnot exist at left side
                }
                else
                {
                    nse[i] = st.peek();
                }
            }
            st.push(i);
            i++;
        }
        return nse;
    }

    public static void main(String[] args) 
    {
        int [] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(Arrays.toString(heights));
        System.out.println("output : "+ans);
    }
}