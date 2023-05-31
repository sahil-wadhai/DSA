//reference: https://takeuforward.org/data-structure/set-matrix-zero/

import java.util.Arrays;
public class SetMatrixZero {

    /*
        Brute Force : <=(solved)
        1] Traverse 2D array row-wise if any num is zero, then
        run a for loop to make each num in that row -1 and do same for columns..
        2] convert -1 values in the matrix to zero.

        optimized : <=(solved)
        1] use two arrays to represent rows and cols.
        2] if ith index of row marked with -1 , make all elements of that row index in matrix zero

    */

    static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int [] rowsArr = new int[rows];
        int [] colsArr = new int[cols];

        //To mark row and column
        for(int i=0; i<rows ; i++)
        {
            for(int j=0 ; j<cols ; j++)
            {
                if(matrix[i][j]==0)
                {
                    rowsArr[i] = -1; 
                    colsArr[j] = -1;
                    //marking row and column , which needs to set as zero
                }
            }
        }

        //To set marked row and column values to 0
        for(int i=0 ; i<rows ; i++)
        {
            for(int j=0 ; j<cols ; j++)
            {
                if(rowsArr[i]==-1 || colsArr[j]==-1)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        // time comp: O( 2(rows*cols) )
        // extra space : O(rows+cols)        
    }

    static void bruteForce(int [][] arr)
    {
        int rows = arr.length;
        int cols = arr[0].length;
        for(int i = 0 ; i<rows ;i++)
        {
            for(int j = 0; j<cols;j++)
            {
                if(arr[i][j]==0)
                {
                    for(int k = 0 ; k<cols ; k++)
                    {
                        if(k==j || arr[i][k]==0)
                        {
                            continue;
                        }
                        arr[i][k] = -1;
                    }
                    for(int k = 0 ; k<rows ; k++)
                    {
                        if(k==i || arr[i][k]==0)
                        {
                            continue;
                        }
                        arr[k][j] = -1;
                    }
                }
            }
        }
        for(int i = 0 ; i<rows ;i++)
        {
            for(int j = 0; j<cols;j++)
            {
                if(arr[i][j]==-1)
                {
                    arr[i][j]=0;
                }
            }
        }

        // O([(rows*cols) * (rows+cols)] + (rows*cols))
        // extra space = O(n)   
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        setZeroes(matrix);
        
        System.out.println();
        System.out.println();
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    
}
