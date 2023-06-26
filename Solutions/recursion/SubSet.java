import java.util.ArrayList;
import java.util.Arrays;

public class SubSet
 {
    //Pattern of taking some elements and removing some elements is known as Subset Pattern

    // 1) Subsequences of string using recursion
    static ArrayList<String> findSubseq1(String str)
    {
        ArrayList<String> ans = new ArrayList<>();
        subseq1(str,"",ans);
        return ans;
    }
    static void subseq1(String str ,String pS, ArrayList<String> ans)
    {
        if(str.isEmpty())
        {
            ans.add(pS);
            return;
        }
        //take first element in str -> process 1
        subseq1(str.substring(1), pS + str.charAt(0) , ans);
        //ignore first element in str -> process 2
        subseq1(str.substring(1),pS,ans);

        /*
         -> Here, Process1 keeps gettting executed recursively until str is empty
         -> then, when str gets empty it returns back one step while 
             adding the processed String(pS) into the List "ans"
         -> and then process 2 starts getting executed recursively...
        */
    }

    // 2)Finding SubSeq of a list iteratively..
    static ArrayList<ArrayList<Integer>> findSubseq2(ArrayList<Integer> list)
    {
        ArrayList<ArrayList<Integer>> outter = new ArrayList<>();
        outter.add(new ArrayList<>());
        for(int num : list)
        {
            int n = outter.size();
            for (int i = 0; i < n; i++) 
            {
                ArrayList<Integer> inner = new ArrayList<>(outter.get(i));
                //it will generate a copy of ith list in outter arraylist
                
                inner.add(num);
                outter.add(inner);
            }   
        }
        return outter;
    }

    // 3) finding SubSequence of a string iteratively
    static ArrayList<String> subSeqIter(String str)
    {
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        char [] arr = str.toCharArray();
        for(char ch : arr)
        {
            int n = ans.size();
            for(int i=0; i<n ; i++)
            {
                String inner = ans.get(i) + ch;
                ans.add(inner);
            }
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        // 1) Subsequences of string
        String str = "abc";
        ArrayList<String> subseqs = new ArrayList<>();
        subseqs = findSubseq1(str);
        System.out.println(subseqs);

        // 2) Subsequences of list
        ArrayList<Integer> list = new ArrayList<>( Arrays.asList(1,2,3) );
        ArrayList<ArrayList<Integer>> subset = new ArrayList<>(); 
        subset = findSubseq2(list);
        for (ArrayList<Integer> row : subset) 
        {
            System.out.println(row);
        }

        // 3) Subsequences with iterative approach
        subseqs = subSeqIter(str);
        System.out.println(subseqs);
    }
}
