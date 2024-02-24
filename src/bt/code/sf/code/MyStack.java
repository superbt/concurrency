package bt.code.sf.code;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack <T>{

    private Queue<T> queue ;
    private Queue<T> tempQueue ;


    public MyStack(){
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(T e){
        queue.offer(e);
    }

    public T pop(T e){
      if(isEmpty()){
          throw  new RuntimeException("queue is empty") ;
      }
      while (queue.size()>1){
          tempQueue.offer(queue.poll());
      }
      T element = queue.poll();
      Queue<T> temp = queue ;
      queue = tempQueue ;
      tempQueue = temp;
      return  element;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while (queue.size()>1){
            tempQueue.offer(queue.poll());
        }
        T element = queue.poll() ;
        tempQueue.offer(element);
        Queue<T> temp = queue ;
        queue = tempQueue ;
        tempQueue = temp ;
        return element ;
    }
    public boolean isEmpty(){
        return  queue.isEmpty();
    }
}
