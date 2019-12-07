/**
 * @author likexue
 * @create 2019/9/2919:12
 **/
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-9,-6};
        System.out.println(maxProduct(nums));
//        int sum=0;
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<nums.length;i++){
//            if (sum+nums[i]>nums[i]){
//                sum+=nums[i];
//            }else{
//                sum=nums[i];
//            }
//            if (max<sum){
//                max=sum;
//            }
//        }
//        System.out.println(max);

    }

    public static int maxProduct(int[] nums) {
//        int sum = 1;
        int curMax = nums[0];
        int curMin = nums[0];
        int result = nums[0];
        for(int i=1; i < nums.length; i++){
           curMax=curMax*nums[i];
           curMin=curMin*nums[i];
           int tempMax = curMax;
           int tempMin = curMin;
           curMin=min(tempMax,tempMin,nums[i]);
           curMax=max(tempMax,tempMin,nums[i]);

           if (curMax>result){
               result=curMax;
           }
        }
        return result;
    }

    public static int max(int a, int b, int c){
        int temp = Math.max(a,b);
        if (temp>c){
            return temp;
        }else {
            return c;
        }
    }
    public static int min(int a, int b, int c){
        int temp = Math.min(a,b);
        if (temp<c){
            return temp;
        }else {
            return c;
        }
    }
    public static int maxProductPro(int[] nums) {
        int sum ;
        int max = nums[0];
        if (nums.length==1){
            return nums[0];
        }
        for(int i=0; i < nums.length; i++){
            sum=1;
            for (int j = i; j < nums.length; j++){
                sum*=nums[j];
                if (sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }
}
