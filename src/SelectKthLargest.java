import java.util.Random;

/**
 * @author likexue
 * @create 2019/11/2618:02
 **/
public class SelectKthLargest {
    private static Random random = new Random();
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,5,6,10,7,15};
        int k = 8;
        select(arr,0,arr.length-1
                ,k);
        System.out.println(arr[k-1]);
    }
    public static void select(int[] arr,int left, int right, int k){
            if (k>arr.length){
                throw new RuntimeException("查找长度大于数组长度");
            }
            int i = 0;
            while (i < arr.length) {
                int p = pivot(arr, left, right);
                if (p + 1 == k) {
                    return;
                }
                if (p + 1 > k) {
                    right = p - 1;
                }
                if (p + 1 < k) {
                    left = p + 1;
                }
                i++;
            }
    }
    public static int pivot(int[] arr,int left, int right){
        //int x = left + random.nextInt(right-left+1);
        int temp = arr[left];
        int x = left;
        while(left < right) {
            while (left < right && arr[right] > temp) {
                right--;
            }
            if (left < right) {
                arr[x] = arr[right];
                x = right;
            }
            while (left < right && arr[left] < temp) {
                left++;
            }
            if (left < right) {
                arr[x] = arr[left];
                right--;
            }
        }
        arr[x] = temp;
        return x;
    }
}
