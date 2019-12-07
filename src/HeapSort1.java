import java.util.Arrays;

/**
 * @author likexue
 * @create 2019/11/2919:06
 **/
public class HeapSort1 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1, 7, 8};
        sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
         Arrays.asList(arr).stream().forEach(e->System.out.println(e));
    }

    public static void heapify(int[] arr, int index, int n) {
        if (index * 2 + 1 < n) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int max = index;
            if (arr[max] < arr[left]) {
                max = left;
            }
            if (right < n && arr[max] < arr[right]) {
                max = right;
            }
            if (max != index) {
                swap(arr, index, max);
                heapify(arr, max, n);
            }
        }
    }

    public static void buildHeap(int[] arr,int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public static void sort(int[] arr) {
        buildHeap(arr,arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void swap(int[] arr, int parent, int max_index) {
        int temp = arr[parent];
        arr[parent] = arr[max_index];
        arr[max_index] = temp;
    }
}
