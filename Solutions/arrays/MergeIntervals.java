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

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //takes O(nlogn)
        
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

/* Arrays.sort(intervals, (a,b) -> a[0] - b[0])

    1. `Arrays.sort`: This is a Java method used to sort arrays.

    2. `intervals`: This is the array that you want to sort.

    3. `(a, b) -> a[0] - b[0]`: This is a lambda expression (an anonymous function) 
    that defines how the elements in the `intervals` array should be compared for sorting. 
    
    In this lambda expression:
    - `(a, b)` are two elements (intervals) from the `intervals` array that are being compared.
    - `a[0]` represents the first element of the first interval `a`.
    - `b[0]` represents the first element of the second interval `b`.
    - `a[0] - b[0]` subtracts the first elements of `a` and `b`. The result determines the sorting order.

    - If `a[0]` is less than `b[0]`, the result is negative, indicating that `a` should come before `b` in the sorted array.
    - If `a[0]` is greater than `b[0]`, the result is positive, indicating that `b` should come before `a` in the sorted array.
    - If `a[0]` is equal to `b[0]`, the result is zero, indicating that `a` and `b` have the same order in the sorted array.

    So, this code will sort the `intervals` array based on the first element of each interval in ascending order. 
    After the sorting is complete, the `intervals` array will be rearranged 
    such that intervals with smaller first elements come first, 
    and intervals with larger first elements come later in the array.
*/