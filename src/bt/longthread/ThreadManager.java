package bt.longthread;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadManager  extends ConcurrentHashMap<String,Thread> {

    public static ThreadManager threadManager = new ThreadManager() ;

    private  ThreadManager(){

    }

    @Override
    public Thread put(String key, Thread value) {
        return super.put(key, value);
    }

}
