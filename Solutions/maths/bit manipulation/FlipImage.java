/*
    Given an n x n binary matrix image, flip the image horizontally, 
    then invert it, and return the resulting image.

    To flip an image horizontally means that each row of the image is reversed.

    For example, flipping [1,1,0] horizontally results in [0,1,1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

    For example, inverting [0,1,1] results in [1,0,0].
*/
import java.util.Arrays;

public class FlipImage {
    public static void main(String[] args) {
        int [][] image = {
                          {1,1,0},
                          {1,0,1},
                          {0,0,0}
                         };
        System.out.println("Image : ");
        for (int [] row:image)
        {
            System.out.println(Arrays.toString(row));
        }

        flipAndInvertImage( image );

        System.out.println("\nFlipped & Inverted Image : ");
        for (int [] row:image)
        {
            System.out.println(Arrays.toString(row));
        }
    }
    static void flipAndInvertImage(int[][] image) 
    {  
        for(int [] row : image)
        {
            int start = 0;
            int end = row.length-1;
            while(start<=end)
            {
                int temp = row[start];
                row[start] = 1 ^ row[end] ; //flipping while inverting
                row[end] = 1 ^ temp; //flipping while inverting
                start++;
                end--;
            }
        }
        
    }
}
