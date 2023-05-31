/*
    Includes : bubble sort , selection sort , insertion sort 
*/
import java.util.Arrays;

public class BasicSorting {
    public static void main(String[] args) {
        int [] arr = {4,2,7,5,4,6};
        System.out.println("Before Sorting : " + Arrays.toString(arr));
        bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        System.out.println("After Sorting : "+Arrays.toString(arr));
    }

    static void bubbleSort(int [] arr)
    {
        int n = arr.length;
        System.out.println("\nBubble Sort Steps : ");
        for (int i = 0; i < n; i++) 
        {
            boolean swapped = false;
            for (int j = 0; j < n-1-i ; j++) 
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }  
            }
            //System.out.println(Arrays.toString(arr));  
            if(!swapped) // if no swapping takes place
            {
                break;
            }
        }
        System.out.println();
    }

    static void selectionSort(int [] arr)
    {
        int n = arr.length;
        System.out.println("\nSelection Sort Steps : ");
        for (int i = 0; i < n-1 ; i++) 
        {
            int min = findMin(arr,i);
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            System.out.println(Arrays.toString(arr));    
        }
        System.out.println();
    }
    static int findMin(int [] arr,int start)
    {
        int n = arr.length;
        int minIndex = start;
        for(int i = start ; i<n ; i++)
        {
            if(arr[i] < arr[minIndex])
            {
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    static void insertionSort(int [] arr)
    {
        int n = arr.length;
        System.out.println("\nInsertion Sort Steps : ");
        for (int i = 1; i < n; i++) 
        {
            for  (int j = i-1 ; j>=0 && arr[j]>arr[j+1] ; j--) 
            {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
            }
            //System.out.println(Arrays.toString(arr));    
        }
        System.out.println();
    }

}