import java.util.Arrays;

/*
    Number of times array is Rotated in Rotated Sorted Array
*/
public class CountRotations {
    public static void main(String[] args) {
        int [] arr = {2,2,0,1,1,2};
        int rotationCount = countRotations(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of Rotations = " + rotationCount);
    }
    
    static int countRotations(int [] arr)
    {
        // count = pivotIndex + 1 ;
        return findPivotInDuplicates(arr) + 1 ;
    }

    static int findPivotInDuplicates(int [] arr)
    {
        int s = 0,e = arr.length-1;
        
        /*
        if(arr[e] > arr[s]) // array is not rotated
        {
            return e;
        }
        */
        while (s<e)
        {
            int m = s + (e-s)/2;
            
            //To Detect Only Decreasing Part of Array
            if(arr[m] > arr[m+1] )
            {
                return m;
            }
            if(m>0 && arr[m] < arr[m-1])
            {
                return m-1;
            }
            
            //Condition to deal with duplicates
            if(arr[m] == arr[s] && arr[m] == arr[e])
            {     
                //skip start when it is not pivot
                if(arr[s] > arr[s+1])
                {
                    return s;
                }
                else
                {
                    s++;
                }
                
                //skip end when it is not pivot
                if(arr[e] < arr[e-1])
                {
                    return e-1;
                } 
                else
                {
                    e--;
                }
            }
            else if( arr[m] >= arr[s])
            {
                s = m+1;
            }
            else //arr[m] < arr[s]
            {
                e = m-1;
            }
        }
        return s;
    }    
}
