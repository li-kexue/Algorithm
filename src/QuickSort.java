/**
 * @author likexue
 * @create 2019/10/248:43
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[]arr={5,2,1,5,65,6,7,4,7,8};
        quick_sort(arr,0,arr.length-1);
        for(int i = 0;i <arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
//    public static void sort(int[] arr, int l, int r){
//        if (l<r){
//            int i = l,j = r;
//            int tag = arr[l];
//            while(i<j){
//                while (i<j&&arr[j]>=tag){
//                    j--;
//                }
//                if (i<j){
//                    arr[i++] = arr[j];
//                }
//                while(i<j&&arr[i]<tag){
//                    i++;
//                }
//                if (i<j){
//                    arr[j--]=arr[i];
//                }
//            }
//            arr[i]=tag;
//            sort(arr,l,i-1);
//            sort(arr,i+1,r);
//        }
//        }
    public static int change(int[] arr,int l,int r){
        /**
         * 设置哨兵
         */
        int guard = arr[l];
        /**
         * 设置指针指向数组的首尾元素
         */
        int i = l, j = r;
        while(i<j){
            /**
             * 先从j开始比较
             */
            while (i < j && arr[j] >= guard){
                j--;
            }
            /**
             * 当j指向的元素比哨兵大的时候，将j指向的元素
             * 赋值给i指向的位置,i++,但是要保证i<j
             */
            if (i<j){
                arr[i++] = arr[j];
            }
            /**
             * 现在开始从i指向的位置与哨兵比较
             */
            while(i < j && arr[i] < guard){
                i++;
            }
            if(i < j){
                arr[j--] = arr[i];
            }
        }
        /**
         * 将哨兵的值赋给最后一个空缺的位置
         */
        arr[i] = guard;
        return i;
    }

    public static void quick_sort(int[] arr, int l,int r){
        if (l<r){
            int boundry;
            boundry = change(arr,l,r);
            quick_sort(arr,l,boundry-1);
            quick_sort(arr,boundry+1,r);
        }
    }
}
