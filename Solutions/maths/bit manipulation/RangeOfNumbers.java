/*
    Find Range of numbers which can be stored in given number of 'bytes'
*/
import java.util.Arrays;

public class RangeOfNumbers {
    public static void main(String[] args) {
        int nByte = 4 ; //1 Byte = 8 bits , long takes 8 Bytes
        // to find range of long
        long [] range = new long [2];
        range = findRange(nByte);
        System.out.println(Arrays.toString(range));

        long temp = range[1];
        System.out.println(temp + " + 1 => " + temp+1 + " wrong,value out of bound");
    }
    static long [] findRange(int nByte)
    {
        long [] range = new long[2];
        int nBits = (8*nByte) - 1; // 1 Byte = 8 bits , MSB is reserved that's why -1

        range[0] = 0 - (1 << nBits); // to find power of 2 in negative side

        //to find power of 2 in possitive side , 
        //also 0 is also counted as possitive in binary , that's why -1 to exclude 0
        range[1] = (1 << nBits) -1 ;  
        
        return range;
    }
}
