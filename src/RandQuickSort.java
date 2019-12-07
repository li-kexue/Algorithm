import java.util.Random;

/**
 * @author likexue
 * @create 2019/11/2110:25
 **/
public class RandQuickSort {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,6,5,7};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int temp, i, k;
        if (left < right) {
            /**
             * 使轴值随机产生
             */
            i = left + random.nextInt(right - left);
            temp = arr[left];
            arr[left] = arr[i];
            arr[i] = temp;
            k = Partition(arr, left, right);
            /**
             * 递归
             */
            quickSort(arr, left, k - 1);
            quickSort(arr, k + 1, right);
        }
    }

    /**
     * 确定轴值的位置，并将每个大于轴值的元素放轴值右边，小于的放左边
     * 最后返回轴值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int Partition(int[] arr, int left, int right) {
        int tag = arr[left];
        while (left < right) {
            while (right > left && arr[right] >= tag) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            while (left < right && arr[left] <= tag) {
                left++;
            }
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                right--;
            }
        }
        return left;
    }
}
