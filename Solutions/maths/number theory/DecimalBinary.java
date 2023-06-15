import java.util.Scanner;
import java.lang.Math;
/*
Decimal to Binary:
    ex - 60
    60/2 = 30 , 60%2 = 0
    30/2 = 15 , 30%2 = 0
    15/2 =  7 , 15%2 = 1
    7/2 =  3 ,  7%2 = 1
    3/2 =  1 ,  3%2 = 1
    1/2 =  0 ,  1%2 = 1
    
ans => 111100
*/
public class DecimalBinary{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Decimal: ");
        int n = sc.nextInt();
        sc.close();
        Deci_to_Bin(n);
        
    }
    static void Deci_to_Bin(int n)
    {
        int ans = 0;
        int i = 0;
        while(n != 0 )
        {
            int bit = n & 1;
        //    System.out.println(bit);

            ans = (int) ( bit * Math.pow(10 , i) ) + ans;

            n = n>>1;
            i++;
        }
        System.out.println("Binary => " + "" +ans);
        Bin_to_Deci(ans);
    }

    static void Bin_to_Deci(int x)
    {
        int ans = 0;
        int i = 0;
        while(x != 0 )
        {
            int digit = x % 10;
        //    System.out.println(digit);
            if(digit == 1)
            {
                ans = (int)Math.pow(2 , i)  + ans;
            }

            x = x/10;
            i++;
        }
        System.out.println("Decimal => " + "" + ans);
    }
}