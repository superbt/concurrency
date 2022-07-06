package bt.longthread.sub;

import bt.longthread.LongThread;

public class Thread1 extends LongThread {
    @Override
    public void excute() {
        System.out.println("im running");
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
