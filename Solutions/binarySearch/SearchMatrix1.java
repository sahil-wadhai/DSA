import java.util.Arrays;
/*
 You are given an m x n integer matrix matrix with the following two properties:
  -Each row is sorted in non-decreasing order.
  -The first integer of each row is greater than the last integer of the previous row.
*/

class SearchMatrix1 {
    static int[] searchMatrix(int[][] matrix, int target) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = (rows*cols)-1;
        int [] ans = {-1,-1};

        while(start<=end)
        {
            int mid = start + (end-start)/2;
            int r = mid/cols ;
            int c =  mid%cols ;

            int ele = matrix[r][c];

            if( target == ele )
            {
              ans[0] = r;
              ans[1] = c;
              return ans;
            }
            else if( target > ele)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
      int [][] matrix = {
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60}
      };
      int target = 16;

      int [] ans = searchMatrix(matrix, target);
      System.out.println("\nInput : ");
      for(int [] row : matrix)
      {
        System.out.println(Arrays.toString(row));
      }
      System.out.println("Target : "+target);
      System.out.println("\nOutput(Target coordinates) : "+Arrays.toString(ans));
    }
}