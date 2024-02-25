package bt.code.sf.code;

import java.util.Arrays;

public class MinDiff {

    public static int findMinDiff(int[] arr){
        int n = arr.length ;
        if(n<2){
            return  -1 ;
        }
        int minVal = Integer.MIN_VALUE ;
        int maxVal = Integer.MIN_VALUE ;

        for(int i=0 ;i<n ;i++){
            if(arr[i]<minVal){
                minVal = arr[i];
            }
            if(arr[i]>maxVal){
                maxVal =arr[i];
            }
        }

        int bucketWidth = 1 ;
        int bucketCount = maxVal - minVal +1 ;

        //初始化桶
        int [][] buckets = new int[bucketCount][n];
        int [] bucketSizes = new int[bucketCount];

        //将元素放到对应的桶中
        for (int i= 0;i<n ;i++){
            int index = (arr[i]-minVal)/bucketWidth ;
            buckets[index][bucketSizes[index]++] =arr[i];
        }

        //对每个桶进行排序
        for (int i=0 ;i<bucketCount;i++){
            if(bucketSizes[i]>0){
                Arrays.sort(buckets[i],0,bucketSizes[i]);
            }
        }

        //计算相邻桶的最小差值
        int minDiff = Integer.MAX_VALUE ;
        int preMax = buckets[0][0];

        for(int i=1 ;i<bucketCount;i++){
            if(bucketSizes[i]==0){
                continue;
            }
            int currMin = buckets[i][0];
            int diff = currMin - preMax ;
            if(diff < minDiff){
                minDiff = diff ;
            }
            preMax = buckets[i][bucketSizes[i]-1];
        }
        return  minDiff ;
    }
}
