public class project1 {
    public static void main(String[] args) {
//        int[] arr = {-20,11,-4,13,-5,-2};
        int[] arr = {1,2,3,4,5,6};
        int max;
        max = maxSum(arr);
        System.out.println("最大子段和为："+max);

    }
    public static int maxSum(int[] arr){
        int sum=arr[0];
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (sum + arr[i] > arr[i]){
                sum += arr[i];
            }else{
                sum = arr[i];
            }
            if (max<sum){
                max=sum;
            }
        }
        return max;
    }
}
