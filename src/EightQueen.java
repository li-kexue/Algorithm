import java.util.Random;

/**
 * @author likexue
 * @create 2019/11/2110:14
 **/
public class EightQueen {
    /**
     * 产生随机数
     */
    static Random random = new Random();
    public static void main(String[] args) {
        queen();
    }

    public static void queen() {
        int k = 0;
        int n = 8;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        while (k >= 0) {
            if (k == 1||k == 2){
                arr[k] = random.nextInt(9);
            }else {
                arr[k]++;
            }
            while (arr[k] < n && judge(arr, k)) {
                arr[k]++;
            }
            if (k == n - 1 && arr[k] < n) {
                for (int i = 0; i < n; i++) {
                    /**
                     * 格式化输出
                     */
                    if (i == 0) {
                        System.out.print("  ");
                        for (int m = 1; m <= n; m++) {
                            System.out.print(m + " ");
                        }
                        System.out.println();
                    }
                    System.out.print((i+1)+" ");
                    for (int j = 0; j < n; j++) {
                        if (j == arr[i]){
                            System.out.print(arr[i]+1+" ");
                        }else{
                            System.out.print("* ");
                        }
                    }
                    System.out.println();
                }
                return;
            }
            if (k < n - 1 && arr[k] < n) {
                k++;
            } else {
                arr[k--] = -1;
            }
        }
        System.out.println("无解");
    }

    /**
     * 判断是否符合八皇后的行列以及对角线的要求
     * @param arr
     * @param n
     * @return
     */
    public static boolean judge(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return true;
            }
        }
        return false;
    }
}
