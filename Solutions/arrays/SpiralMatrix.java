import java.util.List;
import java.util.ArrayList;
/*

In this approach, we will be using four loops to print all four sides of the matrix.

1st loop: This will print the elements from left to right.

2nd loop: This will print the elements from top to bottom.

3rd loop: This will print the elements from right to left.

4th loop: This will print the elements from bottom to top.

*/
public class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        int startRow = 0;
        int endRow = m-1;
        int startCol = 0;
        int endCol = n-1;

        while(count<m*n){
            //left to right
            for(int i = startCol; i<=endCol && count<m*n ; i++){
                spiral.add(matrix[startRow][i]);
                count++;
            }

            //top to bottom
            for(int i = startRow+1 ; i<=endRow && count<m*n ; i++){
                spiral.add(matrix[i][endCol]);
                count++;
            }

            //right to left
            for(int i = endCol-1; i>=startCol && count<m*n ; i--){
                spiral.add(matrix[endRow][i]);
                count++;
            }

            //bottom to top
            for(int i= endRow-1 ; i>startRow && count<m*n; i--){
                spiral.add(matrix[i][startCol]);
                count++;
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return spiral;
    }
}