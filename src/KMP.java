/**
 * @author likexue
 * @create 2019/12/615:55
 **/
public class KMP {
    public static void main(String[] args) {
        String s = "ababaedaabacabcaduwieas";
        String p = "abacabca";
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        int[] next = new int[pattern.length+1];
        getNext(pattern,next);
        kmp(chars,pattern,next);
//        for (int i = 0; i < next.length; i++){
//            System.out.println(next[i]);
//        }
    }
    public static void getNext(char[] pattern,int[] next){
        //为i和j赋初始值
        int i = 0,j = -1;
        //首先为第一位赋值为-1,
        next[0] = -1;
        //获取模式串的长度
        int len = pattern.length;
        while(j == -1|| i < len){
            /**
             * 这里如果j是-1，++j就是零，
             * 或者他们相等的话就将next值在原有的基础上加一
             * 那我们就可以将这两种情况统一成下面这种形式，
             * 否则就让他匹配第二长的最长公共前后缀
             */
              if (j == -1||pattern[i] == pattern[j]){
                  next[++i] = ++j;
              }else {
                  j = next[j];
              }
        }
    }
    public static void kmp(char[] s,char[] pattern,int[] next){
        int j = 0,i = 0;
        //主串长度
        int len1 = s.length;
        //模式串长度
        int len2 = pattern.length;
        //begin和end表示模式串在主串的开始和结束位置
        int begin = 0,end = 0;
        while (i < len1){
            if (j == -1||s[i] == pattern[j]){
                i++;
                j++;
            } else {
                j = next[j];
                begin = i - j;
            }
            if(j == len2){
                end = i;
                break;
            }
        }
        if (j == len2){
            System.out.println("模式串在主串的下标为从"+begin+"到"+end);
        }else {
            System.out.println("没有匹配的字符串");
        }
    }
}
