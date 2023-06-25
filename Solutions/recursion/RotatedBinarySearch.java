public class RotatedBinarySearch {
    //search in rotated Sorted array
    static int search(int [] arr, int target , int start , int end )
    {
        if(start>end)
        {
            return -1;
        }

        int mid = start + (end-start)/2;

        if(arr[mid] == target)
        {
            return mid;
        }
        
        if(arr[start]<=arr[mid])//it means array from start to mid is sorted..
        {
            //if target is in sorted part of the array..
            if(target >= arr[start] && target<arr[mid])
            {
                return search(arr,target,start,mid-1);
            }
            //if not then look into another part of the array..
            else
            {
                return search(arr,target,mid+1,end);
            }
        }
        
        //if there is decreasing area in between start and mid,
        //so make the following checks,to figure out where the element will be found
        if(target>=arr[mid] && target<=arr[end])
        { 
            return search(arr,target,mid+1,end);
        }
        else
        {
            return search(arr,target,start,mid-1);
        }
    }
    public static void main(String[] args) {
        int [] arr = {9,11,14,2,3,5,6,7,8};
        
        System.out.println(search(arr,9,0,arr.length-1));
    }
}
