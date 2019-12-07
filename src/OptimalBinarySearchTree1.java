/**
 * @author likexue
 * @create 2019/12/212:38
 * 此方法的时间复杂度比较高，是指数级别的，因为重复计算了很多节点的值
 **/
public class OptimalBinarySearchTree1 {
    static int optCost(int[] freq,int i,int j){
        if (i > j){
            return 0;
        }
        if (i == j){
            return freq[i];
        }
        /**
         *这里是每迭代一层就加从i到j的freq值
         * 举例
         *      34    第一层
         *     /  \
         *   8     50 第二层
         *   这里的8和50都需要乘2，就相当于加了两遍
         *   所以在每一层都会执行sum函数，但是区间不同
         * */
        int fsum = sum(freq,i,j);
        int min = Integer.MAX_VALUE;
        /**
         * 加for循环是为了使每种情况都会被考虑到
         */
        for (int k = i;k <= j; k++){
            int cost = optCost(freq,i,k-1) + optCost(freq,k+1,j);
            if (cost < min){
                min = cost;
            }
        }
        return fsum + min;
    }

    static int sum(int[] freq, int i, int j) {
        int sum = 0;
        for (;i <= j ;i++){
            sum += freq[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] freq = {34,8,50};
        int n = freq.length;
        int cost = optCost(freq,0,n-1);
        System.out.println(cost);
    }
}
