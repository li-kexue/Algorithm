/**
 * @author likexue
 * @create 2019/11/79:57
 **/
public class PrimeCircle2 {
    static int n = 20;
    static int[] a = new int[20];

    public static void main(String[] args) {
        int[] arr = new int[n];
        int[] judge = new int[n + 1];
        arr[0] = 1;
        judge[1] = 1;
        f(arr, judge, 1);
    }

    public static boolean f(int[] arr, int[] judge, int k) {
        if (k >= n) {
            int x = arr[0] + arr[n - 1];
            if (isPrime(x)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                /**
                 * 因为结果有很多种，只让其输出第一种结果
                 */
                return true;
            }
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (judge[i] == 0) {
                int x = i + arr[k - 1];
                if (isPrime(x)) {
                    judge[i] = 1;
                    arr[k] = i;
                    if (f(arr, judge, k + 1)) {
                        return true;
                    }
                    judge[i] = 0;
                }
            }
        }
        return false;
    }


    public static boolean isPrime(int x) {
        int m = (int) Math.sqrt(x);
        for (int i = 2; i <= m; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
