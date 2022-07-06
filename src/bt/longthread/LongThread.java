package bt.longthread;

import java.util.concurrent.locks.ReentrantLock;

public abstract class LongThread implements Runnable {

    public static volatile  boolean status = true ;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (status){
            excute();
        }

    }

   public abstract void excute() ;

    public  boolean startLong(){
        lock.lock();
        status = true ;
        lock.unlock();
        return status ;
    }

    public boolean stopLong(){
        lock.lock();
        status = true ;
        lock.unlock();
        return status ;
    }
}
