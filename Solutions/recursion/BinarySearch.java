/*
    Tip : Figure out which variable should placed where

    Variables Involved in Recursion:
        1) Variables in Argument
        2) Variables in Return Type
        3) Variables in body of the function
*/
/*
    This file Contains :
    Basic Binary Search
    Rotated Binary Search
*/
import java.util.Arrays;
public class BinarySearch {
  static int binarySearch(int [] arr,int target,int start,int end)
  {
    if(start>end)
    {
      return -1;
    }
    int mid = start + (end-start)/2;
    if(arr[mid]==target) 
      return mid;
    else if(arr[mid]>target) 
      return binarySearch(arr, target, start, mid-1);
    else 
      return binarySearch(arr, target, mid+1, end);
  }

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
      //so make the following checks,to figure out where the element will be found.
      if(target>=arr[mid] && target<=arr[end])
      { 
          return search(arr,target,mid+1,end);
      }
      else
      {
          return search(arr,target,start,mid-1);
      }
  }

  //Recurrence relation : f(n) = O(1) + f(n/2)
  // O(1) for comparring
  // f(n/2) for dividing

  /*
    Types of Recurence Relation :
    1) Linear Recurence - ex, Finding nth fibonacci number
    2) Divide and Conquer Recurence (input/argument is divided/reduced by a factor) - ex, Binary Search

    Note : Divide and Conquer Recurences are much more optimized than linear recurences
  */

  //driver code
  public static void main(String[] args) {
    int target,targetInd;

    int [] arr1 = {1,3,5,8,10,11,14,15,16,18,21,23};
    target = 21;
    targetInd = binarySearch(arr1, target, 0, arr1.length);
    System.out.println("\n"+Arrays.toString(arr1) + " , target : "+target);
    System.out.println("pos: "+targetInd);

    int [] arr2 = {9,11,14,2,3,5,6,7,8}; //Rotated Sorted Array
    target = 11;
    targetInd = search(arr2, target, 0, arr2.length-1);
    System.out.println("\n"+Arrays.toString(arr2) + " , target : "+target);
    System.out.println("pos: "+targetInd);
  }
}
