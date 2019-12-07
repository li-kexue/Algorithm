/**
 * @author likexue
 * @create 2019/11/711:23
 **/
public class PrimeCircle1 {
    static int n = 20;
    static int[] a = new int[20];
    public static void main(String[] args) {
        int[] arr = new int[20];
        int[] judge = new int[21];
        primeCircle(n);
    }
    public static void primeCircle(int n) {
        int i, k;
        a[0] = 1;
        k = 1;
        while (k >= 1) {
            a[k] = a[k] + 1;
            while (a[k] <= n) {
                if (Check(k)) {
                    break;
                } else {
                    a[k] = a[k] + 1;
                }
            }
            if (a[k] <= n && k == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[j] + " ");
                }
                return;
            }
            if (a[k] <= n && k < n - 1) {
                k = k + 1;
            } else {
                a[k--] = 0;
            }
        }
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
    public static boolean Check(int k) {
        boolean flag = false;
        for (int i = 0; i < k; i++) {
            if (a[i] == a[k]) {
                return false;
            }
        }
        flag = isPrime(a[k] + a[k - 1]);
        if (flag && k == n - 1) {
            flag = isPrime(a[k] + a[0]);
        }
        return flag;
    }
}
