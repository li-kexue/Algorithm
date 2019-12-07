import java.util.Random;

/**
 * @author likexue
 * @create 2019/11/2711:24
 **/
public class BucketSort {
    public static void main(String[] args) {
        Random random = new Random(3);
        int[] arr = new int[10];
        for (int i = 0;i < arr.length;i++){
            arr[i] = random.nextInt(arr.length);
        }
        //int[] arr = {1,1,2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bucketSort(arr,4);
        //quickSort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 桶排序
     * @param arr 待排序数组
     * @param bucketSize 自定义桶的大小
     */
    public static void bucketSort(int[] arr,int bucketSize){
        if (arr.length < 2){
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];

        /**
         * 首先找到数组的大小区间
         * minValue~maxValue
         */
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < minValue){
                minValue = arr[i];
            }
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }

        /**
         * bucketCount 桶的数量
         */
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        /**
         * 声明一个二维数组
         * 代表bucketCount个bucketSize大小的桶
         */
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] index = new int[bucketCount];
        /**
         * 将数据放入对应的桶中
         */
        for (int i = 0; i < arr.length;i++){
            /**
             * 计算当前数据属于哪个桶
             */
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            /**
             * 判断桶是否够大
             */
            if (index[bucketIndex] == buckets[bucketIndex].length){
                /**
                 * 当桶不够大的时候扩容
                 */
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][index[bucketIndex]++] = arr[i];
        }
        int k = 0;

        /**
         * 对每一个桶内的数据进行快速排序
         */
        for (int i = 0;i < buckets.length;i++){
            /**
             * 当桶的大小为零时，表示没有此区间的数据，直接跳过
             */
            if (index[i] == 0){
                continue;
            }
            quickSort(buckets[i],0,index[i] - 1);
            /**
             * 将排好序的数据重新放入数组
             */
            for (int j = 0; j < index[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }

    }

    /**
     * 扩容函数
     * @param buckets 待扩容的数组
     * @param bucketIndex 待扩容数组的下标
     */
    public static void ensureCapacity(int[][] buckets,int bucketIndex){
        int length = buckets[bucketIndex].length;
        int[] temp = new int[length*2];
        for (int i = 0;i < length;i++){
            temp[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = temp;
    }

    public static void quickSort(int[] arr,int left,int right){
        if (arr.length < 2){
            return;
        }
        if (left<right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr,pivot+1,right);
        }
    }

    /**
     * 分区函数
     * 确定pivot的位置，并且将大于分段点的数置于其右边
     * 小于放于其左边
     * @param arr 待分区数组
     * @param left 待分区的左端点
     * @param right 待分区的右端点
     * @return 返回分区点
     */
    public static int partition(int[] arr,int left,int right){
        int value = arr[left];
        while(left < right){
            while (left < right && arr[right] >= value){
                right--;
            }
            if (left < right){
                swap(arr,right,left);
                left++;
            }
            while (left < right && arr[left] <= value){
                left++;
            }
            if (left < right){
                swap(arr,left,right);
                right--;
            }
        }
        return left;
    }

    /**
     * 交换函数
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
