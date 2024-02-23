package bt.code.sf.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintingWithReetrant {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(new PrintNumber(lock,condition));
        Thread thread2 = new Thread(new PrintLetters(lock,condition));
        thread1.start();
        thread2.start();
    }
}

class  PrintNumber implements  Runnable{

    private Lock lock ;
    private Condition condition ;

    public PrintNumber(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        for (int i = 1; i <=3 ; i++) {
            lock.lock();
            try{

                System.out.println(i);
                condition.signal();
                if(i<3){
                    condition.await();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

class PrintLetters implements  Runnable{

    private Lock lock ;
    private Condition condition ;

    public PrintLetters(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
      for(char letter = 'A' ;letter <='C' ;letter++){
          lock.lock();
          try{
              System.out.println(letter);
              condition.signal();
              if(letter<'C'){
                  condition.await();
              }
          }catch (InterruptedException e){
                   e.printStackTrace();
          }finally {
              lock.unlock();
          }

      }
    }
}
