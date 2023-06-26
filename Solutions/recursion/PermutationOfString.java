import java.util.ArrayList;
/**
 * PermutationOfString
*/
public class PermutationOfString{
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> ans = new ArrayList<>();
        ans=permutation(str);
        System.out.println(ans);
    }
    
    static ArrayList<String> permutation(String str)
    {
        ArrayList<String> ans = new ArrayList<>();
        permutate(str,"",ans);
        return ans;
    }
    static void permutate(String str,String pS,ArrayList<String> ans)//pS is termed as processed String
    {
        if(str.isEmpty())
        {
            ans.add(pS);
            return;
        }

        char ch = str.charAt(0);
 
        for(int i=0; i<=pS.length() ; i++)
        {
            //i will be used to set the possitions(different) of ch
            String start = pS.substring(0, i);
            String end = pS.substring(i,pS.length());
            permutate(str.substring(1), start+ch+end , ans);
        }
    }
    /*
        number of permutations possible for String with length n is n!
        i.e, n*(n-1)*(n-2)*(n-3)-----------*1

        Time complexity of above program = 0(n!)
        observe the recursion tree for above code you will see that at each level 
        recursive calls are increasing by factorial time
        i.e, at each level factorial of pS.length() number of calls are made..
    */
}