//finding in range
import java.util.*;
public class NthRoot{
     
    static double root(int n , int x)
    {
        double start = 1.0d;
        double end = x;
        double p = 1e-6; // it will give precise value to 5 decimal places
        while((end-start)>p)
        {
            double mid = (start+end)/2;
            if((Math.pow(mid,n))==x)
            {
                return mid;
            }
            else if((Math.pow(mid,n)) > x)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        double ans = root(n,x);
        System.out.printf("%.5f",ans);
        sc.close();
    }
}
