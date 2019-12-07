/**
 * @author likexue
 * @create 2019/11/1419:40
 **/
public class LongestSubString {
    public static void main(String[] args) {
        String s = "dvdf";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max = 0;
        if (s == null){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        int i = 0;
        int j = -1;
        int[] next = new int[1000];
        next[0] = -1;
        while(j==-1||i < s.length()){
            if (j==-1||s.charAt(j)==s.charAt(i)){
                next[++i] = ++j;
            }else {
                j = next[j];
            }
        }
        i = 0;
        j = 0;
        int len1 = s.length();
        int len2 = next.length;
        while (i < len1){
            if (j==-1||s.charAt(i)==next[j]){
                i++;
                j++;
                result++;
            }else {
                if (result>max){
                    max = result;
                }
                result=1;
                j = next[j];
            }
        }
        if (result>max){
            max = result;
        }
        return max;
    }
}
