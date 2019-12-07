/**
 * @author likexue
 * @create 2019/10/2417:21
 **/
public class MergeSort {
    public static void main(String[] args) {
//        int[]arr={5,2,1,5,65,6,7,4,7,8};
        int[] arr = {2,1,3};
        merge_sort(arr,0,arr.length-1);
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void merge_sort(int[] arr,int l,int r){
        if (l<r){
            int mid = (l+r)/2;
            merge_sort(arr,l,mid);
            merge_sort(arr,mid+1,r);
            merge(arr,l,r,mid);
        }
    }
    public static void merge(int[]arr,int l,int r,int mid){
        int[] temp = new int[r-l+1];
        int i = l;
        int j = mid + 1;
        int m = 0;
        while(i <= mid &&j <= r){
            if(arr[i] > arr[j]){
                temp[m] = arr[j];
                j++;
            }else {
                temp[m] = arr[i];
                i++;
            }
            m++;
        }
        while (i <= mid){
            temp[m] = arr[i];
            i++;
            m++;
        }
        while (j <= r){
            temp[m] = arr[j];
            j++;
            m++;
        }
        for (int x = 0;x < r-l+1;x++){
            arr[l+x] = temp[x];
        }
    }
}
