import java.util.HashMap;
import java.util.Map;

/**
 * @author likexue
 * @create 2019/11/1115:23
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] resutl = twoSum1(nums,9);
        System.out.println(resutl[0]+" "+resutl[1]);
    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = -1;
        }
        for(int i = 0; i < nums.length; i++){
            if ((target-nums[i]>=0)) {
                if (arr[target - nums[i]] != -1) {
                    int[] result = {arr[target - nums[i]], i};
                    return result;
                } else {
                    arr[nums[i]] = i;
                }
            }
        }
        return null;
    }
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target-nums[i])!=null){
                int[] result = {map.get(target-nums[i]),i};
                return result;
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
