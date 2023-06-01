import java.util.Arrays;

/*
    Find in infinite sorted array
*/
public class FindInInfy {
    public static void main(String[] args) 
    {
        int [] infinite_arr = new int[200];
        for (int i = 0 , j=0 ; j < infinite_arr.length ; i+=2,j++)
        {
            infinite_arr[j] = i;
        }
        System.out.println(Arrays.toString(infinite_arr));

        int target = 100;
        System.out.println("Target : " + ""+target);

        int pos = findPos(infinite_arr,target);
        System.out.println("Possition of \'" + target + "\'" + " = " + pos);
    }

    static int findPos(int [] arr,int target)
    {
        int s = 0,e = 1;
        int pos = -1;
        while(s<=e)
        {
            int m = s + (e-s)/2;
            if(target<arr[s])
            {
                break;
            }
            if(target > arr[e])
            {
                int temp = e;
                /*
                doubling the search area { (e-s+1) } 
                represents no. of elements in previous area
                */
                e = e + (e-s+1)*2; 
                s = temp + 1;
            }
            else if(target==arr[m])
            {
                pos = m;
                break;
            }
            else if(target > arr[m])
            {
                s = m+1;
            }
            else // target < arr[m]
            {
                e = m-1;
            }
        }
        return pos;
    }
}