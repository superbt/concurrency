package bt.code.sf.day.d004;

public class TimeOn {

    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        int sum = calculateSum(numbers);
        System.out.println("this sum of elements is"+sum);
    }

    public static int calculateSum(int[] arr){
        int total = 0 ;
        for (int i = 0; i < arr.length; i++) {
            total = total+arr[i];
        }
        return  total ;
    }
}
