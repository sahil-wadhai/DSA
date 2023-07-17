import java.util.*;
public class NextGreater2
{
    static int[] nextGreaterElements(int [] arr)
    {
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        int i = (2*n)-1;
        while(i>=0)
        {
            if(st.isEmpty())
            {
                ans[i%n] = -1;
                st.push(arr[i%n]);
            }
            else
            {
                int curr = arr[i%n];

                while(!st.isEmpty() && curr>=st.peek())
                {
                    st.pop();
                }
                if(st.isEmpty()) ans[i%n] = -1;
                else ans[i%n] = st.peek();

                st.push(curr);
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        int [] arr = {1,2,3,4,3};
        int [] ans = nextGreaterElements(arr);
        System.out.println("Input : "+Arrays.toString(arr));
        System.out.println("Output : "+Arrays.toString(ans));
    }
}