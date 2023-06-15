public class XOR_inRange {
    public static void main(String[] args) {
        int start = 3;
        int end = 10;
        int ans = xor_inRange( start ,  end );
        System.out.println(" XOR of " + start + " to " + end + " => " + ans);
    }
    static int xor_inRange(int start , int end)
    {
        int ans = xor_0toa(end) ^ xor_0toa( start-1 );
        return ans;
    }
    static int xor_0toa(int a)
    {
        //Optimized : O(1)
        //from below observation , we deduced that :
        if(a % 4 == 0)
        {
            return a;
        }
        if(a % 4 == 1)
        {
            return 1;
        }
        if(a % 4 == 2)
        {
            return a+1;
        }
        if(a % 4 == 3)
        {
            return 0;
        }
        return 0;
        /*
        Observation :
        0                 = 0
        0^1               = 1
        0^1^2             = 3
        0^1^2^3           = 0
        0^1^2^3^4         = 4
        0^1^2^3^4^5       = 1
        0^1^2^3^4^5^6     = 7
        0^1^2^3^4^5^6^7   = 0
        0^1^2^3^4^5^6^7^8 = 8
        
        so on....
        */
    }
    
}
