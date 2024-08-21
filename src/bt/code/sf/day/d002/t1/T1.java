package bt.code.sf.day.d002.t1;

/**
 * 并发的多重实现
 */
public class T1 {

   public volatile static Integer count = 0 ;
    public T1() {
    }

    public static void main(String[] args) {


        for (int i = 0; i <10 ; i++) {
            T1_1 t1 = new T1_1(String.valueOf(i),count);
            t1.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("last cout %d",count));
    }

}


//继承Thread

class  T1_1 extends Thread {

    String myName ;
    Integer count ;

    public T1_1 (String myName ,Integer count){
        this.myName = myName ;
        this.count = count ;

    }

    @Override
    public void run() {
        excute1(this.myName,this.count);
        //this.count = this.count+1 ;
    }

    public void excute1(String name , Integer count){
        //System.out.println(String.format("before_go_%s,%d",name ,count));
        count = count+1 ;
        System.out.println(String.format("after_go_%s,%d",name ,count));

    }

}

//是实现 runnable
//实现callaable



class DemoT1{
    String  name ;
    Integer count ;
}
