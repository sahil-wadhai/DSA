import java.util.*;
class RotateMatrix
{
    /*
        Brute Force : <=(solved)
        - Initialize new matrix
        - add elements from old to new in requirred manner

        optimized : 
        - Apply transpose on matrix
        - Reverse each row for clockwise rotation / Reverse each column for anti-clockwise rotation
    */
    
    static void rotateBy90(int[][] matrix) //clockwise
    {
        int n = matrix.length;

        //Apply transpose on matrix
        for(int i=0 ; i<n ; i++)
        {
            for(int j = i ; j<n ; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row
        for(int i=0 ; i<n ; i++)
        {
            int s = 0;
            int e = n-1;
            while(s<e)
            {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
    }

    public static void main(String[] args) 
    {
        int [][] matrix = { 
          {1,2,3} , 
          {4,5,6} , 
          {7,8,9} 
        };  

        System.out.println("\nInput: ");  
        for(int [] row:matrix)
        {
            System.out.println(Arrays.toString(row));  
        }

        rotateBy90(matrix); 

        System.out.println("\nOutput: ");
        for(int [] row:matrix)
        {
            System.out.println(Arrays.toString(row));  
        }
        
    }
}