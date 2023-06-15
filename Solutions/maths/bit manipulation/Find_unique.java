import java.util.Scanner;

public class Find_unique {
    static int find_uniq(int [] arr)
    {
        int n = arr.length;
        /*
        for(int i =0 ; i < n ; i++)
        {
            boolean has_match = false;
            for(int j = 0 ; j < n ; j++)
            {
                if(i==j)
                    continue;
                if (arr[i]==arr[j]) 
                {
                    has_match = true;
                    break;
                }
            }
            if(has_match == false)
            {
                return arr[i];
            }  
        }
        return -1;
        */
        int ans = arr[0];
        for (int i = 1; i < n; i++) 
        {
            ans = ans^arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i =0 ; i<n ; i++)
        {
            arr[i]= sc.nextInt();
        }
        sc.close();
        System.out.println(find_uniq(arr));
    }
}