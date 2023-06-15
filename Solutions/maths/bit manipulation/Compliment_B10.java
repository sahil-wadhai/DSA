public class Compliment_B10{

    public static void main(String[] args) 
    {
        int n = 4;
        System.out.println(n + " => " + compliment(n));
    }
    /*
    given : num
        steps:
        1) number of bits =>(n bits)            ( log(num)/log(2) ) + 1
        2) create bit mask of n number of 1's
        3) num ^ bit_mask //it will update n bits , thus giving compliment of num..
    */
    static int compliment(int n)
    {
        if (n==0)
        {
            return 1;
        }
        int b_count = count(n); //number of bits in a number
        int mask = 0;
        int ans = 0;
        while(b_count != 0) //creating a mask with nbits number of 1's
        {
            mask = (mask << 1) | 1;
            b_count--;
        }
        ans = n ^ mask; //updating the bits
        return ans;
    }

    //finding number of bits in a number => nbits
    static int count(int x)
    {
        int counter = 0;
        while(x != 0)
        {
            x = x>>1;
            counter++ ;
        }
        return counter;
    }
}
