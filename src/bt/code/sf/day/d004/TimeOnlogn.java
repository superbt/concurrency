package bt.code.sf.day.d004;


/***
 * 这个有大问题哟！！！
 */
public class TimeOnlogn {


    public static void main(String[] args) {

        int [] numbers = {12,11,13,5,6,7};
       // int [] numbers = {12,13};

        mergeSort(numbers,0,numbers.length-1);
        System.out.println("Sorted array:");
        printArray(numbers);
    }
    //归并排序算法实现
    public static void mergeSort(int [] arr ,int l,int r){

        if(l<r){
            int m = (l+r)/2 ;
            //对左侧子数组进行排序
            mergeSort(arr,l,m);
            //对右侧数组进行排序
            mergeSort(arr,m+1,r);
            //合并两个已排序的子数组
            merge(arr,l,m,r);
        }
    }

    // 合并两个已经排序的子数组
    private static void merge(int []arr ,int l ,int m ,int r){

        //求出两个子数组的长度
        int n1 =m-l+1 ;
        int n2 = r-m ;

        //创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        //复制数据到临时数组
        for(int i=0;i<n1;++i){
            L[i] = arr[l+i];
        }
        for(int j=0;j<n2;++j){
            R[j] = arr[m+1+j];
        }

        //合并临时数组回到原数组
        int i=0,j=0;
        int k = 1;
        while (i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        //复制左侧数据剩余元素
        while (i<n1 && k <arr.length){
            arr[k]=L[i];
            i++ ;
            k++;
        }

        while(j<n2 && k<arr.length){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    //打印数组
    private static  void printArray(int[] arr){
        for (int value:arr){
            System.out.println(value+" ");
        }
        System.out.println("");
    }
}
