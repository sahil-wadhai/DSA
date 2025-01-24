package multiThreading;
/*
MultiThreading vs MultiTasking
https://www.geeksforgeeks.org/difference-between-multi-tasking-and-multi-threading/
*/

/*
 java supports multi-threading through its:
 - java.lang.Thread class 
 - java.lang.Runnable interface

*/

public class WithoutMultiThreading {
    public static void main(String[] args) {
        // name of thread running main method
        System.out.println(Thread.currentThread().getName());

        long startTime = System.currentTimeMillis();
        long sum = 0;
        for(long i=0; i<1000000000L; i++){
            sum += i;
        }
        System.out.println(sum);

        long endWith7 = 0; 
        for(long i=0; i<1000000000L; i++){
            if(i%10 == 7){
                endWith7++;
            }
        }
        System.out.println(endWith7);

        System.out.println("Time taken : "+ (System.currentTimeMillis()-startTime) + "ms.");
    }
}
