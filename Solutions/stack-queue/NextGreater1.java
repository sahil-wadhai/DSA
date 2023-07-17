import java.util.*;
public class NextGreater1
{
    static int[] nextGreaterElements(int [] arr)
    {
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        int j = n-1;
        while(j>=0)
        {
            if(st.isEmpty())
            {
                ans[j] = -1;
                st.push(arr[j]);
            }
            else
            {
                int curr = arr[j];

                while(!st.isEmpty() && curr>=st.peek())
                {
                    st.pop();
                }
                if(st.isEmpty()) ans[j] = -1;
                else ans[j] = st.peek();

                st.push(curr);
            }
            j--;
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        int [] arr = {1,2,3,4};
        int [] ans = nextGreaterElements(arr);
        System.out.println("Input : "+Arrays.toString(arr));
        System.out.println("output : "+Arrays.toString(ans));
    }
}