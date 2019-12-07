/**
 * @author likexue
 * @create 2019/12/215:26
 **/
public class OptimalBinarySearchTree2 {
    static double optimalBinarySearchTree(double[][] C,int[][] R,double[] freq,int n){
        /**
         * 初始化(n+1)*n的矩阵
         * 主对角线的值全为0
         * 次对角线的值为freq的值
         */
        for (int i = 1; i <= n; i++) {
            C[i][i-1] = 0;
            C[i][i] = freq[i-1];
            R[i][i] = i;
        }
        C[n+1][n] = 0;
        for (int d = 1;d < n; d++) {
            for (int i = 1;i <= n - d; i++) {
                int j = i + d;
                double min = Double.MAX_VALUE;
                double sum = 0;
                int mark = i;
                for (int k = i; k <= j; k++) {
                    sum += freq[k-1];
                    if (C[i][k-1] + C[k+1][j] < min){
                        min = C[i][k-1] + C[k+1][j];
                        mark = k;
                    }
                }
                C[i][j] = min + sum;
                R[i][j] = mark;
            }
        }
        return C[1][n];
    }

    public static void main(String[] args) {
        int n = 5;
        double[][] C = new double[n+1][n];
        int[][] R = new int[n+1][n];
        double[] freq = {0.1,0.2,0.4,0.3};
        double cost = optimalBinarySearchTree(C,R,freq,n-1);
        System.out.println(cost);
    }
}
