package bt.code.sf.base;

public class b1 {

/*    public static void main(String[] args) {
        StackByArray stackByArray = new StackByArray(10);

        //放入数据
        for(int i= 0;i<10;i++){
            stackByArray.push(i);
        }
        //取数据
        for (int i = 0; i <10 ; i++) {
            int pop = stackByArray.pop();
            System.out.println("获取到的数据："+pop);
        }
    }*/

    public static void main(String[] args) {
        StackByLink stackByLink = new StackByLink();

        for (int i = 0; i <10 ; i++) {
            stackByLink.push(i);
        }

        for (int i = 0; i <10 ; i++) {
            System.out.println(String.format("2获取到的数据%s",stackByLink.pop()));
        }
    }
}

class StackByArray{
    private int top = -1 ;
    private int maxSize ;
    private int[] stack ;

 public StackByArray(int maxSize){
     this.maxSize = maxSize ;
     stack = new int[maxSize];
 }

 public boolean isFull(){
     return  top == maxSize -1 ;
 }
 public boolean isEmpty(){
     return  top==-1 ;
 }

 public void push(int date){
     if(isFull()){
         return;
     }
     stack[++top] = date ;
 }
 public int pop (){
     if(isEmpty()){
         throw  new RuntimeException("this stack is empty");
     }
     int date = stack[top--];
     return  date ;
 }

}

class StackByLink{

    private Node head ;

    public void push(int date){
        Node temp = new Node(date);
        if(head!=null){
            temp.next = head;
        }
        head = temp ;
    }

    public int pop(){
        if(head ==null){
            return  0 ;
        }
        int ans = head.date ;
        head = head.next ;
        return  ans ;
    }

    private static class Node{
        public int date ;
        public Node next ;

        public Node(int date){
            this.date = date ;
        }
    }

}
