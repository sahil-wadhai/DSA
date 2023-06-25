import java.util.Arrays;

public class MergeSort 
{

  //Function to Divide the array into left and right part recursively..
  static void mergeSort(int[]arr,int start,int end)
  {
    if(start>=end)
    {
      return;
    }

    int mid = start + (end-start)/2;
    mergeSort(arr,start,mid);
    mergeSort(arr,mid+1,end);
    
    merge(arr, start, mid, end);
  }

  //Function to merge the left and right array
  //left : (start to mid)
  //right : (mid+1 to end)
  private static void merge(int [] arr, int start, int mid, int end)
  {
    int left = start;
    int right = mid+1;
    int [] merged = new int[end-start+1]; //sorted elements will be stored in this array
    int k = 0;
    while(left<=mid && right<=end)
    {
      if(arr[left]<=arr[right])
      {
        merged[k] = arr[left];
        left++;
      }
      else
      {
        merged[k] = arr[right];
        right++;
      }
      k++;
    }
    while(left<=mid)
    {
      merged[k] = arr[left];
      k++;
      left++;
    }
    while(right<=end)
    {
      merged[k] = arr[right];
      k++;
      right++;
    }

    //making changes to original array, 
    //to make the array sorted from index start to end
    for(int i=start, j=0 ; i<=end && j<merged.length ; i++,j++)
    {
      arr[i] = merged[j];
    }
  }
  public static void main(String[] args) {
    int [] arr = {1,7,5,3};
    mergeSort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
}
