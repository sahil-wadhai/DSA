import java.lang.Integer;
public class BasicBitOps {
    public static void main(String[] args) {
        int num = 10;
        System.out.println( num + " => "+ Integer.toBinaryString(num));

        int bitPos = 2;

        //Get Bit Operation
        int bit = getBit(num , bitPos);
        System.out.println("Bit at Pos " + bitPos + " => " + bit);

        //Set Bit Operation
        num = setBit(num , bitPos);
        System.out.println("Setted "+ bitPos + " possition Bit, new Binary String => " + Integer.toBinaryString(num) );

        //ReSet Bit Operation
        num = clearBit(num , bitPos);
        System.out.println("Cleared "+ bitPos + " possition Bit, new Binary String => " + Integer.toBinaryString(num) );

        //Update Bit Operation
        num = updateBit(num , bitPos);
        System.out.println("Updated "+ bitPos + " possition Bit, new Binary String => " + Integer.toBinaryString(num) );
    }
    static int getBit(int num , int pos)
    {
        //left shift : num << (number of shift) , lly for right shift
        //usin AND property, we can know which bit it is , by using & with 1.
        //for the possition we can use left shift,
        //to place the '1' at requirred possition
        int bitMask = 1 << (pos-1);
        if( (num & bitMask) == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    static int setBit(Integer num , int pos)
    {
        // using OR property (| any bit with 1 gives 1)
        // to place '1' at requirred possition , we use left shift
        int bitMask = 1 << (pos-1);
        num = num | bitMask ;
        return num;
    }
    static int clearBit(Integer num , int pos)
    {
        // using AND property (& any bit with 0 gives 0)
        // to place '0' at requirred possition , we use left shift on (~1)
        int bitMask = (~1) << (pos-1);
        num = num & bitMask ;
        return num;
    }
    static int updateBit(Integer num , int pos)
    {
        // using XOR property (^ any bit with 1 gives opposite of that bit)
        // to place '1' at requirred possition , we use left shift
        int bitMask = 1 << (pos-1);
        num = num ^ bitMask ;
        return num;
    }
    /*
        Note:
        => number of digits in binary = [ log(num)/log2 ]+ 1;

        [ log(num)/log2 ] it gives how many times 2 has been multiplied
        & +1 for 2 power 0..
    */
}
