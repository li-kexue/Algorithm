import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * @author likexue
 * @create 2019/11/2919:46
 **/
public class Backpack {
    static int k = 0;
    public static void main(String[] args) {
        int[][]arr ={{2,6},{2,3},{6,5},{5,4},{4,6}};
        double[] u = {0.8,0.83333,1.5,1.5,3.0};
        Arrays.sort(u);
        for (int i = 0; i < u.length; i++) {
            System.out.println(u[i]);
        }
        knapSack(arr);
      //  System.out.println(1.0*arr[0][1]/arr[3][0]);
//        int[] result =new int[arr.length];
//        int sum = f(arr,result,arr.length-1,10);
//        System.out.println(sum);
//        for (int i = 0; i <arr.length; i++) {
//            System.out.print(result[i]+" ");
//        }
    }


    public static void knapSack(int[][] arr){
        double[] uv = new double[arr.length];
        for (int i = 0; i < arr.length;i++){
            uv[i] = 1.0 * arr[i][1] / arr[i][0];
        }

//        Arrays.sort(uv);
//        for (int i = 0; i < uv.length; i++) {
//            System.out.println(uv[i]);
//        }
    }

    public static int f(int[][] arr, int[] result, int n, int sum) {
        if (n < 0){
            return 0;
        }
        if (sum == 0){
            return arr[n][1];
        }
        if (sum < 0){
            return 0;
        }
        int a = f(arr, result, n - 1, sum);
        int b = f(arr, result, n - 1, sum - arr[n][0]);
        if (a <= b) {
            result[n] = 1;
            return arr[n][1] + b;
        }else {
            return a;
        }
    }
}
