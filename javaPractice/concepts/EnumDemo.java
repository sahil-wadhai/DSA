enum Operation{
    //instances
    ADD,SUBTRACT,MULTIPLY,DIVIDE;

    public <T extends Number> double apply(T a, T b){
        //this refers to instance
        switch(this){
            case ADD:
                return a.doubleValue()+b.doubleValue();
            case SUBTRACT:
                return a.doubleValue()-b.doubleValue();
            case MULTIPLY:
                return a.doubleValue()*b.doubleValue();
            case DIVIDE:
                return a.doubleValue()/b.doubleValue();
            default:
                throw new AssertionError("Unknown Operation : "+this);
        }
    }
}

public class EnumDemo {
    
    public static void main(String[] args) {
        for(Operation e : Operation.values()){
            System.out.println(e);
        }

        double res1 = Operation.ADD.apply(30,10);
        double res2 = Operation.SUBTRACT.apply(30,10);
        double res3 = Operation.MULTIPLY.apply(30,10);
        double res4 = Operation.DIVIDE.apply(30,10);

        System.out.println(res1 + " " + res2 + " " + res3 + " " + res4);
    }
}

/*
Here’s a short and crisp summary of the important points about 'enums' in Java:

1. Definition: Enums are special types of classes that represent a fixed set of constants.
   
2. Instantiation: Enum constants are created **implicitly when the enum class is loaded 
and are singletons (one instance per constant).
   
3. Enum Class Loading: Enums are **lazily loaded** when first accessed 
(class is loaded when the first constant is accessed or a method is called).
   
4. Constructor: Enum constants are initialized via the **private constructor** of the enum class.
   
5. Methods: Enums can have methods, fields, and constructors. Methods can be called on enum constants.
   
6. Switch-Case: Enums are commonly used with `switch` statements or `if-else` for operation handling.
   
7. Singleton: Each enum constant is a unique, **static final** instance, ensuring no duplicate instances exist.
   
8. Caching: Enum constants are cached in an internal array and are accessed via `values()`.
   
9. Type Safety: Enums provide type safety, preventing invalid values from being assigned.
   
10. No Garbage Collection: Enums are **not eligible for garbage collection** because they are static fields.

### Key Methods:
- values(): Returns an array of all enum constants.
- valueOf(String name): Returns the enum constant with the specified name.

### Use Cases:
- Enum constants are often used in cases like operations (ADD, SUBTRACT), states (START, STOP), days of the week, etc.
*/