/**
 * @author likexue
 * @create 2019/10/1216:27
 **/
public class MaxSubsectionSum {
    public static void main(String[] args) {
        String a="abcbdab";
        String b="acbbabdbb";
//        int sum = MaxSubsequence(a,b,a.length()-1,b.length()-1);
        int sum = dp(a,b);
        System.out.println(sum);
    }
    public static int MaxSubsequence(String a, String b, int i, int j){
        if (i<0||j<0){
            return 0;
        }
        if (a.charAt(i)==b.charAt(j)){
            return MaxSubsequence(a,b,i-1,j-1)+1;
        }else {
            return Math.max(MaxSubsequence(a, b, i - 1, j), MaxSubsequence(a, b, i, j - 1));
        }
    }
    public static int dp(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] arr = new int[m+1][n+1];
        /**
         * 根据推导公式，如果X_i==Y_j，arr[i][j]=arr[i-1][j-1],
         * 否则arr[i][j]=Max{arr[i-1][j],arr[i][j-1]}
         */
        for(int i=1; i<=m; i++){
            for (int j=1;j<=n; j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                } else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr[m][n];
    }
}
