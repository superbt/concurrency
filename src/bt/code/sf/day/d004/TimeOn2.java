package bt.code.sf.day.d004;

/***
 * 这里用冒泡排序来实现O（n^2）的时间复杂度模拟
 */
public class TimeOn2 {

    public static void main(String[] args) {
        int[] numbers = {64,34,25,12,22,11,90};
        bubbleSort(numbers);
        //输出排序后的数值
        for (int value: numbers
             ) {
            System.out.print(value+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length ;
        boolean swappped;
        for(int i=0 ;i<n-1;i++){
            swappped = false ;
            for (int j=0 ;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                    swappped = true;
                }
            }
            if(!swappped){
                break;
            }
        }
    }
}
