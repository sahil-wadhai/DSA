import java.util.*;
class MajorityElement2
{
    /*
        Brute Force : <=(solved)
        - using map

        optimized : 
        - Moore voting algorithm - extension
        - only two elements can occur more than n/3 times
        - Find two elements which are occuring comparitively more than others using moore voting algo extension
        - Calculate count of the elements
        - elements count > n/3 are the requirred elements
    */
    
    private static List<Integer> majorityElement(int[] nums) //moore algorithm extension
    {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        //only two elements can occur more than n/3 times
        int ele1 = -1;
        int count1 = 0;

        int ele2 = -2;
        int count2 = 0;

        for(int i=0 ; i<n ; i++)
        {       
            if(ele1 == nums[i])
            {
                count1++;
            }
            else if(ele2 == nums[i])
            {
                count2++;
            }
            else if(count1==0)
            {
                ele1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                ele2 = nums[i];
                count2 = 1;
            }  
            else
            {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        //System.out.println(ele1 + " " + ele2);

        for(int i = 0; i<n ; i++)
        {
            if(ele1==nums[i]) count1++;
            if(ele2==nums[i]) count2++;
        }
        if(count1>n/3) ans.add(ele1);
        if(count2>n/3) ans.add(ele2);

        return ans;
    }
    
    @SuppressWarnings("unused")
    private static List<Integer> bruteForce(int [] nums)
    {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<n ; i++)
        {
            if(map.containsKey(nums[i]))
            {
                int f = map.get(nums[i])+1;
                map.put(nums[i],f);
            }
            else
            {
                map.put(nums[i],1);
            }
        }

        for(int key : map.keySet())
        {
            if(map.get(key)>n/3)
            {
                ans.add(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int [] arr= {2,1,1,3,1,4,5,6}; // Given: majority element must exists
        
        System.out.println();

        System.out.println("Input: nums = "+ Arrays.toString(arr));  

        System.out.println("Output: "+ majorityElement(arr));
        
    }
}