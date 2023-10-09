import java.util.ArrayList;
import java.util.Arrays;

public class SubSets
 {
    //Pattern of taking some elements and removing some elements is known as Subset Pattern

    // Finding SubSeq of a list iteratively..
    static ArrayList<ArrayList<Integer>> findSubseq(ArrayList<Integer> list)
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

    //finding SubSequence of a string iteratively (Ignore it!)
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
        //Subsequences of list
        ArrayList<Integer> list = new ArrayList<>( Arrays.asList(1,2,3) );
        ArrayList<ArrayList<Integer>> subset = new ArrayList<>(); 
        subset = findSubseq(list);
        for (ArrayList<Integer> row : subset) 
        {
            System.out.println(row);
        }

    }
}
