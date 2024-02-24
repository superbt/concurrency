package bt.code.sf.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequentialPrinterWithLock {

    private static  final Lock lock = new ReentrantLock();
    private  static  final Condition oddCondition = lock.newCondition();
    private  static  final Condition evenCondition = lock.newCondition();
    private static  int number = 1 ;
    private static final  int MAX_NUMBER = 100 ;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddPrinter());
        Thread evenThread = new Thread(new EvenPrinter());
        oddThread.start();
        evenThread.start();
    }

    static  class  OddPrinter implements  Runnable{

        @Override
        public void run() {
            while (number<MAX_NUMBER){
                lock.lock();
                try{
                    if(number%2==0){
                        oddCondition.await();
                    }else{
                        System.out.println(number);
                        number++ ;
                        evenCondition.signal();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static  class  EvenPrinter implements  Runnable{

        @Override
        public void run() {
            while (number<MAX_NUMBER){
                lock.lock();
                try{
                    if(number%2!=0){
                        evenCondition.await();
                    }else{
                        System.out.println(number);
                        number++ ;
                        oddCondition.signal();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
