public class PowerOf2 {
    public static void main(String[] args) {
        int power = 2;
        int powerOf2 = 1 << (power); // to place 1 at correct possition
        System.out.println(powerOf2);
    }
    /* points:

        1) num << x
           means num * pow(2,x)
        
        2) num >> x
            means num / pow(2,x)
    */
}
