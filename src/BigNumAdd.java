import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/11/99:35
 **/
public class BigNumAdd {
    static int ZERO = 48;

    public static void main(String[] args) {
        String s;
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        /**
         * 防止下面的nextLine读取到nextInt的换行
         */
        input.nextLine();
        for (int i = 1; i <= n; i++) {
            s = input.nextLine();
            /**
             * 两数之间通过空格隔开，通过空格使其分割成两个字符串
             */
            String[] num = s.split(" ");
            add(num[0], num[1], i);
            if (i!=n){
                System.out.println();
            }
        }

    }

    public static void add(String a, String b, int n) {
            int x = a.length() - 1;
            int y = b.length() - 1;
            int i = 0;
            int[] result;
            /**
             * 这里为什么用if判断，在下面Calculate()函数解释
             */
            if (x >= y) {
                result = Calculate(a, b);
            } else {
                result = Calculate(b, a);
            }
            /**
             * 这里是输出格式，不然不能AC
             */
            System.out.println("Case "+n+":");
            System.out.print(a + " + " + b + " = ");
            for (i = 0; i < result.length; i++) {
                /**
                 * 因为数组申请的比两个相加得数长一位
                 * 但是这位可能不进位，那这位可能是0，那就不用输出
                 */
                if (i==0&&result[i]== 0) {
                    continue;
                }
                System.out.print(result[i]);
            }
            System.out.println();
    }

    public static int[] Calculate(String a, String b) {
        int carry = 0;
        int temp;
        int x = a.length() - 1;
        int y = b.length() - 1;
        int max = x > y ? x + 1 : y + 1;
        /**
         * 声明的result数组的长度要比a,b数组中最长的还要长一位
         * 防止最后不能进位。
         * 比如9 + 1 = 10
         * a，b长度都是1
         * result长度声明为1，最后进位的1将会丢失
         */
        int[] result = new int[max + 1];
        /**
         * 这里解释add()函数为什么用判断语句
         * 因为这里是直接默认字符串a是较长的。
         * 比如说1234 + 1 = 1235
         * 前三位可以直接赋值给数组，所以要判断哪个最长
         * 而且还要防止下标越界，两数相加，只能相加到最短
         * 的那个数组的长度。1234 + 1 = 1235只能1和4加，再往后
         * 数组b将会越界
         */
        while (y >= 0) {
            /**
             * ZERO是字符0的ascii码，每次相加得加上上次进位的结果carry
             */
            temp = (a.charAt(x) - ZERO) + (b.charAt(y) - ZERO) + carry;
            carry = temp / 10;
            temp %= 10;
            result[max--] = temp;
            x--;
            y--;
        }
        /**
         * 将a数组多出的部分赋值给result,
         * 考虑特殊情况1234 + 66 = 1300
         * 本来a数组比b数组长二，但是由于十位相加进位了，所以
         * 2要加1
         */
        while (x >= 0) {
            if (carry != 0) {
                temp = (a.charAt(x) - ZERO) + carry;
                carry = temp / 10;
                temp %= 10;
                result[max--] = temp;
                x--;
            } else {
                result[max--] = a.charAt(x--)-ZERO;
            }
        }
        /**
         * 这里也是防止进位
         * 9 + 1 = 10
         * result[0] = 1
         * 不然将会丢失进位
         */
        result[max] = carry;
        return result;
    }
}
