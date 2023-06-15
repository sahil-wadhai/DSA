public class XOR_0toa {
    public static void main(String[] args) {
        int a = 5;
        int ans = xor_0toa(a);
        System.out.println("XOR of 0 to " + a + " => " +ans);
    }
    static int xor_0toa(int a)
    {
        /* Brute Force : O(n)
        int ans = 0;
        for (int i = 0; i <= a; i++) 
        {

            ans = ans ^ i;
        }
        return ans;
        */

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
    }
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
