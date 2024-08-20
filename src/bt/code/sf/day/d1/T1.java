package bt.code.sf.day.d1;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class T1 {

    public static volatile int  dayAllYufuCountMax =  0 ;
    public static volatile int  dayAllYufuCountMin =  0 ;
    public static void main(String[] args) {

        //并发考虑
        //这边有一个场景 有一个池子中有一千条鱼
        //有10个渔夫在大佬，每个渔夫的能力是有限的
        //问，大约几天可以打捞完

        List<T1_1> list = bulidYufuPool() ;
        System.out.println( list.size());

        list.stream().forEach(t11 -> {
            System.out.println(t11.toString() );});

        T1 t = new T1() ;
        t.m1(list);

    }


    //构筑10个 渔夫奥
    public static List<T1_1> bulidYufuPool () {
        List<T1_1> pool = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            //最大 捕鱼量
            //最小捕鱼量
            //补了多少条
            //渔夫的名字
            T1_1 t = new T1_1(String.format("渔夫_[%d]",i));
            //参加捕鱼测试 鉴定他的捕鱼能力
            buYuCes(t);
            pool.add(t);

        }
        return  pool ;
    }

    public static T1_1 buYuCes(T1_1 t1){


        while (t1.getMinGet()==null||t1.getMaxGet()==null){
            Random r = new Random() ;
            Integer imax = r.nextInt(10);
            Integer imin = r.nextInt(10);
            if(imax>=imin){
                t1.setMaxGet(imax);
                t1.setMinGet(imin);
                return  t1 ;
            }
        }
        if(t1.getMaxGet()==null||t1.getMinGet()==null){
            System.out.println(String.format("%s****waring***测试异常",t1.getName()));
        }
        return  t1 ;
    }

    //简单 实现1
    public void m1(List<T1_1> yufus) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        //一天最多抓多少条鱼

        yufus.stream().forEach( t11 -> {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    dayAllYufuCountMax = dayAllYufuCountMax + t11.getMaxGet() ;
                    dayAllYufuCountMin = dayAllYufuCountMin + t11.getMinGet() ;
                }
            });
        });

        System.out.println(String.format("一天最多捕捉%d,最少%d",dayAllYufuCountMax,dayAllYufuCountMin));

    }

}

class T1_1{

     Integer maxGet ;

     Integer minGet ;
     Integer count ;
     String name ;


    public T1_1(String name) {
        this.name = name;
    }

    public T1_1() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxGet() {
        return maxGet;
    }

    public void setMaxGet(Integer maxGet) {
        this.maxGet = maxGet;
    }

    public Integer getMinGet() {
        return minGet;
    }

    public void setMinGet(Integer minGet) {
        this.minGet = minGet;
    }

    @Override
    public String toString() {
        return "T1_1{" +
                "maxGet=" + maxGet +
                ", minGet=" + minGet +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
