/**
 * @author likexue
 * @create 2019/11/2515:19
 **/
public class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        String s = countAndSay(n);
        System.out.println(s);
    }
    public static String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        StringBuilder result = null;
        int i = 1;
        while(i<n){
            result = new StringBuilder(100);
            int k = 1;
            char x = sb.charAt(0);
            for(int j = 1; j < sb.length(); j++){
                if(x == sb.charAt(j)){
                    k++;
                }else{
                    result.append(x);
                    result.append(k);
                    k = 1;
                    x = sb.charAt(j);
                }

            }
            result.append(x);
            result.append(k);
            sb = result;
            i++;
        }
        return result.toString();
    }

}
