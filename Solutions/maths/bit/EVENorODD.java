public class EVENorODD {
    public static void main(String[] args) {
        int num = 46;
        isEvenOrOdd(num);
    }
    static void isEvenOrOdd(int num)
    {
        //num & 1 gives last bit of num.
        //last bit == 0 then number is even 
        //last bit == 1 then number is odd
        if((num & 1) == 0) //even 
        {
            System.out.println("Even");
        }
        else
        {
            System.out.println("Odd");
        }
    }
}
