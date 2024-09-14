package bt.code.sf.day.d004;

import java.util.Arrays;

public class TimeOnnnn {


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr,0);
    }
    //生成数组arr从索引start开始的所有排序
    public static void permute(int[] arr ,int strat){
      if(strat==arr.length){
          System.out.println(Arrays.toString(arr));
      }else{
          for(int i=strat ;i<arr.length;i++){
              swap(arr,strat,i);//交换元素
              permute(arr,strat+1);//递归调用
              swap(arr,strat,i);//回溯，恢复原来的状态
          }
      }
    }

    //交换数组arr中索引1和j处的元素
    private static void swap(int [] arr,int i,int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp ;
    }
}
