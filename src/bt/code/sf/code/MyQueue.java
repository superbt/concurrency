package bt.code.sf.code;

import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> stackIn ;
    private Stack<T> stackOut ;

    public MyQueue(){
        stackIn = new Stack<>() ;
        stackOut = new Stack<>() ;
    }

    public void enquenue(T element){
        stackIn.push(element);
    }

    public T dequeneue(){
       if(stackOut.isEmpty()){
           while (!stackIn.isEmpty()){
               stackOut.push(stackIn.pop());
           }
       }
       return  stackOut.pop();
    }

    public boolean isEmpty(){
        return stackIn.isEmpty()&& stackOut.isEmpty();
    }
}
