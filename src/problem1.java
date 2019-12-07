/**
 * @author likexue
 * @create 2019/10/2916:47
 **/
public class problem1 {
    public static String tust = "TUST精英协会";
    public static int sum = 0;
    public static void main(String[] args) {
        String[]arr ={
                "TUST精",
                "UST精英",
                "ST精英协",
                "T精英协会"
        };
        path(arr,0,0,0);
        System.out.println(sum);
    }
    public static void path(String[] arr,int i,int j,int n){
        if (i>=4||j>=5){
            return;
        }
        if (n<8&&arr[i].charAt(j)==tust.charAt(n)){
            n++;
        }
        if(n==8){
            sum++;
            return;
        }

        path(arr,i+1,j,n);
        path(arr,i,j+1,n);
    }
}
