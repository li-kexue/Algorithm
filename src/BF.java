/**
 * @author likexue
 * @create 2019/11/1921:20
 **/
public class BF {
    public static void main(String[] args) {
        String str1 = "123123234";
        String str2 = "31";
        boolean result = bf(str1,str2);
        System.out.println("str1中是否包含str2:"+result);
    }
    public static boolean bf(String str1, String str2){
        int i = 0,j = 0,index = 0;
        while(i<str1.length()&&j<str2.length()){
            /**
             * 当str1[i]==str2[j]时，i,j同时加一
             * 当不相等时，j移动到0位置,i移动到index记录的下一位
             * 结合图片会更容易理解
             */
            if (str1.charAt(i)==str2.charAt(j)){
                i++;
                j++;
            }else {
                index++;
                i = index;
                j = 0;
            }
        }
        if (j == str2.length()){
            return true;
        }else {
            return false;
        }
    }
}
