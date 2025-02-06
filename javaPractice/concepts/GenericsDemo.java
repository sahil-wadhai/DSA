// Define a generic interface
interface Box<T> {
    void setValue(T value);
    T getValue();
}

// Implement the generic interface in a class
class GenericBox<T> implements Box<T> {
    private T value;

    // Implementing setValue method
    @Override
    public void setValue(T value) {
        this.value = value;
    }

    // Implementing getValue method
    @Override
    public T getValue() {
        return value;
    }
}

//Generic static methods demo
class Utility {
    // Generic static method to print the elements of an array
    //You can call the generic static methods with different data types (Integer, String) 
    //and the appropriate types are inferred at runtime.
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // Generic static method to find the maximum of two elements
    public static <T extends Comparable<T>> T findMax(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    /* Method that accepts only numbers (Integer, Double, etc.)

    public static <T extends Number> void printDouble(T number) {
        System.out.println(number.doubleValue());
    }

    */
}

//T with multiple constraints Demo
// Interface 1
interface Printable {
    void print();
}

// Interface 2
interface Readable {
    void read();
}

// Class that implements both interfaces
class Document implements Printable, Readable {
    @Override
    public void print() {
        System.out.println("Printing the document...");
    }

    @Override
    public void read() {
        System.out.println("Reading the document...");
    }
}


public class GenericsDemo{

    // Method with multiple constraints on T: T extends Document and implements Printable and Readable
    public static <T extends Document & Printable & Readable> void processDocument(T document) {
        document.print();  // Calling print() from Printable
        document.read();   // Calling read() from Readable
    }
    public static void main(String[] args) {
        // Using the GenericBox with Integer type
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.setValue(10);
        System.out.println("Integer value: " + intBox.getValue());

        // Using the GenericBox with String type
        GenericBox<String> strBox = new GenericBox<>();
        strBox.setValue("Hello, Generics!");
        System.out.println("String value: " + strBox.getValue());


        //Generic Static methods
        // Example usage of the generic printArray method
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "cherry"};

        System.out.println("Integer Array:");
        Utility.printArray(intArray);

        System.out.println("\nString Array:");
        Utility.printArray(strArray);

        // Example usage of the generic findMax method
        Integer maxInt = Utility.findMax(10, 20);
        String maxStr = Utility.findMax("apple", "banana");

        System.out.println("\nMax Integer: " + maxInt);
        System.out.println("Max String: " + maxStr);

        //T with multiple Constraints demo
        Document doc = new Document();
        processDocument(doc);  // Valid: Document is of type Document, Printable, and Readable

    }
}
