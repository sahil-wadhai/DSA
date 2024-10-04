public class NumberOfSetBits {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + " => " + Integer.toBinaryString(num));

        int n = nSetBits(num);
        System.out.println("Number Of Set Bits = " + n);
    }
    static int nSetBits(int num)
    {
        // num & (-num) , gives number with only right most set bit of num
        // so , count++ and clear that set bit 
        // to clear right most set bit, do " num = num - ( num & (-num) ) "
        // do it until num == 0
        int count = 0;
        while(num > 0)
        {
            count++;
            num = num - ( num & (-num) ) ; // can also do XOR
        }
        return count;
    }
}
