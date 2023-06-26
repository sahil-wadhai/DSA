import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    Given a string containing digits from 2-9 inclusive, 
    return all possible letter combinations that the number could represent. 
    Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below. 
    Note that 1 does not map to any letters.

    mapping of digits in phone pad:
    2 => "abc"
    3 => "def"
    4 => "ghi"
    5 => "jkl"
    6 => "mno"
    7 => "pqrs"
    8 => "tuv"
    9 => "wxyz"
    https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png 

    example:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/
public class PhoneLetterCombination {
    
    private static HashMap<Character,String> map = new HashMap<>();
    static List<String> letterCombinations(String digits) 
    {  
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        ArrayList<String> ans = new ArrayList<>();
        if(digits.isEmpty())
        {
            return ans;
        } 
        combinations(digits,"",ans);
        return ans;
    }
    private static void combinations(String digits, String pS, ArrayList<String>ans)
    {
        if(digits.isEmpty())
        {
            ans.add(pS);
            return;
        }
        char digit = digits.charAt(0);
        String letters = map.get(digit);

        for(int i = 0 ; i<letters.length(); i++)
        {
            char ch = letters.charAt(i);
            combinations(digits.substring(1), pS+ch, ans);
        }  
    }

    public static void main(String[] args) 
    {
        String str = "23";
        List<String> ans= new ArrayList<>();
        ans = letterCombinations(str);
        System.out.println(ans);
    }
}

