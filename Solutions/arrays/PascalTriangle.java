//reference: https://www.geeksforgeeks.org/pascal-triangle/

import java.util.*;
public class PascalTriangle {
    /*
        Brute Force : 
        - Calculate value at each (i,j) possition , using nCr relation
        - In pascals triangle value at (i,j) = (i-1)C(j-1)

        optimized : use count array or map <=

    */
    static ArrayList<ArrayList<Long>> pascalTriangle(int n) {
        
        ArrayList<ArrayList<Long>> triangle = new ArrayList<>();
        
        for(int i = 0; i<n ; i++)
        {
            triangle.add(new ArrayList<>());
            for(int j = 0; j<=i ; j++)
            {
                if(j==0 || i==j)
                {
                    triangle.get(i).add(1l);
                }
                else
                {
                    long num = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                    triangle.get(i).add(num);
                }
            }
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(pascalTriangle(5));
    }
}
