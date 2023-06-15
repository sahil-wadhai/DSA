/**
 * Find_duplicate
 */
public class Find_duplicate {
    static int find_duplicate(int [] arr)
    {   int n = arr.length; 
        /*  
        for(int i =0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i==j)
                    continue;
                if (arr[i]==arr[j]) 
                {
                    return arr[i];
                }
            }
        }
        return -1;
        */
        int ans = 0;
        for (int i = 0; i < n; i++) 
        {
            ans = ans ^ arr[i] ;
        }
        for (int i = 1 ; i < n ; i++)
        {
            ans = ans ^ i ;
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1 , 2 , 3 , 2 , 4 };
        System.out.println(find_duplicate(arr));
    }    
}