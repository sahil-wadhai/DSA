public class NegativeInBinary {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num + " => " + Integer.toBinaryString(num));

        int negativeNum = (~num)+1;
        System.out.println(negativeNum + " => " + Integer.toBinaryString(negativeNum));
        /* Note :

            'first bit' from left side is a 'reserved bit' (MSB -> most significant bit)
            this bit 'indicates' whether the number is 'possitive or negative'
            '0' => indicates number is possitive
            '1' => indicates number is negative

            2's Complement Method to find negative of a Number:

            step 1) Complement the number
            step 2) then add it with 1 i.e, (~num)+1

            =>imp point:
            if num = a1b ,here 1 is the right most set bit (first set bit from right side)
            then -num = (~a)1b , bits after  right most set bit is complemented

            num & (-num) => gives a number with only right most set bit of num     
        */
    }
}
