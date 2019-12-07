/**
 * @author likexue
 * @create 2019/10/248:43
 **/
public class MergedOrderTable {
    public int a;
    public  MergedOrderTable point = null;

    public static void main(String[] args) {
        int[][]arr = {
                {0},
                {1, 4, 6, 8, 12},
                {1, 3},
                {3, 5, 7, 9},
                {2,5,8,14,23,45,56}
        };
        merged(arr);
    }

    public static void merged(int[][] arr){
        int n = arr.length;
        for(int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if(arr[i].length<arr[j].length){
                    int[] temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i <n;i++){
            int m = arr[i].length;
            for (int j = 0;j < m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0;i < n-1;i++){
            int a1 = arr[i].length;
            int a2 = arr[i+1].length;
            int sum = a1 + a2;
            int[] a = new int[sum];
            while (a1-1>=0&&a2-1>=0){
                if(arr[i][a1-1]>arr[i+1][a2-1]){
                    a[sum-1]=arr[i][a1-1];
                    a1--;
                }else {
                    a[sum-1]=arr[i+1][a2-1];
                    a2--;
                }
                sum--;
            }
            while (a1-1>=0){
                a[sum-1]=arr[i][a1-1];
                a1--;
                sum--;
            }
            while (a2-1>=0){
                a[sum-1]=arr[i+1][a2-1];
                a2--;
                sum--;
            }
            arr[i+1]=a;
        }
        int num = arr[n-1].length;
        for(int i = 0; i <num;i++){
            System.out.print(arr[n-1][i] + " ");
        }
    }
}
