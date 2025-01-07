import java.util.Arrays;

/* String methods

 name : Sahil-Wadhai

 name.length() : 12

 name.charAt(1) : a

 name.conatins("Wadhai") : true

 name.split("-") returns array : [Sahil, Wadhai]

 name.toCharArray() returns char array : [S, a, h, i, l, -, W, a, d, h, a, i]

 name.substring(1, 5) : ahil

 name.toUpperCase() : SAHIL-WADHAI

 name.toLowerCase() : sahil-wadhai

 name.startsWith("Sahil") : true

 name.endsWith("Sahil") : false

*/

/* StringBuffer (Mutable String)
- StringBuffer objects are mutable, meaning that you can change the contents of the buffer without creating a new object.
- The initial capacity of a StringBuffer can be specified when it is created, or it can be set later with the ensureCapacity(int) method.
- The append(String) method is used to add characters, strings, or other objects to the end of the buffer.
- The insert(int, String) method is used to insert characters, strings, or other objects at a specified position in the buffer.
- setCharAt(int index, char ch) the character at the specified index is set to ch.
- The replace(int,int,String) method replaces the given string from the specified beginIndex and endIndex-1.
- The delete(int,int) method is used to remove characters from the buffer.
- The deleteCharAt(int) method is used to remove characters from the buffer.
- The reverse() method is used to reverse the order of the characters in the buffer.
- charAt(int)
- length()
- substring(int,int)
*/

public class StringDemo {

    public static void main(String [] args){
        String name = "Sahil-Wadhai";
        System.out.println(" name : "+name);
        System.out.println();
        System.out.println(" name.length() : " + name.length() ); 
        System.out.println();
        System.out.println( " name.charAt(1) : " + name.charAt(1)); 
        System.out.println();
        System.out.println( " name.conatins(\"Wadhai\") : " + name.contains("Wadhai")); 
        System.out.println();
        System.out.println(" name.split(\"-\") returns array : " + Arrays.toString(name.split("-") )); 
        System.out.println();
        System.out.println(" name.toCharArray() returns char array : " + Arrays.toString(name.toCharArray())); 
        System.out.println();
        System.out.println(" name.substring(1, 5) : " + name.substring(1, 5)); 
        System.out.println();
        System.out.println(" name.toUpperCase() : " + name.toUpperCase()); 
        System.out.println();
        System.out.println( " name.toLowerCase() : " + name.toLowerCase()); 
        System.out.println();
        System.out.println( " name.startsWith(\"Sahil\") : " + name.startsWith("Sahil")); 
        System.out.println( " name.endsWith(\"Sahil\") : " + name.endsWith("Sahil")); 

        StringBuffer sb = new StringBuffer("xyzAbc");
        System.out.println(" sb : "+sb);
        String s = sb.toString();
        System.out.println(" s : "+s);

    }
    
}
