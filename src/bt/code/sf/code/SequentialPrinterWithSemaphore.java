package bt.code.sf.code;

import java.util.concurrent.Semaphore;

public class SequentialPrinterWithSemaphore {

    private  static  final Semaphore oddSemaphore = new Semaphore(1);
    private  static  final Semaphore evenSemaphore = new Semaphore(0);

    private static  int number = 1 ;
    private static  final  int MAX_NUMBER = 100 ;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddPrinter());
        Thread evenThread = new Thread(new EvenPrinter());
        oddThread.start();
        evenThread.start();
    }

    static  class  OddPrinter implements Runnable{

        @Override
        public void run() {
            while (number<MAX_NUMBER){
                try{
                 oddSemaphore.acquire();
                 if(number%2==0){
                     oddSemaphore.release();
                 }else {
                     System.out.println(String.format("这是奇数%s",number));
                     number++ ;
                     evenSemaphore.release();
                 }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    static  class  EvenPrinter implements Runnable{

        @Override
        public void run() {
            while (number<MAX_NUMBER){
                try{
                    evenSemaphore.acquire();
                    if(number%2==1){
                        evenSemaphore.release();
                    }else {
                        System.out.println(String.format("这是偶数%s",number));
                        number++ ;
                        oddSemaphore.release();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
