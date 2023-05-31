//reference: https://www.geeksforgeeks.org/merging-intervals/

import java.util.*;
class MergeSortedArrays
{
    /*
        brute-force : sort then create set of overlapping intervals for all intervals then add it to new array. O(n*n)
        optimized : sort and then merge overlap intervals <=(solved) takes : O(n*logn)
    */

    static int[][] mergeIntervals(int[][] intervals) 
    {
        int n = intervals.length;
        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]); //takes O(nlogn)
        
        merged.add( new ArrayList<>());
        merged.get(0).add(intervals[0][0]) ;
        merged.get(0).add(intervals[0][1]) ;

        int k = 0; //pointing last interval in merged array

        for(int i = 1 ; i< n ; i++)
        {
            int s = merged.get(k).get(0); //optional ...no need in the code
            int e = merged.get(k).get(1);
            // Here, s,e represent start,end of last interval of merged resp.

            if( e >= intervals[i][0] ) 
            {   //it means current interval overlaps with last interval of merged
                //so merge them

                e = Math.max( e , intervals[i][1] );
                merged.get(k).set(1,e);
            }
            else
            {   //it means current interval doesn't overlaps with last interval of merged 
                //so make new interval 
                
                merged.add( new ArrayList<>());
                k++;
                
                merged.get(k).add(intervals[i][0]) ;
                merged.get(k).add(intervals[i][1]) ;
            }
        }

        //Converting ArrayList to primitive array.
        int [][] ans = new int[merged.size()][2];
        int i = 0;
        for(ArrayList<Integer> list : merged)
        {
            ans[i][0] = list.get(0);
            ans[i][1] = list.get(1);
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {

        int [][] intervals = { {8,10} , {1,3} ,  {15,18} , {2,6}};

        int [][] ans = mergeIntervals(intervals);

        System.out.println();
        System.out.println("Input: "+ Arrays.toString(intervals));
        System.out.println("Output: "+ Arrays.toString(ans));

    }
}