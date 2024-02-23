package bt.code.sf.code;

public class PrintingWithYeild {

    private static  volatile boolean printNumber = true ;

    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberPrinter());
        Thread letterThread = new Thread( new letterPrinter());
    }

    static class  NumberPrinter implements  Runnable{

        @Override
        public void run() {
            for (int i=1;i<=3;i++){
                while (!printNumber){
                    Thread.yield();
                }
                System.out.println(i);
                printNumber = false ;
                Thread.yield();
            }
        }
    }

    static class  letterPrinter implements  Runnable{

        @Override
        public void run() {
            for(char c ='A' ;c<='C';c++){
                while (printNumber){
                    Thread.yield();
                }
                System.out.println(c);
                printNumber = true ;
                Thread.yield();
            }
        }
    }
}
