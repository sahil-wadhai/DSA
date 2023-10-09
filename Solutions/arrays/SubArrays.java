// Java program to generate all possible subarrays/subArrays
class SubArrays
{    
    // Prints all subarrays in arr[0..n-1]
    static void subArray(int [] arr, int n)
    {
        // Pick starting point
        for (int i=0; i <n; i++)
        {
            // Pick ending point
            for (int j=i; j<n; j++)
            {
                // Print subarray between current starting
                // and ending points
                for (int k=i; k<=j; k++)
                    System.out.print(arr[k]+" ");
            }
        }
    }
    //  Complexity- O(n^3) */ 

    public static void main(String[] args) 
    {
        int arr[] = {1, 2, 3};
        System.out.println("All Non-empty Subarrays");
        subArray(arr,arr.length);
    }
}