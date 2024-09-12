package bt.code.sf.day.d004;

public class TimeO1 {

    public static void main(String[] args) {
        int []  numbers = {1,2,3,4,5,6,7,8,9,10};
        int elment = getElment(numbers,1);
        System.out.println("this element is "+elment);
    }

    public static int getElment(int [] arr,int index){
        if(arr==null||index<0||index>arr.length){
            throw  new IllegalArgumentException("错误的输入数据");
        }
        return  arr[index];
    }
}
