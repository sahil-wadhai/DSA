package JavaPractice.concepts;
import java.time.LocalDate; // import the LocalDate class

// 1 byte = 8 bits
// Primitive Data Type: such as boolean, char, int, short, byte, long, float, and double
// Non-Primitive Data Type or Object Data type: such as String, Array, etc.
// Formatted Output : %[flags][width][.precision]conversion, example : %,3.2f

public class DataypesDemo {
    public static void main(String[] args) {

        //byte myNumB = 100;         // Integer (1 Byte)
        //short myNumS = 5000;       // Integer (2 Byte)
        int myNum = 50000;               // Integer (4 Byte)
        //long myNumL = 15000000000L; // Integer (8 Byte)
        float myFloatNum = 5.9234f;    // Floating point number (4 Byte 6-7 decimal digit)
        //double myFloatNumD = 5.99d; // Floating point number (8 Byte upto 15 decimal digit)
        char myLetter = 'D';         // Character (2 Byte)
        boolean myBool = true;       // Boolean (1 Byte)
        String myText = "Hello";     // String (Sequence of char)
        LocalDate myObj = LocalDate.now(); // example : 2024-09-26
    

        System.out.println(myNum); //50000
        System.out.printf("%,d \n",myNum); //50,000
        System.out.println(myFloatNum);
        System.out.printf("%5.2f \n",myFloatNum); 
        System.out.println(myBool);
        System.out.println(myLetter);
        System.out.println(myText);
        System.out.println(myObj);

        // String Formatting
        String myStr = "Hello %s! One kilobyte is %,d bytes.";
        String result = String.format(myStr, "World", 1024);
        System.out.println(result);
    }
}
