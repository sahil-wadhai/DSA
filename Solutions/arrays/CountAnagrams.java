import java.util.*;
/*
 Given a word pat and a text txt. 
 Return the count of the occurrences of anagrams of the word in the text.
*/

class CountAnagrams
{

    static int count(String pat, String txt) 
    {
        char [] str = txt.toCharArray();
        char [] pattern = pat.toCharArray();
        
        int N = str.length;
        int k = pattern.length;
        
        HashMap<Character,Integer> patMap = new HashMap<>();
        HashMap<Character,Integer> currMap = new HashMap<>();
        for(char ch : pattern)
        {
            if(patMap.containsKey(ch))
            {
                int f = patMap.get(ch);
                patMap.put(ch,f+1);
            }
            else
            {
                patMap.put(ch,1);
            }
        }
        
        
        int count=0;
        int i = 0;
        int j = 0;
        while(j<N)
        {
            char ch = str[j];
            
            if(currMap.containsKey(ch))
            {
                int f = currMap.get(ch);
                currMap.put(ch,f+1);
            }
            else
            {
                currMap.put(ch,1);
            }
            
            
            int wsize = j-i+1;
            if(wsize<k)
            {
                j++;
            }
            else if(wsize==k)
            {
                if(currMap.equals(patMap)) count++ ;
                
                char temp = str[i];
                int f = currMap.get(temp);
                
                if(f-1<=0) currMap.remove(temp);
                else currMap.put(temp,f-1);
                
                i++;
                j++;
            }
        }
        return count;
    }


    //driver code
    public static void main(String[] args) 
    {
        String txt = "aabaabaa";
        String pat = "aaba";
        int ans = count(pat,txt);
        System.out.println("String  : "+txt);
        System.out.println("Pattern : "+pat);
        System.out.println("Output : "+ans);
    }
}