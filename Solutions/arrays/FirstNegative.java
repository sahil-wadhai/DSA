import java.util.*;
/* 
  Given an array A[] of size N and a positive integer K, 
  find the first negative integer for each and every window(contiguous subarray) of size K.
*/
class FirstNegative
{
    static long[] firstNegativeInteger(long A[], int K)
    {
        int N = A.length;
        Queue<Long> q = new LinkedList<>();
        List<Long> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        while(j<N)
        {
            int size = j-i+1;
            
            if(A[j]<0) //only store negatives in queue
            {
                q.add(A[j]);
            }
            
            
            if( size < K )
            {
                j++;
            }
            else if(size==K)// if desired window size is achieved
            {
                //window can have more than one negative
                //but, choose the negative inserted first in the queue
                if(!q.isEmpty())
                {
                    ans.add(q.peek());
                }         
                else
                {   //if queue is empty then no negative is there in the window
                    ans.add(0L);
                } 
                    
                //before shiftting window forward
                //remove unnecessary negative. (i.e , which will not be considered further)
                if(A[i]<0)
                {   
                    q.remove();
                }
                
                i++;
                j++;
            }
            
        }
        
        //converting arraylist to primitive array
        long [] negs = new long[ans.size()];
        for(int k = 0 ; k<ans.size(); k++)
        {
            negs[k] = ans.get(k);
        }
        return negs;
    }


    //driver code
    public static void main(String[] args) 
    {
      long[] arr = {-8, 2, 3, -6, 10};
      int k =2;
      long [] ans = firstNegativeInteger(arr,k);
      System.out.println("Input : "+Arrays.toString(arr));
      System.out.println("Output : "+Arrays.toString(ans));
    }
}