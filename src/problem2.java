import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/10/2918:43
 **/
public class problem2 {
    static int[] M={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int n = input.nextInt();
        int year = 1777;
        int month = 4;
        int day = 30;
        System.out.println("n="+n);
        for (int i = 1; i< n;i++){
            if (isLeapYear(year)){
                M[2]=29;
            }else {
                M[2]=28;
            }
            if (day<M[month]){
                day++;
            }else {
                month++;
                day = 1;
            }
            if(month==13){
                year++;
                month = 1;
            }
        }
        System.out.println(year+"年"+month+"月"+day+"日");
    }
    public static boolean isLeapYear(int x){
        if (x%4==0&&x%100!=0){
            return true;
        }
        if (x%400==0){
            return true;
        }
        return false;
    }
}
