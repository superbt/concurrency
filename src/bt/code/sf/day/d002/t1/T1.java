package bt.code.sf.day.d002.t1;

/**
 * 并发的多重实现
 */
public class T1 {

   public volatile static Integer count = 0 ;
    public T1() {
    }

    public static void main(String[] args) {

         DemoT1 demoT1 = new DemoT1();
        demoT1.setCount(0);
        for (int i = 0; i <10 ; i++) {
            demoT1.setName(String.valueOf(i));
             T1_1 t1 = new T1_1(demoT1);
            t1.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("last cout %d",demoT1.getCount()));
    }

}


//继承Thread
//用这个方法 很简单的实现了，但是中间遇到一个问题，就是Intger或者int 类型的作为成员变量传入参数引用不被使用，
//必须要通过创建对象，并作为对象中的一个成员变量才会被引用，这个问题确实很有趣。
class  T1_1 extends Thread {

    String myName ;
    Integer count ;

    DemoT1 demoT1;

    public T1_1 (String myName ,Integer count){
        this.myName = myName ;
        this.count = count ;

    }

    public T1_1(DemoT1 demoT1){
        this.demoT1 = demoT1 ;
    }

    @Override
    public void run() {
        //excute1(this.demoT1.getName() ,this.demoT1.getCount());
        excute2(demoT1);
        //this.count = this.count+1 ;
    }

    public void excute1(String name , Integer count){
        //System.out.println(String.format("before_go_%s,%d",name ,count));
        count = count+1 ;
        System.out.println(String.format("after_go_%s,%d",name ,count));

    }

    public void excute2(DemoT1 demoT1){
        //System.out.println(String.format("before_go_%s,%d",name ,count));
       int count = demoT1.getCount() + 1 ;
       demoT1.setCount(count);
        System.out.println(String.format("after_go_%s,%d",demoT1.getName() ,demoT1.getCount()));

    }

}

//是实现 runnable
//实现callaable



class DemoT1{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    String  name ;
    Integer count ;
}
