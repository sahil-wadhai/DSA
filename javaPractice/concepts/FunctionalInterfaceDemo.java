/* 
 - Functional interface are the interface with only one function which is needed to be override
 - lambda expression represent instances of functional interfaces (interfaces with a single abstract method). 
    They provide a concise way to express instances of single-method interfaces using a block of code.
    lambda expression :
    (arguments) -> { body };

*/
@FunctionalInterface
interface A{
    void show();
}

@FunctionalInterface
interface B{
    int len(String s);
}

public class FunctionalInterfaceDemo{
    public static void main(String [] args){
        A obj1 = new A(){
            public void show(){
                System.out.println("Ok....");
            }
        };
        obj1.show();
        
        A obj2 = () -> {
            System.out.println("ok with lambda expression...");
        };
    // A obj2 = () -> System.out.println("ok with lambda expression...");
        obj2.show();
        
        
        B obj11 = new B(){
            public int len(String s){
                return s.length();
            }
        };
        int l = obj11.len("Sahil");
        System.out.println(l);
        
        //B obj22 = (s) -> { return s.length();};
        B obj22 = (s) -> s.length();
        l = obj22.len("SahilWadhai");
        System.out.println(l);
    }
}

/*

Java SE 8 included four main kinds of functional interfaces 
which can be applied in multiple situations as mentioned below:

1) Consumer:
Accepts only one argument or a gentrified argument and returns nothing
Consumer<Integer> consumer = (value) -> System.out.println(value);

2) Predicate:
A function that accepts an argument and
In return, generates a boolean value as an answer is known as a predicate.
Predicate predicate = (value) -> value != null;

3) Function :
Takes argument and returns something.
Function function = (s) -> s.length();

4) Supplier :
Does not take any input or argument and yet returns a single output.
Supplier consumer = () -> value ;
*/