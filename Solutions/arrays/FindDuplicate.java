/*
 * Link : https://leetcode.com/problems/find-the-duplicate-number
*/

import java.util.*;
class FindDuplicate{

    //solution
    static int findDuplicate(int[] nums) {

        int n = nums.length;
        int [] count = new int[n]; //store ocuurences of index

        //xor all numbers of array
        for(int i=0 ; i<n ; i++)
        {
            int d = nums[i];
            count[d]++; //count occurences of digit nums[i]
        }

        //return number with more than 1 occurence
        for(int i = 0 ; i<n ; i++)
        {
            if(count[i]>1)
            {
                return i;
            }
        }
        return -1;
    }
    
    //driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size : ");
        int size = sc.nextInt();

        int [] arr = new int[size];
        System.out.println("Enter "+size+" integers : "); 
    
        for(int i = 0 ; i<size ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = findDuplicate(arr);

        System.out.println();
        System.out.println("Input: nums = "+Arrays.toString(arr));
        System.out.println("Output: "+ans);
        sc.close();
    }

    
}