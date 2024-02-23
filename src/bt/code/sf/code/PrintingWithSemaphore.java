package bt.code.sf.code;

import java.util.concurrent.Semaphore;

public class PrintingWithSemaphore {

    private  static final Semaphore semaphoreNumber = new Semaphore(1);
    private static  final Semaphore semaphoreletter = new Semaphore(0);

    public static void main(String[] args) {

        Thread numberThread = new Thread(new NumberPrinter());
        Thread letterTread = new Thread(new LerrerPrinter());

        numberThread.start();
        letterTread.start();
    }

    static  class  NumberPrinter implements  Runnable{

        @Override
        public void run() {
            try{

                for (int i = 0; i <=3 ; i++) {
                    semaphoreNumber.acquire();
                    System.out.println(i);
                    semaphoreletter.release();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static  class LerrerPrinter implements Runnable{
        @Override
        public void run() {
            try{
              for(char c ='A' ;c<='C';c++){
                  semaphoreletter.acquire();
                  System.out.println(c);
                  semaphoreNumber.release();
              }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
