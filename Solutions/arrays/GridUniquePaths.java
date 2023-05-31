//reference: https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/

import java.util.*;
class GridUniquePaths
{
    /*
        brute-force : Recursion <=(solved)
        optimized : DP  <=(solved)
        best : combinatorics <=(solved)
    */

    static int uniquePaths2(int rows, int cols) // using nCr
    {
        int maxRights = cols-1;
        int maxDowns = rows-1;

        int totalMoves = maxRights + maxDowns; //represents n in binomial coeffiecient (nCr)
        return binomialCoeff(totalMoves, maxRights);
    }
    private static int binomialCoeff(int N , int r)
    {
        int res = 1;
        for(int i=1 ; i<=r ; i++)
        {
            res = res * (N-r+i)/i;
        }
        return res;
    }

    static int uniquePaths(int m, int n) //DP Solution 
    {
        //return bruteForce(0,0,m,n);
        int [][] dp = new int[m][n];
        for(int i = 0; i<m ; i++)
        {
            for(int j=0; j<n ; j++)
            {
                dp[i][j]=-1;
            }
        }
        return countPaths(0,0,m,n,dp);
    }
    private static int countPaths(int i , int j ,int m , int n,int [][] dp)
    {
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        if(i>=m || j>= n)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
        else return dp[i][j] = countPaths(i+1 , j , m , n , dp) + countPaths(i , j+1 , m , n , dp);
  
    }

    private static int bruteForce(int i , int j ,int m , int n)
    {
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        if(i>=m || j>=n)
        {
            return 0;
        }
        return bruteForce(i+1,j,m,n) + bruteForce(i,j+1,m,n) ;
    }

    public static void main(String[] args) {

        int rows = 3;
        int cols = 7;

        int ans = uniquePaths2(rows,cols);

        System.out.println();
        System.out.printf("Input: rows = %d and cols = %d \n",rows,cols);
        System.out.println("Output: "+ ans);

    }
}