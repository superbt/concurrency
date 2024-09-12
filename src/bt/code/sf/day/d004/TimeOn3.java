package bt.code.sf.day.d004;

public class TimeOn3 {

    public static void main(String[] args) {
        int n = 4 ;
        int[][][] threeDArray = new int [n][n][n];
        initizalzeTreeDArray(threeDArray,n);
        int sum = calculateSum(threeDArray);
        System.out.println("sum:"+sum);
    }

    //构建三维数组
    public static void initizalzeTreeDArray(int[][][] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[i][j][k]= (1+i)*(1+j)*(1+k);
                }
            }
        }
    }
    //三维数组所有元素的总和
    public static int calculateSum(int[][][] arr){
        int sum = 0  ;
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                for(int k=0;k<arr[i][j].length;k++){
                    sum = sum+arr[i][j][k];
                }
            }
        }
        return  sum ;
    }
}
