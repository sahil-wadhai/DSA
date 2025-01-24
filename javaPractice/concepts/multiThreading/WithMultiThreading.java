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

public class WithMultiThreading {
    public static void main(String[] args) {
        // name of thread running main method
        System.out.println(Thread.currentThread().getName());

        long startTime = System.currentTimeMillis();
        
        //Creating thread1
        SumCalculator thread1 = new SumCalculator();

        //creating thread2
        NumberCounter numberCounter = new NumberCounter();
        Thread thread2 = new Thread(numberCounter);

        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.out.println("Some error : "+e);
        }

        System.out.println("Time taken : "+ (System.currentTimeMillis()-startTime) + "ms.");
    }
}

//Thread created by extending Thread class
class SumCalculator extends Thread{
    @Override
    public void run(){
        long sum = 0;
        for(long i=0; i<1000000000L; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}

//Thread created by implementing Runnable interface
class NumberCounter implements Runnable{
    @Override
    public void run(){
        long endWith7 = 0; 
        for(long i=0; i<1000000000L; i++){
            if(i%10 == 7){
                endWith7++;
            }
        }
        System.out.println(endWith7);
    }
}
