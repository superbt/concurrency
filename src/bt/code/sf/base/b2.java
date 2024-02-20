package bt.code.sf.base;

public class b2 {
    public static void main(String[] args) {
        QueueByLink queueByLink = new QueueByLink();

        for (int i = 0; i <10 ; i++) {
            queueByLink.offer(i);
        }

        for (int i = 0; i <10 ; i++) {
            System.out.println(String.format("3获取到的数据%s",queueByLink.poll()));
        }
    }

}

class QueueByLink{

    Node front ;
    Node tail ;
    int size ;

    public void offer(int date){
        Node temp = new Node(date);
        if(isEmpty()){
            front = temp ;
            tail = front ;
        }else{
            tail.next = temp ;
            tail = temp ;
        }
        size++ ;
    }

    public int poll(){
        if(isEmpty()){
            return  0 ;
        }
        int date = front.date;
        front = front.next ;
        size-- ;
        return date ;
    }

    public boolean isEmpty(){
        return  size == 0 ;
    }
    private static class Node{
        public int date ;
        public Node next ;

        public Node(int date){
            this.date = date ;
        }
    }
}
