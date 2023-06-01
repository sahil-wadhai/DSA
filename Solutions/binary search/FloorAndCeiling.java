import java.util.Arrays;

public class FloorAndCeiling {

    static char floor(char[]letters, char target)
    {
        int s = 0 , e = letters.length - 1 ;
        
        if(target > letters[e] || target <= letters[s])
        {
            return letters[e];
        }
        
        while(s<=e)
        {
            int m = s + (e-s)/2;
            
            if( letters[m] >= target)
            {
                e = m - 1;       
            }
            else //letters[m] < target
            {
                s = m + 1;
            }
        }
        return letters[e];
    }

    static char ceiling(char[]letters,char target)
    {
        int s = 0 , e = letters.length - 1 ;
        
        if(target >= letters[e] || target < letters[s]) //given : letters wrap around.
        {
            return letters[0];
        }
        
        while(s<=e)
        {
            int m = s + (e-s)/2;
            
            if( letters[m] <= target)
            {
                s = m + 1;
            }
            else //letters[m] > target
            {
                e = m-1;
            }
        }
        return letters[s];
    }
    public static void main(String[] args) 
    {
        char [] arr = {'a','b','c','c','d','f','h'};
        char ch = 'd';

        char f = floor(arr,ch);
        char c = ceiling(arr, ch);

        System.out.println("\nInput : "+ Arrays.toString(arr) + " ,  target : "+ ch);
        System.out.printf("\nOutput : \nFloor : %s \nCeil : %s",f,c);
    }
}