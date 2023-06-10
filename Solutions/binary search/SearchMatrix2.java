import java.util.Arrays;
/*
 Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
 This matrix has the following properties:
  -Integers in each row are sorted in ascending from left to right.
  -Integers in each column are sorted in ascending from top to bottom.
*/

class SearchMatrix2{

    static int[] searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix.length;
        int n = matrix[0].length;

        // two pointer approach
        int row = 0;
        int col = n-1;
        int [] ans = {-1,-1};

        while(row < m  && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                ans[0]=row;
                ans[1]=col;
                return ans;
            }

            if(matrix[row][col] < target)
            {
                row++;
            }
            else
            {
                col--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
      int [][] matrix = {
        {1,4,7,11,15},
        {2,5,8,12,19},
        {3,6,9,16,22},
        {10,13,14,17,24},
        {18,21,23,26,30}
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