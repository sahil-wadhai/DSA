import java.util.*;
class ValidParanthesis
{
    static boolean isValid(String s) 
    {
        Stack<Character> stk = new Stack<>();

        int n = s.length();
        char [] arr = s.toCharArray();

        for(int i=0 ; i<n ; i++)
        {
            if(arr[i]=='(' || arr[i]=='{' || arr[i]=='[')
            {
                stk.push(arr[i]);
            }
            else if(stk.isEmpty())
            {
                return false;
            }
            else
            {
                char top = stk.peek();
                if(paraMatch(top,arr[i]))
                {
                    stk.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        if(stk.empty())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    private static boolean paraMatch(char top , char para)
    {
        if(top=='(' && para==')') return true;
        if(top=='{' && para=='}') return true;
        if(top=='[' && para==']') return true;
        else return false;
    }
    
    public static void main(String[] args) 
    {
        String str = "()[]{}";
        boolean ans = isValid(str);
        System.out.println("Input : "+str);
        System.out.println("isValid : "+ans);
    }
}
