package multiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLockDemo {
    public static void main(String[] args) {
        Account account = new Account(10000);
        System.out.println(account.getBalance());

        Runnable task = new Runnable() {
            @Override
            public void run(){
                System.out.println("Thread started running : "+Thread.currentThread().getName());
                account.withdraw(5000);
            }
        };

        Thread thread1 = new Thread(task,"Thread1");
        Thread thread2 = new Thread(task,"Thread2");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(Exception e){
            System.out.println("Something went wrong!");
        }
        System.out.println(account.getBalance());
    }
}

class Account{
    private int balance;
    private final Lock lock = new ReentrantLock(true); //Fairness only applies to lock(), not necessarily to tryLock().

    public Account(int balance){
        this.balance = balance;
    }

    public synchronized int getBalance(){
        return this.balance;
    }

    public void withdraw(int amount){
        try{
            //If resource is locked, thread will wait for 100 ms (1 sec) to gain lock
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(amount<=balance){
                    try{
                        System.out.println(Thread.currentThread().getName()+" : started withdrawl");
                        Thread.sleep(3000); //Simulating withdrawl time
                        balance -= amount;
                    }catch(InterruptedException e){
                        System.out.println("Withdraw interrupted");
                        Thread.currentThread().interrupt();
                    }
                    catch(Exception e){
                        System.out.println(e+" : Error while withdrawing..");
                    }finally{
                        lock.unlock();
                    }
                    
                }else{
                    System.out.println("Insufficient balance");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" : Failed to gain lock access");
            }
        }catch(InterruptedException e){
            System.out.println("Session interrupted");
            Thread.currentThread().interrupt();
        }
        
    }

}
