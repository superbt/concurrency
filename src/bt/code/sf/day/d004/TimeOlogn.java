package bt.code.sf.day.d004;

public class TimeOlogn {

    public static void main(String[] args) {
        int [] sortedArray = {1,2,3,4,5,6,7,8,9,10};

        int taget =  7 ;

        int resurt = binarySeatch(sortedArray,taget);

        if(resurt!=-1){
            System.out.println("获取到数据，数据的位置为："+resurt);
        }else{
            System.out.println("数组中没有需要的数据");
        }
    }


    public static int binarySeatch(int []arr ,int target){
        int left = 0;
        int right = arr.length -1 ;
         while(left<=right){
             int mid = left +(right-left)/2 ;
             //检查中间位置的元素是否等于自标值
              if(arr[mid] == target){
                 return  mid ;
             }
             //如果目标值大于中间位置的元素，则在右半部分查找
             if(arr[mid]<target){
                 left = mid+1 ;
             }else{ //否则，在左半部分查找
                 right = mid - 1 ;
             }
         }
         return  -1;
    }
}
