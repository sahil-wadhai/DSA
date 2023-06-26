// Skip a Character in a string and return that string..

public class StringBasics {
    public static void main(String[] args) {
        String str = "wadhaipsychosahil";
        str = skipChar1(str,'a');
        System.out.println(str);

        str = skipChar2(str,'a');
        System.out.println(str);

        str = skipString(str,"psycho");
        System.out.println(str);
    }

    static String skipChar1(String str,char ch)
    {
        return skipper(str, ch, 0,str.length(), "");
    }
    static String skipper(String str, char ch, int i, int n, String ans)
    {
        if(i>=n)
        {
            return ans;
        }
        if(str.charAt(i) != ch)
        {
            // to add a char (at beginning or at the end) to a string 
            // '+' Operator is used..
            ans = ans + str.charAt(i);
        }
        ans = skipper(str, ch, i+1,n, ans);
        return ans;
    }

    //Using substring function in java
    //Basically substring function returns a copy of string having some characters removed

    /*
    --> substring(int startIndex):
    This method returns new String object containing the substring of the given string 
    from specified startIndex (inclusive). 
    The method throws an IndexOutOfBoundException when the startIndex 
    is larger than the length of String or less than zero. 

    --> substring(int startIndex, int endIndex):
    This method returns new String object containing the substring of the given string 
    from specified startIndex to endIndex. 
    The method throws an IndexOutOfBoundException 
    when the startIndex is less than zero or startIndex is greater than endIndex 
    or endIndex is greater than length of String.
    */

    static String skipChar2(String str , char ch)
    {
        return skipper(str,ch,"");
    }
    static String skipper(String str,char ch ,String ans)
    {
        if(str.isEmpty()) //returns true if string becomes empty..
        {
            return ans; 
        }
        if(str.charAt(0) == ch)
        {
            return skipper(str.substring(1) , ch , ans);
        }
        else
        {
            return skipper(str.substring(1), ch , ans + str.charAt(0));
        }
    }

    static String skipString(String str , String ur)
    {
        return stringSkipper(str,ur,"");
    }
    static String stringSkipper(String str , String ur , String ans)
    {
        if(str.isEmpty())
        {
            return ans;
        }
        if(str.startsWith(ur)) //String.startsWith("") returns boolean value
        {
            return stringSkipper(str.substring(ur.length()), ur, ans);
        }
        else
        {
            char ch = str.charAt(0);
            return stringSkipper(str.substring(1), ur, ans+ch);
        }
    }
}
