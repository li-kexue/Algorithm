import java.util.Arrays;

/**
 * @author likexue
 * @create 2019/10/1015:34
 **/
public class project3 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4};
        int[] arr = {1,2,3,4,5,6};
//        int min= currencyExchange(arr,10);
        int min= currencyExchange(arr,20);
        System.out.println("最少张数为："+min);
    }

    public  static int currencyExchange(int[] value, int y) {
        int max = y + 1;
        int[] dp = new int[y + 1];
        for (int i = 0, len = dp.length; i < len; i++){
            dp[i]=max;
        }
        dp[0] = 0;
        for (int i = 1; i <= y; i++) {
            for (int j = 0; j < value.length; j++) {
                if (value[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - value[j]] + 1);
                }
            }
        }
        return dp[y] > y ? -1 : dp[y];
    }

}
