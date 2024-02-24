package bt.code.sf.code;

import java.util.ArrayList;
import java.util.List;

public class MyOOMTest {

}

class HeapOverFlow{
    public static void run(String[] args) {
        List<Object> objects = new ArrayList<>();
        while (true){
            objects.add(new Object());
        }
    }
}

class  StackOverFlow{
    public static  void run ( int i){
        run(i);
    }
}

class MetaSpaceOverflow{
    //javassist动态库来实现
}
